package com.samplejunit.junitmockito.controller;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Splitter;
import com.samplejunit.junitmockito.entity.GithubUser;
import com.samplejunit.junitmockito.entity.Student;
import com.samplejunit.junitmockito.service.StudentService;
import org.apache.http.client.*;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


@RequestMapping("")
@RestController
public class StudentController {

    private static final String CLIENT_ID = "2e4c3f8a8c8f1dd01ede";
    private static final String CLIENT_SECRET = "43b9f1e40366ea35e20ac78f49cf573519eaa366";
    private static final String CALLBACK_URL = "http://localhost:9191/callback";

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE);

    @RequestMapping("")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @RequestMapping("/redirectToGithub")
    public void redirectToGithub(HttpServletResponse response) throws IOException {
         response.sendRedirect("https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID + "&redirect_uri=" + CALLBACK_URL);
    }

    @RequestMapping("/callback")
    public ModelAndView callbackWithoutScribe(@RequestParam String code) throws Exception {
        HttpPost post = new HttpPost("https://github.com/login/oauth/access_token");

        List<BasicNameValuePair> parameters = new ArrayList<>();
        parameters.add(new BasicNameValuePair("client_id", CLIENT_ID));
        parameters.add(new BasicNameValuePair("client_secret", CLIENT_SECRET));
        parameters.add(new BasicNameValuePair("code", code));
        post.setEntity(new UrlEncodedFormEntity(parameters, "utf-8"));

       
        HttpClient httpClient = HttpClients.createDefault();
        HttpResponse response = httpClient.execute(post);
        HttpEntity httpEntity = response.getEntity();
        String result = EntityUtils.toString(httpEntity, "utf-8");
        Map<String, String> map = Splitter.on("&").withKeyValueSeparator("=").split(result);
        String accessToken = map.get("access_token");

        
        HttpGet get = new HttpGet("https://api.github.com/user");
        get.addHeader("Authorization", "token " + accessToken);
        HttpResponse getResponse = httpClient.execute(get);
        String json = EntityUtils.toString(getResponse.getEntity(), "utf-8");
        GithubUser githubUser = objectMapper.readValue(json, GithubUser.class);

        
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("githubUser", githubUser);
        return mv;
    }
    
    @Autowired
	StudentService service;
	
@GetMapping("/getStudentbyId/{stuid}")	
 public Student getStudent(@PathVariable int stuid) {
	 return service.getStudent(stuid);
 }
 
@PostMapping("/addStudent")
 public Student addStudent(@RequestBody Student student)
 {
	 return service.addStudent(student);
 }


@GetMapping("/getAllStudents")	
public List<Student> getAllStudents() {
	 return service.getAllStudents();
}

}

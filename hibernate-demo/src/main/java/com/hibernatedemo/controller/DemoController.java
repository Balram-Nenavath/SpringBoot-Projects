package com.hibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernatedemo.entity.Demo;
import com.hibernatedemo.service.IDemoService;

@RestController
public class DemoController {

	@Autowired
	IDemoService demoService;

	@GetMapping("/demo")
	public ResponseEntity<?> getAllDemo() {
		try {
			List<Demo> demos = demoService.getAllDemos();
			if (demos != null && !CollectionUtils.isEmpty(demos)) {
				return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("no demo items found", HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/demo/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		try {
			Demo demos = demoService.getDemoById(id);
			if (demos != null && !ObjectUtils.isEmpty(demos)) {
				return new ResponseEntity<Demo>(demos, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/demo")
	public ResponseEntity<?> saveDemo(@RequestBody Demo demo) {
		try {
			Demo demos = demoService.saveDemo(demo);
			if (demos != null && !ObjectUtils.isEmpty(demos)) {
				return new ResponseEntity<Demo>(demos, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error while saving demo", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/demo/{id}")
	public ResponseEntity<?> updateDemo(@PathVariable Long id, @RequestBody Demo demo) {
		try {
			String demos = demoService.demoDetailsUpdate(id, demo);
			if (demos != null && !ObjectUtils.isEmpty(demos)) {
				return new ResponseEntity<String>(demos, HttpStatus.OK);
			} else {
				return new ResponseEntity<String>("Error while updating demo", HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/demoCriteria")
	public ResponseEntity<?> getAllDemoUsingCriteria() {
		List<Demo> demos = demoService.criteriaGetAllExample();
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoEq")
	public ResponseEntity<?> getAllEq(@RequestParam("name") String name) {
		List<Demo> demos = demoService.criteriaEq(name);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoNe")
	public ResponseEntity<?> getAllNE(@RequestParam("name") String name) {
		List<Demo> demos = demoService.criteriaNe(name);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoGt")
	public ResponseEntity<?> getAllGt(@RequestParam("score") Long score) {
		List<Demo> demos = demoService.criteriaGt(score);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoGE")
	public ResponseEntity<?> getAllGE(@RequestParam("score") Long score) {
		List<Demo> demos = demoService.criteriaGe(score);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoLT")
	public ResponseEntity<?> getAllLT(@RequestParam("score") Long score) {
		List<Demo> demos = demoService.criteriaLt(score);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoLE")
	public ResponseEntity<?> getAllLE(@RequestParam("score") Long score) {
		List<Demo> demos = demoService.criteriaLe(score);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoOr")
	public ResponseEntity<?> getAllwithOR(@RequestParam("score") Long score, @RequestParam("name") String name) {
		List<Demo> demos = demoService.criteriaMultipleRestrictions(score, name);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoAnd")
	public ResponseEntity<?> getAllwithAnd(@RequestParam("score") Long score, @RequestParam("name") String name) {
		List<Demo> demos = demoService.criteriaAnd(score, name);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoDisjunction")
	public ResponseEntity<?> getAllwithDisjunction(@RequestParam("score") Long score,
			@RequestParam("name") String name) {
		List<Demo> demos = demoService.criteriaDisjunction(score, name);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}

	@GetMapping("/demoPagination")
	public ResponseEntity<?> getAllwithPagination(@RequestParam("pageNo") Long pageNo,
			@RequestParam("maxNo") Long maxNo) {
		List<Demo> demos = demoService.criteriaPagination(pageNo, maxNo);
		if (demos != null) {
			return new ResponseEntity<List<Demo>>(demos, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("no demo item found", HttpStatus.OK);
		}

	}
}

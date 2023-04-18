package com.openfeign.serviceD;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ServiceA")
@RibbonClient(name = "ServiceA")
public interface ServiceAproxy {
	@RequestMapping(method = RequestMethod.GET, value = "/demo")
	List<Object> getDemoItems();

}

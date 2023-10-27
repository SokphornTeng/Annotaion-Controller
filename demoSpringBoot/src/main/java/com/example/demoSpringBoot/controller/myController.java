package com.example.demoSpringBoot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demoSpringBoot.DataDTO.dataList;
import com.example.demoSpringBoot.ResponseBodyTest.DTO;

@Controller
public class myController {
  
//	Method just return text as response body as json
	@RequestMapping("/show")
	@ResponseBody
	public String show() {
		return "Hello world!";
	}
	
//	Method return with file html5 and add model
	@RequestMapping("/show1")
	public String show1(Model model) {
		model.addAttribute("name", "Hello Sokphorn Teng");
		return "Show1";
	}
	
	
//	Method return of RequestParam with add value to model
	@RequestMapping("/show2")
	public String show2(Model model, @RequestParam(value = "list", defaultValue = "Nothing to show") String list) {
		model.addAttribute("myList", list);
		return "Show2";
	}

	
// Method return with Pathvirable with add value into model
	@RequestMapping("/show3/{listing}")
	public String show3(Model model, @PathVariable("listing") String listing) {
		model.addAttribute("showList", listing);
		return "show3";
	}
	
//	Method return with RequestBody
	@PostMapping("/show4")
	@ResponseBody
	public dataList show4(@RequestBody dataList myListing ) {
		return myListing;
	}
	

//	Method of ResponseBody that use for web server response object as json to client use for api
	@RequestMapping("/show5")
	@ResponseBody
	public DTO show5() {
		DTO newDTO = new DTO();
		newDTO.setUsername("Sokphorn Teng");
		newDTO.setPassword("st1998@123");
		return newDTO;
	}
	
//	Method of ResponseEntity we can customise response data from controller
	@RequestMapping("/show6")
	public  ResponseEntity<Map<String, Object>> show6() {
		
		DTO newDTO = new DTO();
		newDTO.setUsername("Sokphorn");
		newDTO.setPassword("st1998@123");
		
		Map<String, Object> map = new HashMap<>();
		map.put("Status", true);
		map.put("Data", newDTO);
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
	
}



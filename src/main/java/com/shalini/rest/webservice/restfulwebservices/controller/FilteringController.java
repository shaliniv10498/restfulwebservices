package com.shalini.rest.webservice.restfulwebservices.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shalini.rest.webservice.restfulwebservices.model.SomeBean;

/**
 * Two types of filtering static , dynamic 
 * static - filter out fields for all apis across all controllers in particular bean
 * dynamic - filter out fields for specific api in particular bean
 * 
 * */
@RestController
public class FilteringController {
   
   @GetMapping("/filter")
   public SomeBean getSomeBean() {
	   return new SomeBean("value1","value2","value3");
   }
   
   @GetMapping("/filter/list")
   public List<SomeBean> getBeanList(){
	   return  Arrays.asList(new SomeBean[] {new SomeBean("v1","v2","v3"),
			  new SomeBean("b1","b2","b3"),
			  new SomeBean("c1","c2","c3")});
	   }
   
   @GetMapping("filter/dynamic/field4")
   public MappingJacksonValue filtering() {
	   SomeBean obj = new SomeBean("v1","v2","v3","v4","v5");
	   MappingJacksonValue mapping = new MappingJacksonValue(obj);
	   SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field4");
	   FilterProvider filters = new SimpleFilterProvider()
				.addFilter("somebeanfilter", filter);
	   mapping.setFilters(filters );
	   return mapping;
   }
   
}

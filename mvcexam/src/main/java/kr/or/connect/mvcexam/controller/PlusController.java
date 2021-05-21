package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlusController {

	@GetMapping(path="/plusForm")
	public String plusform() {
		return "plusForm";
	}
	
	@PostMapping(path="plus")
	public String plus(@RequestParam(name="value1", required=true) int value1,
			@RequestParam(name="value2", required=true) int value2, ModelMap modelMap){	// required : 필수값인지
		int result = value1 + value2;
		
		// modelMap : 스프링이 제공하는 객체로 알아서 request scope에 매핑 시켜줌
		modelMap.addAttribute("value1", value1);
		modelMap.addAttribute("value2", value2);
		modelMap.addAttribute("result", result);
		
		return "plusResult";
	}
}

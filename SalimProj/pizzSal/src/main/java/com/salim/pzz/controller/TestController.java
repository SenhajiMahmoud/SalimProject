package com.salim.pzz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/a01.do")
	public ModelAndView action1() {

		System.out.println(">>>>>>action1");
		return new ModelAndView("V01");

	}

	@RequestMapping("/a02.do")
	public ModelAndView action2() {

		System.out.println(">>>>>>action2");

		return new ModelAndView("V01", "model", "message");

	}

	@RequestMapping("/a03.do")
	public ModelAndView action3() {
		System.out.println(">>>>>>action3");
		
		
		ModelAndView mav = new ModelAndView("V01");

		mav.addObject("ref", "C01");
		mav.addObject("Desig","Clavier");
		mav.addObject("pu", 50);
		
		
		return mav;

	}

}

package com.focus.ctrl.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlaceholderController {

	@RequestMapping("/${base}/index")
	public String index() {
		return "index";
	}
}

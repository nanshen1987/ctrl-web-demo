package com.focus.ctrl.demo.web.reqmap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {

	@RequestMapping("/myPath/*.do")
	public String getDemoPath() {
		return "antPathDemo";
	}
}

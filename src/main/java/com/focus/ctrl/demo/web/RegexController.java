package com.focus.ctrl.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegexController {
	@RequestMapping("/spring-web/{symbolicName:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{extension:\\.[a-z]+}")
	public void handle(@PathVariable String version,
			@PathVariable String extension) {
		// ...
		System.out.println();
	}
}

package com.focus.ctrl.demo.web.maphandler;

import java.beans.PropertyEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/orders")
public class OrderController {
	@InitBinder
	public void dataBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		PropertyEditor propertyEditor = new CustomDateEditor(dateFormat, true);
		// 第二个参数表示是否允许为空
		binder.registerCustomEditor(Date.class, propertyEditor);
	}

	@RequestMapping(method = RequestMethod.GET)
	public String update(@RequestParam int orderId) {

		System.out.println();
		return "edit";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String list(@RequestParam Date date) {
		System.out.println();
		return "index";
	}
}

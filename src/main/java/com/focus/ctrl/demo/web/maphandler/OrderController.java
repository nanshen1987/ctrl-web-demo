package com.focus.ctrl.demo.web.maphandler;

import java.beans.PropertyEditor;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping(value = "/reqbody", method = RequestMethod.PUT)
	public void reqBody(@RequestBody String body, Writer writer)
			throws IOException {
		System.out.println();
		writer.write(body);
	}

	@RequestMapping(value = "/respbody", method = RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
		return "ResponseBody";
	}

	@RequestMapping("/httpentity")
	public ResponseEntity<String> handle(HttpEntity<byte[]> requestEntity)
			throws UnsupportedEncodingException {
		String requestHeader = requestEntity.getHeaders().getFirst(
				"MyRequestHeader");
		byte[] requestBody = requestEntity.getBody();
		// do something with request header and body
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		return new ResponseEntity<String>("Hello World", responseHeaders,
				HttpStatus.CREATED);
	}
}

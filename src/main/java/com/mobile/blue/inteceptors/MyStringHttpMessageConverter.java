package com.mobile.blue.inteceptors;

import java.nio.charset.Charset;

import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;

public class MyStringHttpMessageConverter extends StringHttpMessageConverter {
	private static final MediaType utf8 = new MediaType("json", "application", Charset.forName("UTF-8"));

	@Override
	protected MediaType getDefaultContentType(String dumy) {
		return utf8;
	}
}

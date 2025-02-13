package com.web.mes021.a01_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class MessageConfig implements WebMvcConfigurer{
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource src = new ReloadableResourceBundleMessageSource();
		src.setBasename("classpath:/message/msg");
		src.setDefaultEncoding("UTF-8");
		src.setCacheSeconds(60);
		src.setUseCodeAsDefaultMessage(true);
		return src;
	}
	/*
	1. 애플리케이션에서 사용할 메시지 소스의 설정을 처리하는 위치를 지정하는 기능 메서드
	2. 다국어 지원을 위핸 번역 메시지를 읽어오는 역할을 한다.
	3. ReloadableResourceBundleMessageSource
		1) 프로퍼티 파일에서 번역 메시지를 읽어온다.
		2) msg라는 기본 이름의 메시지 파일을 지정한다.(classpath:/message/msg)
		3) 예를 들어, 다국어 메시지를 msg_ko.properties, msg_en.properties와 같은 파일에
			저장할 수 있다.
	4. 주요 설정..
		setBasename("classpath:/message/msg"); 메시지 파일의 경로와 기본 이름을 설정
		setDefaultEncoding("utf-8"); 메시지 파일의 인코딩방식을 utf-8로 설정
	 * */	
	@Bean
	public SessionLocaleResolver localeResolver() {
		return new SessionLocaleResolver();
	}
	/* 
	1. 클라이언트의 현재 언어 설정(로케일)을 관리한다.
	2. 세션을 기본으로 로케일 정보를 저장하고 관리한다.
	3. SessionLocaleResolver
		1) HTTP 세션을 통해 사용자별 로케일 정보(위치에 따라 언어 설정되기에)를 저장
		2) 기본적으로 서버가 언어 정보를 유지하여 요청 간에 일관성을 보장한다.
	 * */
	
	
	
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
		interceptor.setParamName("lang");
		return interceptor;
	}
	/*
	1. 요청 매개변수를 통해 로케일(언어)를 변경할 수 있도록 처리한다.
	2. 예를 들어, ?lang=ko와 같은 쿼리 매개변수를 사용하여 언어를 변경할 수 있다.
	3. LocaleChangeInterceptor
		언어 변경 요청을 가로채서 SessionLocaleResolver에 새로운 로케일(언어/위치) 정보를 설정
		setParamName("lang")을 통해 언어 변경에 사용할 파라미터 이름을 lang으로 지정한다.
		ex) ?lang=ko의 경우 ko(한국)으로 지정이 된다..
	 * */
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}
	/*
	1. 애플리케이션에서 사용할 인터셉터(가로채기를 해서 어떤 언어로 처리할지 지정)를 등록한다.
	2. 위에서 정의한 localeChangeInterceptor를 Spring MVC인터셉터로 추가하여 모든 요청을 가로 챈다.
		- 다시 말해, 코드를 해당 언어로 변환하여 처리한다는 말이다.
	3. registry.addInterceptor(localeChangeInterceptor(); 로케일 변경 인터센터를 요청
		체인에 추가한다. - 모든 요청에 대해 lang 파라미터를 확인하고, 요청에 지정된 언어로 로케일을
		변경한다.
	 * */
}

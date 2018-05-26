package com.kiyoung.security.oauthdemo001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer // api 서버 인증(또는 권한 설정) 
// API 서버를 oAuth2 인증 받게 만들도록 하며 , 하는 역할을 한다.
// 기본 옵션은 모든 api의 모든 요청에 대해 OAuth2 인증 받도록 한다. 
// OAuth2 인증을 확인하기 위하여 OAUTH2 토큰 스토어를 지정해야 하며, 직접 설정하지 않았으면 인메모리 형태로 지정된다.(여기서는 지정하지 ㅇ낳앗으니, 인메모리 형태로 된 상태이다.)
// 이 프로젝트와 같이 OAuth 서버와 API 서버가 같은 곳에서 처리되는 형태라면 기본적으로 같은 인메모리 토큰 스토어를 공유한다. 
@EnableAuthorizationServer// oauth2 권한 서버
// OAuth2 인증 서버를 활성화 시켜주는 어노테이션에 해당한다. 액세스 토큰, 리프레시 토큰 발급 같은 OAuth2 인증 등 핵심기능을 활성화 시켜준다. (내부에는 /oauth/token , /oauth/authorize 등 기본적으로 OAUTH2에서 사용하는 URL의 활성화 및 인증 및 내부 예외 처리 기능  등을 가진다.) 
@SpringBootApplication
public class OauthDemo001Application extends ResourceServerConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(OauthDemo001Application.class, args);
	}
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.authorizeRequests()
			.anyRequest().permitAll()
			.antMatchers("/authorization-code-test").access("#oauth2.hasScope('read')");
	}
}


/*
 * AuthorizationServerConfigurerAdapter (extends)
 * AuthroizationServerSecurityConfigurer 인증 서버 자체의 보안 정보를 설정하는 부분
 * ClientDetailsServiceConfigurer Client에 대한 정보를 설정하는 부분
 * AuthorizationServerEndpointsConfigurer OAuth2 서버가 작동하기 위한 Endpoint 에 대한 정보를 설정
 */

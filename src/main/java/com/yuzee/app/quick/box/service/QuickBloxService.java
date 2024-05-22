package com.yuzee.app.quick.box.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.yuzee.app.quick.box.dto.QuickbloxChatUserWrapperDto;
import com.yuzee.app.quick.box.dto.QuickbloxUserDto;
import com.yuzee.common.lib.dto.GenericWrapperDto;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QuickBloxService {

	@Value("${quickblox.api.key}")
	private String apiKey;

	@Value("${quickblox.base.url}")
	private String quickbloxBaseURL;

	@Autowired
	private RestTemplate restTemplate;

	public QuickbloxChatUserWrapperDto createUser(QuickbloxChatUserWrapperDto quickbloxChatUserDto) {
		log.info("Class QuickbloxChatHandler method createuser quickbloxChatUserDto : {}", quickbloxChatUserDto);

		String CREATE_USER = quickbloxBaseURL + "users.json";
		ResponseEntity<QuickbloxChatUserWrapperDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxChatUserWrapperDto> requestEntity = new HttpEntity<>(quickbloxChatUserDto, headers);
		StringBuilder path = new StringBuilder();
		path.append(CREATE_USER);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.POST, requestEntity,
				QuickbloxChatUserWrapperDto.class);
		return responseEntity.getBody();
	}

	public QuickbloxChatUserWrapperDto updateUser(String userId, QuickbloxChatUserWrapperDto quickbloxChatUserDto) {
		log.info("Class QuickbloxChatHandler method updateuser quickbloxChatUserDto : {}", quickbloxChatUserDto);

		String CREATE_USER = quickbloxBaseURL + "users/";
		ResponseEntity<QuickbloxChatUserWrapperDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxChatUserWrapperDto> requestEntity = new HttpEntity<>(quickbloxChatUserDto, headers);
		StringBuilder path = new StringBuilder();
		path.append(CREATE_USER).append(userId).append(".json");
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.PUT, requestEntity,
				QuickbloxChatUserWrapperDto.class);
		return responseEntity.getBody();
	}

	public QuickbloxUserDto getUserById(String userId) {
		log.info("Class QuickbloxChatHandler method getuser : {}");

		String CREATE_USER = quickbloxBaseURL + "users/";
		ResponseEntity<QuickbloxUserDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxUserDto> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(CREATE_USER).append(userId).append(".json");
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity,
				QuickbloxUserDto.class);
		return responseEntity.getBody();
	}

	public List<QuickbloxUserDto> getAllUser() {
		log.info("Class QuickbloxChatHandler method getAll user : {}");

		String CREATE_USER = quickbloxBaseURL + "users.json";
		ResponseEntity<GenericWrapperDto<List<QuickbloxUserDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<GenericWrapperDto<List<QuickbloxUserDto>>> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(CREATE_USER);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<GenericWrapperDto<List<QuickbloxUserDto>>>() {
				});
		return responseEntity.getBody().getData();
	}

	public List<QuickbloxUserDto> getAllUserByFullName(String fullName) {
		log.info("Class QuickbloxChatHandler method getAllUserByFullName : {}");

		String url = quickbloxBaseURL + "users/by_full_name.json?full_name=" + fullName;
		ResponseEntity<GenericWrapperDto<List<QuickbloxUserDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<GenericWrapperDto<List<QuickbloxUserDto>>> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(url);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<GenericWrapperDto<List<QuickbloxUserDto>>>() {
				});
		return responseEntity.getBody().getData();
	}

	public List<QuickbloxUserDto> getAllUserByTag(String tag) {
		log.info("Class QuickbloxChatHandler method getAllUserByTag : {}");

		String url = quickbloxBaseURL + "users/by_tags.json=" + tag;
		ResponseEntity<GenericWrapperDto<List<QuickbloxUserDto>>> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<GenericWrapperDto<List<QuickbloxUserDto>>> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(url);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity,
				new ParameterizedTypeReference<GenericWrapperDto<List<QuickbloxUserDto>>>() {
				});
		return responseEntity.getBody().getData();
	}

	public QuickbloxUserDto getUserByLogin(String login) {
		log.info("Class QuickbloxChatHandler method getUserByLogin : {}");

		String url = quickbloxBaseURL + "users/by_login.json?login=" + login;
		ResponseEntity<QuickbloxUserDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxUserDto> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(url);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity, QuickbloxUserDto.class);
		return responseEntity.getBody();
	}

	public QuickbloxUserDto getUserByEmail(String email) {
		log.info("Class QuickbloxChatHandler method getUserByEmail: {}");

		String url = quickbloxBaseURL + "users/by_email.json?email" + email;
		ResponseEntity<QuickbloxUserDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxUserDto> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(url);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity, QuickbloxUserDto.class);
		return responseEntity.getBody();
	}

	public QuickbloxUserDto deleteUserById(String id) {
		log.info("Class QuickbloxChatHandler method deleteUserById: {}");

		String CREATE_USER = quickbloxBaseURL + "users/";
		ResponseEntity<QuickbloxUserDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxUserDto> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(CREATE_USER).append(id).append(".json");
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.DELETE, requestEntity,
				QuickbloxUserDto.class);
		return responseEntity.getBody();
	}

	public QuickbloxUserDto resetUser(String email) {
		log.info("Class QuickbloxChatHandler method resetUser : {}");

		String url = quickbloxBaseURL + "users/password/reset.json?email=" + email;
		ResponseEntity<QuickbloxUserDto> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "ApiKey " + apiKey);
		headers.add("Accept", "application/json");
		headers.add("Content-Type", "application/json");

		HttpEntity<QuickbloxUserDto> requestEntity = new HttpEntity<>(headers);
		StringBuilder path = new StringBuilder();
		path.append(url);
		responseEntity = restTemplate.exchange(path.toString(), HttpMethod.GET, requestEntity, QuickbloxUserDto.class);
		return responseEntity.getBody();
	}
}

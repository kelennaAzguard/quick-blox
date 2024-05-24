package com.yuzee.app.quick.box.endpoint;


import javax.ws.rs.core.Response;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuzee.app.quick.box.dto.QuickbloxChatUserWrapperDto;


@RequestMapping("/api/v1")
public interface QuickBloxUserInterface {
	
	@PostMapping("/quickblox/create-user")
	public Response createUser(@RequestBody QuickbloxChatUserWrapperDto quickBloxDto);
	
	@PutMapping("/quickblox/update-user/user/{user-id}")
	public Response updateUser(@PathVariable("user-id") String userId,@RequestBody QuickbloxChatUserWrapperDto quickBloxDto);
	
	@GetMapping("/quickblox/get-user-by-id/user/{user-id}")
	public Response getUserById(@PathVariable("user-id") String userId);
	
	@GetMapping("/quickblox/all-user")
	public Response getAllUser();
	
	@GetMapping("/quickblox/get-user-list-by-full-name/{full-name}")
	public Response getListOfUserByFullName(@PathVariable("full-name") String fullName);
	
	@GetMapping("/quickblox/get-user-list-by-tag/{tag}")
	public Response getListOfUserByTag(@PathVariable("tag") String tag);
	
	@GetMapping("/quickblox/get-user-by-login/{login}")
	public Response getUserByLogin(@PathVariable("login") String login);
	
	@GetMapping("/quickblox/get-user-by-email/{email}")
	public Response getUserByEmail(@PathVariable("email") String email);
	
	@DeleteMapping("/quickblox/delete-by-id/{userId}")
	public Response deleteUserById(@PathVariable("userId") String userId);

	@GetMapping("/quickblox/reset-password/{email}")
	public Response resetPassword(@PathVariable("email") String email);
	

}

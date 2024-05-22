package com.yuzee.app.quick.box.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QuickbloxUserDto {
	@JsonProperty("id")
	private int id;
	
	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("login")
	private String login;
	
	@JsonProperty("password")
	private String password;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("website")
	private String website;
	
	@JsonProperty("created_at")
	private String createdAt;
	
	@JsonProperty("updated_at")
	private String updatedAt;
	
	@JsonProperty("last_request_at")
	private String lastRequestAt;
	
	@JsonProperty("external_user_id")
	private String userId;
	
	@JsonProperty("facebook_id")
	private String facebookId;
	
	@JsonProperty("blob_id")
	private String blobId;
	
	@JsonProperty("custom_data")
	private String customData;
	
	@JsonProperty("user_tags")
	private String userTags;
}

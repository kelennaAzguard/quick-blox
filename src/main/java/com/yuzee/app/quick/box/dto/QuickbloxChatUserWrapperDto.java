package com.yuzee.app.quick.box.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class QuickbloxChatUserWrapperDto {
	@JsonProperty("user")
	private QuickbloxUserDto user;
}

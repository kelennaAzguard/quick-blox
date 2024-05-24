package com.yuzee.app.quick.box.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.yuzee.app.quick.box.dto.QuickbloxChatUserWrapperDto;
import com.yuzee.app.quick.box.dto.QuickbloxUserDto;
import com.yuzee.app.quick.box.endpoint.QuickBloxUserInterface;
import com.yuzee.app.quick.box.service.QuickBloxService;
import com.yuzee.common.lib.handler.GenericResponseHandlersJersey;
import com.yuzee.local.config.MessageTranslator;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@NoArgsConstructor
public class QuickBloxController implements QuickBloxUserInterface {

	@Autowired
	private QuickBloxService quickBloxService;

	@Autowired
	private MessageTranslator messageTranslator;

	@Override
	public Response createUser(QuickbloxChatUserWrapperDto quickBloxDto) {
		log.info("inside create user controller");

		QuickbloxChatUserWrapperDto createdUser = new QuickbloxChatUserWrapperDto();
		try {
			createdUser = quickBloxService.createUser(quickBloxDto);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}

		return new GenericResponseHandlersJersey.Builder().setData(createdUser).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.created successfuly")).create();
	}

	@Override
	public Response updateUser(String userId, QuickbloxChatUserWrapperDto quickBloxDto) {
		log.info("inside update user method");
		QuickbloxChatUserWrapperDto updateQuickBloxDto = new QuickbloxChatUserWrapperDto();
		try {
			updateQuickBloxDto = quickBloxService.updateUser(userId, quickBloxDto);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}
		return new GenericResponseHandlersJersey.Builder().setData(updateQuickBloxDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.updated successfuly")).create();
	}

	@Override
	public Response getUserById(String userId) {
		log.info("inside getUserById method");
		QuickbloxUserDto quickbloxUserDto = new QuickbloxUserDto();
		try {
			quickbloxUserDto = quickBloxService.getUserById(userId);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}

		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get by id successfuly")).create();
	}

	@Override
	public Response getAllUser() {
		log.info("inside getAllUser method");
		List<QuickbloxUserDto> quickbloxUserDto = new ArrayList<>();
		try {
			quickbloxUserDto = quickBloxService.getAllUser();
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}
		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get all user successfuly")).create();
	}

	@Override
	public Response getListOfUserByFullName(String fullName) {
		log.info("inside getListOfUserByFullName method");
		List<QuickbloxUserDto> quickbloxUserDto = new ArrayList<>();
		try {
			quickbloxUserDto = quickBloxService.getAllUserByFullName(fullName);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}

		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get all user by full name successfuly")).create();
	}

	@Override
	public Response getListOfUserByTag(String tag) {
		log.info("inside getListOfUserByTag method");
		List<QuickbloxUserDto> quickbloxUserDto = new ArrayList<>();
		try {
			quickbloxUserDto = quickBloxService.getAllUserByTag(tag);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}

		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get all user by tag successfuly")).create();

	}

	@Override
	public Response getUserByLogin(String login) {
		log.info("inside getUserByLogin method");
		QuickbloxUserDto quickbloxUserDto = new QuickbloxUserDto();
		try {
			quickbloxUserDto = quickBloxService.getUserByLogin(login);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}

		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get user by user successfuly")).create();

	}

	@Override
	public Response getUserByEmail(String email) {
		log.info("inside getUserByEmail method");
		QuickbloxUserDto quickbloxUserDto = new QuickbloxUserDto();
		try {
			quickbloxUserDto = quickBloxService.getUserByLogin(email);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}
		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get all user by email successfuly")).create();

	}

	@Override
	public Response deleteUserById(String userId) {
		log.info("inside getUserByEmail method");
		QuickbloxUserDto quickbloxUserDto = new QuickbloxUserDto();
		try {
			quickbloxUserDto = quickBloxService.deleteUserById(userId);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}
		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.delete by id successfuly")).create();

	}

	@Override
	public Response resetPassword(String email) {
		log.info("inside getUserByEmail method");
		QuickbloxUserDto quickbloxUserDto = new QuickbloxUserDto();
		try {
			quickbloxUserDto = quickBloxService.resetUser(email);
		} catch (Exception e) {
			log.error("Error calling QuickBlox service to reset password", e);
		}
		return new GenericResponseHandlersJersey.Builder().setData(quickbloxUserDto).setStatus(Status.OK)
				.setMessage(messageTranslator.toLocale("quick.blox.get all user by tag successfuly")).create();

	}

}

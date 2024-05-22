package com.yuzee.app.quick.box.controller;

import java.util.List;
import java.util.Locale;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.yuzee.app.quick.box.dto.QuickbloxChatUserWrapperDto;
import com.yuzee.app.quick.box.dto.QuickbloxUserDto;
import com.yuzee.app.quick.box.endpoint.QuickBloxUserInterface;
import com.yuzee.app.quick.box.service.QuickBloxService;
import com.yuzee.common.lib.exception.ValidationException;
import com.yuzee.common.lib.handler.GenericResponseHandlers;
import com.yuzee.local.config.MessageTranslator;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class QuickBloxController implements QuickBloxUserInterface {

	@Autowired
	private QuickBloxService quickBloxService;

	@Autowired
	private MessageTranslator messageTranslator;

	@Override
	public ResponseEntity<?> createUser(QuickbloxChatUserWrapperDto quickBloxDto) {
		log.info("inside create user controller");
		if (ObjectUtils.isEmpty(quickBloxDto)) {
			log.error(messageTranslator.toLocale("quickBloxDto.is.empty", new Object[] { quickBloxDto }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("quickBloxDto.is.empty", new Object[] { quickBloxDto }));
		}

		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("create user.successfully"))
				.setData(quickBloxService.createUser(quickBloxDto)).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> updateUser(String userId, QuickbloxChatUserWrapperDto quickBloxDto) {
		log.info("inside update user method");
		if (ObjectUtils.isEmpty(quickBloxDto)) {
			log.error(messageTranslator.toLocale("quickBloxDto.is.empty", new Object[] { quickBloxDto }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("quickBloxDto.is.empty", new Object[] { quickBloxDto }));
		}

		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("update user.successfully"))
				.setData(quickBloxService.updateUser(userId, quickBloxDto)).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> getUserById(String userId) {
		log.info("inside getUserById method");
		QuickbloxUserDto quickbloxUserDto = quickBloxService.getUserById(userId);
		if (ObjectUtils.isEmpty(quickbloxUserDto)) {
			log.error(messageTranslator.toLocale("user.id.is.invalid", new Object[] { userId }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("user.id.is.invalid", new Object[] { userId }));
		}
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("get.user.by.id"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> getAllUser() {
		log.info("inside getAllUser method");
		List<QuickbloxUserDto> quickbloxUserDto = quickBloxService.getAllUser();
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("get all user"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> getListOfUserByFullName(String fullName) {
		log.info("inside getListOfUserByFullName method");
		List<QuickbloxUserDto> quickbloxUserDto = quickBloxService.getAllUserByFullName(fullName);
		if (ObjectUtils.isEmpty(quickbloxUserDto)) {
			log.error(messageTranslator.toLocale("user.id.is.invalid", new Object[] { fullName }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("user.id.is.invalid", new Object[] { fullName }));
		}
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("get.user.by.fullName"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> getListOfUserByTag(String tag) {
		log.info("inside getListOfUserByTag method");
		List<QuickbloxUserDto> quickbloxUserDto = quickBloxService.getAllUserByTag(tag);
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("get.user.by.tag"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> getUserByLogin(String login) {
		log.info("inside getUserByLogin method");
		QuickbloxUserDto quickbloxUserDto = quickBloxService.getUserByLogin(login);
		if (ObjectUtils.isEmpty(quickbloxUserDto)) {
			log.error(messageTranslator.toLocale("login.is.invalid", new Object[] { login }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("login.is.invalid", new Object[] { login }));
		}
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("get.user.by.login"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> getUserByEmail(String email) {
		log.info("inside getUserByEmail method");
		QuickbloxUserDto quickbloxUserDto = quickBloxService.getUserByLogin(email);
		if (ObjectUtils.isEmpty(quickbloxUserDto)) {
			log.error(messageTranslator.toLocale("email.id.is.invalid", new Object[] { email }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("email.id.is.invalid", new Object[] { email }));
		}
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("get.user.by.email"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> deleteUserById(String userId) {
		log.info("inside getUserByEmail method");
		QuickbloxUserDto quickbloxUserDto = quickBloxService.deleteUserById(userId);
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("delete.user.by.user.id"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

	@Override
	public ResponseEntity<?> resetPassword(String email) {
		log.info("inside getUserByEmail method");
		QuickbloxUserDto quickbloxUserDto = quickBloxService.resetUser(email);
		if (ObjectUtils.isEmpty(quickbloxUserDto)) {
			log.error(messageTranslator.toLocale("email.id.is.invalid", new Object[] { email }, Locale.US));
			throw new ValidationException(
					messageTranslator.toLocale("email.id.is.invalid", new Object[] { email }));
		}
		return new GenericResponseHandlers.Builder().setMessage(messageTranslator.toLocale("reset.password.successfully"))
				.setData(quickbloxUserDto).setStatus(HttpStatus.OK).create();
	}

}

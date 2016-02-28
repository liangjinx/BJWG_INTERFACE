package com.mobile.blue.launcher.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.mobile.blue.launcher.model.AppUser;
import com.mobile.blue.view.RequestUserVO;

public interface UserBasicService {

	String sendVerification(HttpServletRequest request, String phone, int type) throws Exception;

	String register(String phone, String password, String invite_code, HttpServletRequest rs) throws Exception;

	String userLogin(HttpServletRequest request, String username, String password);

	String updateUser(RequestUserVO user);

	List<AppUser> selectById(HttpServletRequest request, List<Long> freindId, int nextPage, boolean isoldfriend);

	List<AppUser> searchFriends(HttpServletRequest request, List<Long> searchFriend, String vale,int nextpage);

	String selectcountAll(long userId);

	String VerifyPassword(byte type, long userId, String oldPassword);

	String selecePersonInfo(long userId);

	String loadImg(MultipartFile file, HttpServletRequest request) throws Exception;

	AppUser selectUserById(Long userId);

	int SelectByPhone(String string);


}

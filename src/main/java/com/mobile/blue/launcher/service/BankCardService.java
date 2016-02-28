package com.mobile.blue.launcher.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mobile.blue.launcher.model.AppUserBankCard;
import com.mobile.blue.view.RequestBankCardVo;;

public interface BankCardService {

	List<RequestBankCardVo> bankCardList(HttpServletRequest request,long userId,int nextpage);

	int addBankCard(AppUserBankCard card);

	int countCard(long userId);

	int deleteBankCard(long cardId);

	Map<String, Object> selectByUserIdAndCardId(long userId, long cardId);

	Object BankCardNameAndType();

	Object verifyBankcard(String bankCardNumber);

}

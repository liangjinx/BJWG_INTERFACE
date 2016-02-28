package com.mobile.blue.launcher.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.BankCardDao;
import com.mobile.blue.launcher.model.AppUserBankCard;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample;
import com.mobile.blue.launcher.model.Example.AppUserBankCardExample.Criteria;
import com.mobile.blue.launcher.service.BankCardService;
import com.mobile.blue.launcher.service.DictDetailService;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.ResultUtil;
import com.mobile.blue.util.constant.BasicConstant;
import com.mobile.blue.util.constant.StatusConstant.Status;
import com.mobile.blue.view.RequestBankCardVo;

@Service("bankCardService")
public class BankCardServiceImpl implements BankCardService {
	List<AppUserBankCard> list = null;
	@Autowired
	private BankCardDao bankCardDao;
	
	@Autowired
	private DictDetailService dictDetailService;
	@Override
	public List<RequestBankCardVo> bankCardList(HttpServletRequest request,long userId,int nextPage) {
		AppUserBankCardExample example = new AppUserBankCardExample();
		Criteria criteria = example.createCriteria();
		PageParameter page=(PageParameter) request.getSession().getAttribute("bankCardList");
		if(page==null){
			page = new PageParameter(0,BasicConstant.limit_page_size);
			criteria.andUserIdEqualTo(userId);
			example.setDistinct(true);
			int count=bankCardDao.countCard(example, criteria);
			page.setCount(count);
		}else{
			if(nextPage>page.getTotal()){
				return null;
			}
			page.setCurrent(nextPage);
		}
		criteria.andUserIdEqualTo(userId);
		example.setDistinct(true);
		example.setPage(page);
		list = bankCardDao.bankCardList(example, criteria);
		if (list == null || list.size() <= 0) {
			return null;
		}
		request.getSession().setAttribute("bankCardList", page);
		List<RequestBankCardVo> returnlist = new ArrayList<RequestBankCardVo>();
		RequestBankCardVo bankVo=null;
		for (AppUserBankCard bankcard : list) {
			bankVo = new RequestBankCardVo();
			bankVo.setAccountName(bankcard.getAccountName());
			bankVo.setBank(bankcard.getBank());
			bankVo.setBankCode(bankcard.getBankCode());
			bankVo.setCardId(bankcard.getCardId());
			bankVo.setCardNo(bankcard.getCardNo());
			bankVo.setCardType(bankcard.getCardType());
			bankVo.setCity(bankcard.getCity());
			bankVo.setIdCard(bankcard.getIdCard());
			bankVo.setLink(bankcard.getLink());
			bankVo.setProvince(bankcard.getProvince());
			bankVo.setUserId(bankcard.getUserId());
			bankVo.setImg("http://resource.bajiewg.com//images//bank-"
					+ dictDetailService.selectvalueByName(bankcard.getBank()) + ".png");
			returnlist.add(bankVo);
		}
		return returnlist;
	}

	@Override
	public int addBankCard(AppUserBankCard card) {
		return bankCardDao.addBankCard(card);
	}

	@Override
	public int countCard(long userId) {
		AppUserBankCardExample example = new AppUserBankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return bankCardDao.countCard(example, criteria);
	}

	@Override
	public int deleteBankCard(long cardId) {

		return bankCardDao.deleteBankCard(cardId);
	}

	@Override
	public Map<String, Object> selectByUserIdAndCardId(long userId, long cardId) {
		AppUserBankCardExample example = new AppUserBankCardExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		criteria.andCardIdEqualTo(cardId);
		list = bankCardDao.bankCardList(example, criteria);
		if (list == null || list.size() <= 0) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("card_id", list.get(0).getCardId());
		map.put("card_no", list.get(0).getCardNo());
		map.put("account_name", list.get(0).getAccountName());
		map.put("card_type", list.get(0).getCardType());
		map.put("bank_code", list.get(0).getBankCode());
		map.put("bank", list.get(0).getBank());
		map.put("ID_card", list.get(0).getIdCard());
		map.put("user_id", list.get(0).getUserId());
		map.put("link", list.get(0).getLink());
		map.put("province", list.get(0).getProvince());
		map.put("city", list.get(0).getCity());
		return map;
	}

	@Override
	public Object BankCardNameAndType() {
		return dictDetailService.selectBankNamelist();
	}

	@Override
	public String verifyBankcard(String bankCardNumber) {
		Map<String, Object> returnmap=dictDetailService.verifyBankcard(bankCardNumber);
		if(returnmap==null){
			return ResultUtil.getResultJson(-301,"现在还不支持这类型银行卡，请更换银行卡");
		}else{
			System.out.println(returnmap.toString());
			return ResultUtil.getResultJson(returnmap, Status.success.getStatus(),Status.success.getMsg());
		}
	}

}

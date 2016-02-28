package com.mobile.blue.launcher.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.blue.launcher.dao.TestDao;
import com.mobile.blue.launcher.dao.mapper.AppTestUserFenyeMapper;
import com.mobile.blue.launcher.model.AppTestUserFenye;
import com.mobile.blue.launcher.model.AppTestUserFenyeExample;
import com.mobile.blue.launcher.model.AppTestUserFenyeExample.Criteria;
import com.mobile.blue.util.PageParameter;
import com.mobile.blue.util.constant.BasicConstant;
@Service("testDao")
public class TestDaoImpl implements TestDao {
	AppTestUserFenyeExample example =new AppTestUserFenyeExample();
	Criteria criteria=example.createCriteria();
	List<AppTestUserFenye> list=null;
	@Autowired
	private AppTestUserFenyeMapper appTestUserFenyeMapper;
	@Override
	/**
	 * current表示当前页码
	 */
	public List<AppTestUserFenye> select(HttpServletRequest request,int current) {
		criteria.andUsernameLike("%158%");
		PageParameter page=(PageParameter) request.getSession().getAttribute("phone");
		if(page==null){
			page = new PageParameter(0,BasicConstant.limit_page_size);
			int count=appTestUserFenyeMapper.countByExample(example);
			criteria.getAllCriteria().clear();
			page.setCount(count);
		}else{
			if(current==1){
				//表示上一页
				if(page.getCurrent()==1){
					return null;
				}
				page.setCurrent(page.getCurrent()-1);
			}else{
//				表示下一页
				if(page.getCurrent()==page.getTotal()){
					return null;
				}
				page.setCurrent(page.getCurrent()+1);
			}
		}
		example.setPage(page);
		list=appTestUserFenyeMapper.selectByExample(example);
		System.out.println(page.toString());
		request.getSession().setAttribute("phone", page);
		return list;
	}

}

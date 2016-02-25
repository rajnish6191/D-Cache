package com.student.Dao;

import java.util.ArrayList;
import java.util.List;


import com.student.FormBean.DataFormBean;
import com.student.Dao.DataDao;

public class DummyDB {
	
	private List<DataFormBean> list;
	
	public List<DataFormBean> getData(String query)
	{
		
		
		DataDao userDao=new DataDao();
		list=userDao.getAllTitles();
		System.out.println(list+"@@@@@@@@@@@@@@@@@@");
	
		String country = null;
		query = query.toLowerCase();
		List<DataFormBean> matched = new ArrayList<DataFormBean>();
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.size()+"*******************");
			country = list.get(i).getIname().toLowerCase();
			if(country.startsWith(query)) {
				matched.add(list.get(i));
			}
		
	}
	return matched; 
}
	
}

package com.carpool.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.carpool.datasource.Query;
import com.carpool.datasource.QueryInteractor;
import com.carpool.model.User;

public class TableDataOperations {

	QueryInteractor qi = null;
	
 	public String createTable() {
		
		try {
			qi = new QueryInteractor();
			//qi.executeUpdateQuery(Query.CREATE_COMPANY);
			
			return "Table created successfully";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 	
 	public String insertDataTable(HashMap values) {
 		
 		try {
 			qi = new QueryInteractor();
 			qi.getArrayList(Query.INSERT_USER, values);
 			
 			return "Data saved successfully";
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 	
 	public List<User> viewData() {
 		
 		List<User> companyList = new ArrayList<User>();
 		User company = null;
 		
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObject = qi.getList(Query.SELECT_ALL_USERS);
 			
 			int k = 0;
 			for(int i=1; i<listObject.size(); i++) {
 				
 				Object[] obj = (Object[])listObject.get(i);
 				company = new User();
 				company.setUsername(obj[k++].toString());
 				company.setAddress(obj[k++].toString());
 				
 				companyList.add(company);
 				k = 0;
 			}
 			return companyList; 
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}
 /*	public List<Company> viewData() {
 		
 		List<Company> companyList = new ArrayList<Company>();
 		Company company = null;
 		
 		try {
 			qi = new QueryInteractor();
 			List<Object> listObject = qi.getList(Query.VIEW_ALL_COMPANY);
 			
 			int k = 0;
 			for(int i=1; i<listObject.size(); i++) {
 				
 				Object[] obj = (Object[])listObject.get(i);
 				company = new Company();
 				company.setId(Integer.parseInt(obj[k++].toString()));
 				company.setName(obj[k++].toString());
 				company.setAge(obj[k++].toString());
 				company.setAddress(obj[k++].toString());
 				company.setSalary(obj[k++].toString());
 				
 				companyList.add(company);
 				k = 0;
 			}
 			return companyList; 
 		} catch(Exception e) {
 			e.printStackTrace();
 		}
 		return null;
 	}*/
	/*public static void main(String args[]) {
		
		TableDataOperations tdo = new TableDataOperations();
		
		//tdo.createTable();
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		
		hm.put(new Integer(1), "pai.gurunath@gmail.com");
		hm.put(new Integer(2), "test123test");
		hm.put(new Integer(3), "9004905325");
		hm.put(new Integer(4), "pai.gurunath@gmail.com");
		hm.put(new Integer(5), "Radhakrishna");
		
		//hm.put(new Integer(5), "1");
		
		
		tdo.insertDataTable(hm);
		//tdo.viewData();
		
	}*/
}

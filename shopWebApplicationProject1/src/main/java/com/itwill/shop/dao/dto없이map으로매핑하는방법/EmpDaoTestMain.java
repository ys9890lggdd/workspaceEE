package com.itwill.shop.dao.dto없이map으로매핑하는방법;

import java.util.List;
import java.util.Map;

public class EmpDaoTestMain {

	public static void main(String[] args)throws Exception {
		EmpDao empDao=new EmpDao();
		Map empRowMap = empDao.findEmpnoWithDept(7934);
		//System.out.println(empRowMap);
		int empno=(Integer)empRowMap.get("EMPNO");
		String dname=(String)empRowMap.get("DNAME");
		System.out.println(empno+"\t"+dname);
		System.out.println("---------------------------------------------");
		
		List empRowMapList =empDao.findEmpsWithDept();
		for (int i=0;i<empRowMapList.size();i++) {
			Map tempEmpRowMap = (Map)empRowMapList.get(i);
			//System.out.println(tempEmpRowMap);
			int en=(Integer)tempEmpRowMap.get("EMPNO");
			String dn=(String)tempEmpRowMap.get("DNAME");
			System.out.println(en+"\t"+dn);
			
		}
	}

}

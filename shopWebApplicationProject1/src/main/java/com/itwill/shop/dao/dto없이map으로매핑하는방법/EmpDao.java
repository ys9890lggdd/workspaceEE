package com.itwill.shop.dao.dto없이map으로매핑하는방법;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;



public class EmpDao {
	private DataSource dataSource;
	public EmpDao() throws Exception{
		/******Apache BasicDataSource*****/
		BasicDataSource basicDataSource = new BasicDataSource();
		/*
		 * jdbc.properties 파일을 Properties객체로생성
		 */
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		this.dataSource = basicDataSource;
	}

	// 사원정보(부서정보포함) 한개 반환
	
	public HashMap findEmpnoWithDept(int no) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(EmpSQL.SELECT_EMPNO_WITHDEPT);
		pstmt.setInt(1, no);
		/*
		select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno
		 */
		ResultSet rs = pstmt.executeQuery();
		HashMap<String, Object> rowMap = new HashMap<String, Object>();
		if (rs.next()) {
			rowMap.put("EMPNO", rs.getInt("EMPNO"));
			rowMap.put("ENAME", rs.getString("ENAME"));
			rowMap.put("JOB", rs.getString("JOB"));
			rowMap.put("MGR", rs.getInt("MGR"));
			rowMap.put("HIREDATE", rs.getDate("HIREDATE"));
			rowMap.put("SAL", rs.getDouble("SAL"));
			rowMap.put("COMM", rs.getInt("COMM"));
			rowMap.put("DEPTNO", rs.getInt("DEPTNO"));
			rowMap.put("DNAME", rs.getString("DNAME"));
			rowMap.put("LOC", rs.getString("LOC"));
		}

		return rowMap;
	}

	// 사원정보(부서정보포함) 전체목록 반환
	
	public ArrayList<HashMap> findEmpsWithDept() throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(EmpSQL.SELECT_ALLEMP_WITHDEPT);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<HashMap> rowMapList = new ArrayList<HashMap>();
		while (rs.next()) {
			HashMap<String, Object> rowMap = new HashMap<String, Object>();
			rowMap.put("EMPNO", rs.getInt("EMPNO"));
			rowMap.put("ENAME", rs.getString("ENAME"));
			rowMap.put("JOB", rs.getString("JOB"));
			rowMap.put("MGR", rs.getInt("MGR"));
			rowMap.put("HIREDATE", rs.getDate("HIREDATE"));
			rowMap.put("SAL", rs.getDouble("SAL"));
			rowMap.put("COMM", rs.getInt("COMM"));
			rowMap.put("DEPTNO", rs.getInt("DEPTNO"));
			rowMap.put("DNAME", rs.getString("DNAME"));
			rowMap.put("LOC", rs.getString("LOC"));
			rowMapList.add(rowMap);
		}

		return rowMapList;
	}

}

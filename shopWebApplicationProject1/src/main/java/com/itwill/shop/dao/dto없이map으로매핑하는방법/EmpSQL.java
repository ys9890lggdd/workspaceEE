package com.itwill.shop.dao.dto없이map으로매핑하는방법;

public class EmpSQL {
	public static final String SELECT_ALLEMP_WITHDEPT=
"select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno";
	public static final String SELECT_EMPNO_WITHDEPT=
"select empno,ename,job,mgr,hiredate,sal,comm,e.deptno,dname,loc from emp e left outer join dept d on e.deptno = d.deptno where empno=?";
}

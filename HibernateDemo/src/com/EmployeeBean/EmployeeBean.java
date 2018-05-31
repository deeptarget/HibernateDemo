package com.EmployeeBean;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class EmployeeBean {
	@Id
	int eid;
	String ename;
	double salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	
}

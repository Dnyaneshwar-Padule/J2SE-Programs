package com.tca.entities;

public class Student {

	private Integer rno;
	private String name;
	private Float per;

	public Student() {
		rno = 0;
		name = "Unknown";
		per = 0.0f;
	}
	
	public Student(Integer rno, String name, Float per) {
		super();
		this.rno = rno;
		this.name = name;
		this.per = per;
	}

	public Student(Student student)
	{
		rno = student.rno;
		name = student.name;
		per = student.per;
	}

	public Integer getRno() {
		return rno;
	}
	public void setRno(Integer rno) {
		this.rno = rno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Float getPer() {
		return per;
	}
	public void setPer(Float per) {
		this.per = per;
	}

	@Override
	public String toString() {
		return "Student [rno=" + rno + ", name=" + name + ", per=" + per + "]";
	}
	
	
	
}

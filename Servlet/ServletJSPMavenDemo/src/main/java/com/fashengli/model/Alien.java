package com.fashengli.model;

public class Alien {
	private int id;
	private String aname;
	private String tech;
	@Override
	public String toString() {
		return "Alien [id=" + id + ", aname=" + aname + ", tech=" + tech + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	
}

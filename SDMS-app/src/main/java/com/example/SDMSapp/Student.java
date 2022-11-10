package com.example.SDMSapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int english;
	private int kannada;
	private int maths;
	private int science;
	private int chemistry;
	private int biology;
	private double percentage;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getKannada() {
		return kannada;
	}
	public void setKannada(int kannada) {
		this.kannada = kannada;
	}
	public int getMaths() {
		return maths;
	}
	public void setMaths(int maths) {
		this.maths = maths;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getChemistry() {
		return chemistry;
	}
	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}
	public int getBiology() {
		return biology;
	}
	public void setBiology(int biology) {
		this.biology = biology;
	}
	public double getPercentage() {
		double s = getEnglish()+ getKannada()+ getChemistry()+ getMaths()+ getBiology()+ getScience();
			return (s*100)/600;
	}
	
	@Override
	public String toString() {
		return "Student ID=" + id + ", Name=" + name +",Percentage = "+getPercentage()+"%";
	}

}

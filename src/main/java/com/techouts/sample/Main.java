package com.techouts.sample;

public class Main {

	public static void main(String[] args) {

		User user=new User();
		Sample sample=new Sample();
		sample.m1(user);
		System.out.println(user.getName()+":"+user.getAge());
		
	}

}

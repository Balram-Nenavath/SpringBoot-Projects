package com.orderManagement.entity;

import java.awt.Robot;
import java.util.Random;
public class Category {
	public static final int mints = 30000;
	public static final int MAX_Y = 400;
	public static final int MAX_X = 400;
	public static void main(String[] args) throws Exception
	{
		Robot robot= new Robot();
		Random random = new Random();
		while(true)
		{
			robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
			Thread.sleep(mints);
			System.out.println("Running................ ");
		}
		
	}
	
	}


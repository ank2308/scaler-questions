package com.main;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception, IOException {
		

		//Fill your code	
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the length of the rectangle");
		Integer length = sc.nextInt();
		System.out.println("Enter the width of the rectangle");
		Integer width = sc.nextInt();
		Rectangle rectangle = new Rectangle(length, width);		
		rectangle.display();
		System.out.println("Enter the new dimension");
		Integer newDimension = sc.nextInt();
		Rectangle newRectangle = rectangle.dimensionChange(newDimension);
		if(newRectangle instanceof Rectangle) {
			newRectangle.display();
		}
	}

}

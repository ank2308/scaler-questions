package com.main;

public class Rectangle {
	
	private Integer length;
	private Integer width;	
	
	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer area() {		

		//Fill your code
		return (length * width);	

	}
	
	public Rectangle(Integer length, Integer width) {
		this.length = length;
		this.width = width;
	}
	
	public void display(){
		
		//Fill your code	
		System.out.println("Rectangle Dimension");
		System.out.println("Length:"+length);
		System.out.println("Width:"+width);
		System.out.println("Area of the Rectangle:"+area());
	}
	
	Rectangle dimensionChange(Integer newDimension){

		Rectangle rectangleObject = new Rectangle((this.length * newDimension), (this.width * newDimension));
		//Fill your code
		return rectangleObject;
	}
}

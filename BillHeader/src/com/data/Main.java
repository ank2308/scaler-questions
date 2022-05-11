package com.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
		// fill your code here
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the issue date as dd/MM/yyyy");
    	BillHeader billHeader = new BillHeader();
    	billHeader.setIssueDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.next()));
    	System.out.println("Enter the due date as dd/MM/yyyy");
    	billHeader.setDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(sc.next()));
    	System.out.println("Enter the original amount");
    	billHeader.setOriginalAmount(Double.parseDouble(sc.next()));
    	System.out.println("Enter amount paid so far");
    	billHeader.setAmountOutstanding((billHeader.getOriginalAmount() - Double.parseDouble(sc.next())));
    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    	
    	System.out.println("Issue date: "+ formatter.format(billHeader.getIssueDate()));
    	System.out.println("Due Date: "+ formatter.format(billHeader.getDueDate()));
    	System.out.println("Original amount Rs."+ billHeader.getOriginalAmount());
    	System.out.println("Amount outstanding Rs."+ billHeader.getAmountOutstanding());
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.training.assignment2.validators;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.training.assignment2.customException.NewCustomException;

/**
 *
 * @author Hitesh
 */
public class StringDateConverter {
         /* Validates and Converts a String into a Date object
         */
    public static Date StringToDateConvertor(String input) throws NewCustomException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			formatter.setLenient(false);
			date = formatter.parse(input);
//			System.out.println(date);
		} catch (ParseException e) {
			 throw new NewCustomException("Error in Date processing... Please Try again");		 
		}
		return date;
	}
    
    public static String DateToStringConvertor(Date date) throws NewCustomException{
    	try{
    	DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	return formatter.format(date);
    	}catch(Exception e){
    		throw new NewCustomException("Error in Date Formatting");
    	}
    }
}

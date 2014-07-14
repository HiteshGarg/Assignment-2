/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nagarro.training.assignment2.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Hitesh
 */
public class StringDateConverter {
         /* Validates and Converts a String into a Date object
         */
    public static Date StringToDateConvertor(String input) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			formatter.setLenient(false);
			date = formatter.parse(input);
//			System.out.println(date);
		} catch (ParseException e) {
			 return null;
		}
		return date;
	}
}

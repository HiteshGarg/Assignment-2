/**
 * 
 */
package com.nagarro.training.assignment2.validators;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.nagarro.training.assignment2.Constants.Constants;

/**
 * @author hiteshgarg
 * 
 */
public class UserInputValidators {
	public static boolean isStringNull(String input) {

		boolean stringValidate = false;

		if (!input.isEmpty()) {
			stringValidate = true;
		} else {
			System.out.println("Incorrect name. Please Try again");
		}
		return stringValidate;
	}

	public static boolean locationValidator(String input) {

		boolean locationValidate = false;

		if (input.length() == 3) {
			locationValidate = true;
		} else {
			System.out.println(Constants.INCORRECT_LOCATION_ERROR);
		}
		return locationValidate;
	}

	public static boolean dateValidator(String input) {
		
		boolean locationValidate = true;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = new Date();
        try {
            formatter.setLenient(false);
            formatter.parse(input);
            locationValidate = true;
        } catch (ParseException e) {
            System.out.println(Constants.INCORRECT_DATE_ERROR);
        	locationValidate = false;
        }
		return locationValidate;
	}

	public static boolean classValidator(String input) {
		
		boolean classValidate = false;
		
		if (input.equalsIgnoreCase("e") || input.equalsIgnoreCase("b")) {
			classValidate  = true;
		} else {
			System.out.println(Constants.INCORRECT_CLASS_ERROR);
		}
		return classValidate ;
	}

	public static boolean preferenceValidator(String input) {
		
		boolean preferenceValidate = false;
		
		if (input.equalsIgnoreCase("1") || input.equalsIgnoreCase("2")) {
			preferenceValidate  = true;
		} else {
			System.out.println(Constants.INCORRECT_PREFERENCE_ERROR);
		}
		return preferenceValidate ;
	}
}

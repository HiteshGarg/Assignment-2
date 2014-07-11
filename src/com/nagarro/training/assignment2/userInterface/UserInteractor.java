package com.nagarro.training.assignment2.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.nagarro.training.assignment2.Constants.Constants;
import com.nagarro.training.assignment2.flightDTO.FlightDTO;
import com.nagarro.training.assignment2.validators.UserInputValidators;

/**
 * @author hiteshgarg
 * 
 */
public class UserInteractor {

	public void userInput(FlightDTO dto) {

		boolean validate = true;
		String input;
		String choice= "";
		try {
			do {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(System.in));
				System.out.println(Constants.WELCOME_MESSAGE);

				do {
					System.out.println(Constants.ENTER_DEPARTURE_LOCATION);
					validate = UserInputValidators
							.locationValidator(input = reader.readLine());
				} while (!validate);
				dto.setDep_loc(input);

				do {
					System.out.println(Constants.ENTER_ARRIVAL_LOCATION);
					validate = UserInputValidators
							.locationValidator(input = reader.readLine());
				} while (!validate);
				dto.setArr_loc(input);

				do {
					System.out.println(Constants.ENTER_FLIGHT_DATE);
					validate = UserInputValidators.dateValidator(input = reader
							.readLine());
				} while (!validate);
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				Date date = null;
				try {
					formatter.setLenient(false);
					date = formatter.parse(input);
				} catch (ParseException e) {
					System.out.println("Unexpected Error in Date Formatting");
					System.exit(1);
				}
				dto.setFlight_date(date);

				do {
					System.out.println(Constants.ENTER_FLIGHT_CLASS);
					validate = UserInputValidators
							.classValidator(input = reader.readLine());
				} while (!validate);
				dto.setFlight_class(input);

				do {
					System.out.println(Constants.ENTER_OUTPUT_PREFERENCES);
					validate = UserInputValidators
							.preferenceValidator(input = reader.readLine());
				} while (!validate);
				dto.setOutput_preferences(input);

				new FlightSearch().searchUserFlight(dto);
				
				System.out.println("Want to search another flight(y/n)");
				choice = reader.readLine();
			} while (choice.equalsIgnoreCase("y"));

			System.out.println("Good you have entered all valid inputs");
			System.out.println(dto.getArr_loc() + " " + dto.getDep_loc() + " "
					+ dto.getFlight_class() + " " + dto.getFlight_date() + " "
					+ dto.getOutput_preferences());

			System.exit(0);
		} catch (IOException e) {

			System.out.println("Unexpected error occured please try again");
		}
	}
}

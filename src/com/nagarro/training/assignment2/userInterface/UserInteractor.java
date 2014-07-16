package com.nagarro.training.assignment2.userInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

import com.nagarro.training.assignment2.Constants.Constants;
import com.nagarro.training.assignment2.DTOclasses.FlightDTO;
import com.nagarro.training.assignment2.customException.NewCustomException;
import com.nagarro.training.assignment2.flight.Flight;
import com.nagarro.training.assignment2.validators.StringDateConverter;
import com.nagarro.training.assignment2.validators.UserInputValidators;

/**
 * @author hiteshgarg
 * 
 */
public class UserInteractor {

	public void userInput() throws NewCustomException {
		FlightDTO dto = new FlightDTO();
		boolean validate = true;
		String input;
		String choice= "y";
		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(System.in));
			do {
				System.out.println(Constants.WELCOME_MESSAGE);

				do {
					System.out.println(Constants.ENTER_DEPARTURE_LOCATION);
					validate = UserInputValidators
							.locationValidator(input = reader.readLine());
				} while (!validate);
				dto.setDepLoc(input);

				do {
					System.out.println(Constants.ENTER_ARRIVAL_LOCATION);
					validate = UserInputValidators
							.locationValidator(input = reader.readLine());
				} while (!validate);
				dto.setArr_loc(input);

				do {
					System.out.println(Constants.ENTER_FLIGHT_DATE);
					input = reader.readLine();
					try{
					validate = UserInputValidators.dateValidator(input);
					}catch(NewCustomException exception){
						exception.printMessage();
						validate = false;
					}
				} while (!validate);
				
				try{
				Date date = StringDateConverter.StringToDateConvertor(input);
				dto.setFlightDate(date);
				}catch(NewCustomException exception){
					exception.printMessage();
					continue;
				}

				do {
					System.out.println(Constants.ENTER_FLIGHT_CLASS);
					validate = UserInputValidators
							.classValidator(input = reader.readLine());
				} while (!validate);
				dto.setFlightClass(input);

				do {
					System.out.println(Constants.ENTER_OUTPUT_PREFERENCES);
					validate = UserInputValidators
							.preferenceValidator(input = reader.readLine());
				} while (!validate);
				dto.setOutputPreferences(input);

				List<Flight> SearchedFlights = new FlightSearch().searchUserFlight(dto);
				
				Output.outputDisplay(SearchedFlights, dto);
				
				System.out.println("Want to search another flight(y/n)");
				choice = reader.readLine();
			} while (choice.equalsIgnoreCase("y"));

			reader.close();
			System.exit(0);
		} catch (IOException e) {
			throw new NewCustomException("Unexpected error occured please try again");
		}
	}
}

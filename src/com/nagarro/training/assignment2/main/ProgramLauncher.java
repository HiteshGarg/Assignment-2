package com.nagarro.training.assignment2.main;

import com.nagarro.training.assignment2.csvServices.ProcessCsvFiles;
import com.nagarro.training.assignment2.customException.NewCustomException;
import com.nagarro.training.assignment2.userInterface.UserInteractor;

public class ProgramLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * Initializes the class that perform all csv files related operations
		 */
		ProcessCsvFiles launcher = new ProcessCsvFiles();
		launcher.initiateThreadClass();

		/*
		 * This will interact with user. Will take Input , validate it further
		 * and Finally Search for the flights
		 */

		UserInteractor interactor = new UserInteractor();
		try {
			interactor.userInput();		
		} catch (NewCustomException exception) {

			exception.printMessage();
		}

	}

}

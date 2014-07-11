package com.nagarro.training.assignment2.main;

import com.nagarro.training.assignment2.thread.ProcessCsvFilesThreadLauncher;
import com.nagarro.training.assignment2.userInterface.UserInteractor;

public class ProgramLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		Initialises the class that perform all csv files related operations
		
		ProcessCsvFilesThreadLauncher launcher = new ProcessCsvFilesThreadLauncher();
		launcher.initiateThreadClass();
		
//		This will interact with user. Will take Input , validate it further and Finally Search for the fllights
		
		UserInteractor interactor = new UserInteractor();
		interactor.userInput();

	}

}

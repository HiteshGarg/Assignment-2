package com.nagarro.training.assignment2.main;

import com.nagarro.training.assignment2.flightDTO.FlightDTO;
import com.nagarro.training.assignment2.thread.ThreadLauncher;
import com.nagarro.training.assignment2.userInterface.UserInteractor;

public class ProgramLauncher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FlightDTO dto = new FlightDTO();
		
		ThreadLauncher launcher = new ThreadLauncher();
		launcher.initiateThreadClass(dto);
		
		UserInteractor interactor = new UserInteractor();
		interactor.userInput(dto);
		
		// will generate thread and pass dto to it
		//thread will search for csv and 
	}

}

/**
 * 
 */
package com.nagarro.training.assignment2.flightDTO;

import java.nio.file.attribute.FileTime;
import java.util.List;
import java.util.Map;

/**
 * @author hiteshgarg
 *
 */
public class CsvFilesDTO {
	private List<String> updatedFiles;
	private Map<String, FileTime> csvListTime;
	
	/**
	 * @return the updatedFiles
	 */
	public List<String> getUpdatedFiles() {
		return updatedFiles;
	}
	/**
	 * @param updatedFiles the updatedFiles to set
	 */
	public void setUpdatedFiles(List<String> updatedFiles) {
		this.updatedFiles = updatedFiles;
	}
	/**
	 * @return the csvListTime
	 */
	public Map<String, FileTime> getCsvListTime() {
		return csvListTime;
	}
	/**
	 * @param csvListTime the csvListTime to set
	 */
	public void setCsvListTime(Map<String, FileTime> csvListTime) {
		this.csvListTime = csvListTime;
	}
	
}

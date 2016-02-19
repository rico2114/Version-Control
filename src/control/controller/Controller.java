package control.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.AbstractList;
import java.util.List;

import control.action.ActionStep;
import control.interpret.FileMaster;

/**
 * Created with eclipse 18/02/2016 9:35:50 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public abstract class Controller<E extends AbstractList<ActionStep>> {

	/**
	 * Represents a cached version of the steps to be stored
	 */
	private final E steps;
	
	/**
	 * Represents the writer for the steps result file
	 */
	private BufferedWriter resultFile;
	
	/**
	 * Represents a cached version of the file one as array
	 */
	private List<String> firstFile;
	
	/**
	 * Represents a cached version of the file two as array
	 */
	private List<String> secondFile;
		
	/**
	 * Represents the file master
	 */
	private final FileMaster master;
	
	/**
	 * Constructs a controller used for the classes to commit
	 * @param master	the master
	 */
	public Controller(final E type, final FileMaster master) {
		this.master = master;
		this.steps = type;
		this.firstFile = master.getLastCommitedFile();
		this.secondFile = master.getUncommitedFile();
	}
	
	/**
	 * Saves the step to a txt
	 */
	public void saveSteps() {
		try {
			resultFile = new BufferedWriter(new FileWriter("./steps/test.txt", true));
			
			for (ActionStep instruction : steps) {
				resultFile.write(instruction.saveAttribute() + "\n");
			}
			
			resultFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addStep(final ActionStep step) {
		steps.add(step);
	}
	
	public FileMaster getMaster() {
		return master;
	}
}

package control.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractCollection;
import java.util.List;
import java.util.StringTokenizer;

import control.ActionType;
import control.action.ActionStep;
import control.action.impl.AddAction;
import control.action.impl.RemoveAction;
import control.action.impl.ReplaceAction;
import control.interpret.FileMaster;

/**
 * Created with eclipse 18/02/2016 9:35:50 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public abstract class Controller<E extends AbstractCollection<ActionStep>> {

	protected static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");

	/**
	 * Represents a cached version of the steps to be stored
	 */
	private final E steps;
		
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
	}
	
	/**
	 * Saves the step to a txt
	 */
	public void saveSteps() {
		try {
			BufferedWriter outputBuffer = new BufferedWriter(new FileWriter("./steps/test.txt", true));
			
			for (ActionStep instruction : steps) {
				outputBuffer.write(instruction.saveAttribute() + "\n");
			}
			
			outputBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * Loads n recently steps stored (from new to old)
	 * @param nSteps	the n steps to load
	 */
	public void loadRecentlyStoredSteps(final int nSteps) {
		try {
			final List<String> lines = Files.readAllLines(Paths.get("./steps/test.txt"), DEFAULT_CHARSET);
			for (int i = lines.size() - nSteps; i < lines.size(); i++) {
				final String line = lines.get(i);
				final StringTokenizer tokenizer = new StringTokenizer(line, "\t");
				final ActionType type = ActionType.forName(tokenizer.nextToken());
				
				if (type == null)
					continue;
				
				final String primaryText = tokenizer.nextToken();
				
				switch (type) {
				case ADD:
					tokenizer.nextToken(); // LINE					
					addStep(new AddAction(primaryText, Integer.valueOf(tokenizer.nextToken())));
					break;
					
				case REMOVE:
					tokenizer.nextToken(); // LINE					
					addStep(new RemoveAction(primaryText, Integer.valueOf(tokenizer.nextToken())));
					break;
					
				case REPLACE:
					tokenizer.nextToken(); // WITH
					final String secondaryText = tokenizer.nextToken();
					tokenizer.nextToken(); // LINE
					addStep(new ReplaceAction(Integer.valueOf(tokenizer.nextToken()), primaryText, secondaryText));
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Adds an step locally into the controller
	 * @param step	the step
	 */
	public void addStep(final ActionStep step) {
		steps.add(step);
	}
	
	/**
	 * Gets the steps
	 * @return	the steps
	 */
	public E getSteps() {
		return steps;
	}

	/**
	 * Gets the file master
	 * @return	the file master
	 */
	public FileMaster getMaster() {
		return master;
	}
}

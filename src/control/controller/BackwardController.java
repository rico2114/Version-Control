package control.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

import control.action.ActionStep;
import control.action.handlers.AddActionHandler;
import control.action.handlers.RemoveActionHandler;
import control.action.handlers.ReplaceActionHandler;
import control.action.impl.AddAction;
import control.action.impl.RemoveAction;
import control.action.impl.ReplaceAction;
import control.interpret.FileMaster;

/**
 * Created with eclipse 18/02/2016 10:21:52 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class BackwardController extends Controller<ArrayDeque<ActionStep>> {

	private int loadedSteps;
	
	public BackwardController(FileMaster master) {
		super(new ArrayDeque<ActionStep>(), master);
	}

	public void goBackward(int nSteps) {
		if (nSteps > loadedSteps) {
			System.out.println("Need to load more steps!!!!");
			return;
		}
		
		final ArrayDeque<ActionStep> stepsCopy = new ArrayDeque<>();
		stepsCopy.addAll(getSteps());
		
		getSteps().clear(); // clear loaded older steps
		
		final Iterator<ActionStep> steps = stepsCopy.descendingIterator();
		while (nSteps > 0) {
			final ActionStep next = steps.next();
			
			switch (next.getType()) {
			case ADD:
				AddActionHandler.SINGLETON.reverse(this, (AddAction) next);
				break;
				
			case REMOVE:
				RemoveActionHandler.SINGLETON.reverse(this, (RemoveAction) next);
				break;
				
			case REPLACE:
				ReplaceActionHandler.SINGLETON.reverse(this, (ReplaceAction) next);
				break;
			}
			
			nSteps --;
		}
	}
	
	public void applySteps() {
		try {
			BufferedWriter outputBuffer = new BufferedWriter(new FileWriter("./src/tests/testFileBackward.txt"));
			final List<String> lines = Files.readAllLines(Paths.get("./src/tests/testFile.txt"), DEFAULT_CHARSET);

			
			for (ActionStep step : getSteps()) {
				final int line = step.getLineId();
				
				switch (step.getType()) {
				case ADD:
					lines.set(line, ((AddAction) step).getText());
					break;
				case REMOVE:
					lines.set(line, "");
					break;
				case REPLACE:
					lines.set(line, ((ReplaceAction) step).getResult());
					break;
				}
				
			}
			
			for (String s : lines) {
				outputBuffer.write(s + "\n");
			}
			
			outputBuffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void loadRecentlyStoredSteps(int nSteps) {
		super.loadRecentlyStoredSteps(nSteps);
		loadedSteps = nSteps; 
	}
	

}

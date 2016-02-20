package tests;

import control.controller.BackwardController;
import control.controller.ForwardController;
import control.interpret.FileMaster;

/**
 * Created with eclipse 18/02/2016 8:51:43 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ActionsTests {

	public static void main(String[] args) {
		final FileMaster master = new FileMaster("./lastCommitedFile/testFile.txt", "./src/tests/testFile.txt");
		//doForwardCompilation(master);
		
		doBackwardCompilation(master);
		
	}
	
	public static void doBackwardCompilation(final FileMaster master) {
		final BackwardController controller = new BackwardController(master);
		
		controller.loadRecentlyStoredSteps(2); // Loads the 2 most recent steps added into the steps.txt
		
		controller.goBackward(2); // Tells the version controller to go backward two steps
		controller.applySteps(); // Tells the version controller to apply the steps
	}
	
	public static void doForwardCompilation(final FileMaster master) {
		final ForwardController controller = new ForwardController(master);
		
		controller.interpretSteps(); // Does forward step compilation / interpretation
		controller.saveSteps(); // Saves the steps in the steps.txt
	}
}

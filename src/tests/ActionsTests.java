package tests;

import control.controller.ForwardController;
import control.interpret.FileMaster;

/**
 * Created with eclipse 18/02/2016 8:51:43 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ActionsTests {

	public static void main(String[] args) {
		final FileMaster master = new FileMaster("./control/testFile.txt", "./src/tests/testFile.txt");
		final ForwardController controller = new ForwardController(master);
		
		controller.generateSteps();
		controller.saveSteps();
	}
}

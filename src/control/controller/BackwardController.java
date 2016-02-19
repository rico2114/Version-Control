package control.controller;

import java.util.Stack;

import control.action.ActionStep;
import control.interpret.FileMaster;

/**
 * Created with eclipse 18/02/2016 10:21:52 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class BackwardController extends Controller<Stack<ActionStep>> {

	public BackwardController(FileMaster master) {
		super(new Stack<ActionStep>(), master);
	}

	public void goBackward(final int nSteps) {
		final FileMaster master = getMaster();
		// XXX: TOdo add support for backward
	}
}

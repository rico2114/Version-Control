package control.controller;

import java.util.ArrayList;
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
 * Created with eclipse 18/02/2016 10:19:07 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ForwardController extends Controller<ArrayList<ActionStep>> {

	public ForwardController(FileMaster master) {
		super(new ArrayList<ActionStep>(), master);
	}

	/**
	 * Applies some changes to the un-commited changes and commited ones
	 */
	public void interpretSteps() {
		final FileMaster master = getMaster();
		final List<String> firstFile = master.getLastCommitedFile();
		final List<String> secondFile = master.getUncommitedFile();
		
		for (int lineId = 0; lineId < master.getHighestLine(); lineId++) {
			if (master.lineMatches(lineId)) {
				continue;
			}

			if (!firstFile.get(lineId).isEmpty() && secondFile.get(lineId).isEmpty()) {
				RemoveActionHandler.SINGLETON.apply(this, new RemoveAction(firstFile.get(lineId), lineId));
			} else if (firstFile.get(lineId).isEmpty() && !secondFile.get(lineId).isEmpty()) {
				AddActionHandler.SINGLETON.apply(this, new AddAction(secondFile.get(lineId), lineId));
			} else {
				ReplaceActionHandler.SINGLETON.apply(this, new ReplaceAction(lineId, firstFile.get(lineId), secondFile.get(lineId)));
			}
		}
	}
}

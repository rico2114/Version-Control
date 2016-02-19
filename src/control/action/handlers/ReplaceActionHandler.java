package control.action.handlers;

import control.action.ActionHandler;
import control.action.impl.AddAction;
import control.action.impl.ReplaceAction;
import control.controller.BackwardController;
import control.controller.ForwardController;

/**
 * Created with eclipse 18/02/2016 10:31:27 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ReplaceActionHandler implements ActionHandler<ReplaceAction> {

	public static final ReplaceActionHandler SINGLETON = new ReplaceActionHandler();

	@Override
	public void apply(ForwardController controller, ReplaceAction step) {
		controller.addStep(step);
	}

	@Override
	public void reverse(BackwardController controller, ReplaceAction step) {
		controller.addStep(new AddAction(step.getTarget(), step.getLineId()));
	}

}

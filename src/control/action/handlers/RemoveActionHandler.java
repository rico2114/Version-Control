package control.action.handlers;

import control.action.ActionHandler;
import control.action.impl.AddAction;
import control.action.impl.RemoveAction;
import control.controller.BackwardController;
import control.controller.ForwardController;

/**
 * Created with eclipse 18/02/2016 10:30:49 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class RemoveActionHandler implements ActionHandler<RemoveAction> {

	public static final RemoveActionHandler SINGLETON = new RemoveActionHandler();
	
	@Override
	public void apply(ForwardController controller, RemoveAction step) {
		controller.addStep(step);
	}

	@Override
	public void reverse(BackwardController controller, RemoveAction step) {
		controller.addStep(new AddAction(step.getText(), step.getLineId()));
	}


}

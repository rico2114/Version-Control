package control.action.handlers;

import control.action.ActionHandler;
import control.action.impl.AddAction;
import control.action.impl.RemoveAction;
import control.controller.BackwardController;
import control.controller.ForwardController;

/**
 * Created with eclipse 18/02/2016 10:12:46 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class AddActionHandler implements ActionHandler <AddAction> {

	public static final AddActionHandler SINGLETON = new AddActionHandler();
	
	@Override
	public void apply(ForwardController controller, AddAction step) {
		controller.addStep(step);
	}

	@Override
	public void reverse(BackwardController controller, AddAction step) {
		controller.addStep(new RemoveAction(step.getText(), step.getLineId()));
	}


}

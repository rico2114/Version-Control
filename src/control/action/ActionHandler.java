package control.action;

import control.controller.BackwardController;
import control.controller.ForwardController;

/**
 * Created with eclipse 18/02/2016 9:33:33 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public interface ActionHandler<A extends ActionStep> {

	void apply(final ForwardController controller, A step);
	
	void reverse(final BackwardController controller, A step);
}

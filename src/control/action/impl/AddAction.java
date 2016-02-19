package control.action.impl;

import control.ActionType;
import control.Constants;
import control.action.ActionStep;

/**
 * Created with eclipse 18/02/2016 9:31:48 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class AddAction extends ActionStep {

	private final String text;
	
	public AddAction(final String text, int lineId) {
		super(lineId);
		this.text = text;
	}

	public String getText() {
		return text;
	}
	
	@Override
	public ActionType getType() {
		return ActionType.ADD;
	}

	@Override
	public String saveAttribute() {
		return Constants.ADD_TOKEN.getAsString() + "\t" + text + "\t" + Constants.LINE_TOKEN.getAsString() + "\t" + getLineId();
	}
}

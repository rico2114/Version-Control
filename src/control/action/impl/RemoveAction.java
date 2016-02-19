package control.action.impl;

import control.ActionType;
import control.Constants;
import control.action.ActionStep;

/**
 * Created with eclipse 18/02/2016 9:30:53 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class RemoveAction extends ActionStep {

	private final String text;
	
	public RemoveAction(final String text, int lineId) {
		super(lineId);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	@Override
	public ActionType getType() {
		return ActionType.REMOVE;
	}

	@Override
	public String saveAttribute() {
		return Constants.REMOVE_TOKEN.getAsString() + "\t" + text + "\t" + Constants.LINE_TOKEN.getAsString() + "\t" + getLineId();
	}

}

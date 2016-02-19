package control.action.impl;

import control.ActionType;
import control.Constants;
import control.action.ActionStep;

/**
 * Created with eclipse 18/02/2016 9:18:48 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public class ReplaceAction extends ActionStep {

	private final String target;
	private final String result;
	
	public ReplaceAction(final int lineId, final String target, final String result) {
		super(lineId);
		this.target = target;
		this.result = result;
	}
	
	public String getTarget() {
		return target;
	}
	
	public String getResult() {
		return result;
	}

	@Override
	public ActionType getType() {
		return ActionType.REPLACE;
	}

	@Override
	public String saveAttribute() {
		return Constants.REPLACE_TOKEN.getAsString() + "\t" + target + "\t" + Constants.WITH_TOKEN.getAsString() + "\t" + result + "\t" + Constants.LINE_TOKEN.getAsString() + "\t" + getLineId();
	}

}

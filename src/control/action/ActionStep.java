package control.action;

import control.ActionType;

/**
 * Created with eclipse 18/02/2016 9:18:28 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public abstract class ActionStep {

	private final int lineId;
	
	public ActionStep(final int lineId) {
		this.lineId = lineId;
	}
	
	public int getLineId() {
		return lineId;
	}
	
	public abstract String saveAttribute();
	
	public abstract ActionType getType();

}

package control;

/**
 * Created with eclipse 18/02/2016 9:17:51 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public enum ActionType {

	ADD,
	REMOVE,
	REPLACE;
	
	public static ActionType forName(final String name) {
		for (ActionType type : ActionType.values()) {
			if (type.name().equals(name))
				return type;
		}
		return null;
	}
	
}

package control;

/**
 * Created with eclipse 18/02/2016 6:07:36 p. m.
 * @Author Juan Sebastian Quiceno <Juan.2114@hotmail.com>
 */
public enum Constants {

	LAST_MODIFIED_FILES("./control/"),
	LINE_TOKEN("LINE"),
	ADD_TOKEN("ADD"),
	REMOVE_TOKEN("REMOVE"),
	REPLACE_TOKEN("REPLACE"),
	WITH_TOKEN("WITH");
	
	private final Object value;
	
	Constants(final Object value) {
		this.value = value;
	}
	
	public int getAsInt() {
		return (int) value;
	}
	
	public String getAsString() {
		return (String) value;
	}
	
	public boolean getAsBoolean() {
		return (boolean) value;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getAsT() {
		return (T) value;
	}
}

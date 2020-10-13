package danielsdutra.ka.enumerator;

public enum EnumUFileFunction {

	UNKNOWN(-3), 
	EXIT(-2), 
	CLEAR(-1), 
	
	IS_EXISTS(1), 
	LIST_ALL_SINGLE(2), 
	LIST_ALL_ORDER(3), 
	LIST_ALL_PATTERN(4), 
	LIST_ALL_PATTERN_ORDER(5), 
	WHAT_IS(6), 
	;
	private EnumUFileFunction(Integer value) {
		this.value = value;
	}
	public int getValue() {
		return this.value;
	}
	private int value;
}

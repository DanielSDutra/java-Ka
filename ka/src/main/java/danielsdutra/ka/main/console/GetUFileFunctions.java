package danielsdutra.ka.main.console;

import java.util.regex.Pattern;

import danielsdutra.ka.enumerator.EnumUFileFunction;

public class GetUFileFunctions {

	private Pattern patternClear = Pattern.compile("^(clear\\(\\);)$");
	private Pattern patternIsExists = Pattern.compile("^(isExists\\(').*('\\);)$");
	private Pattern patternWhatIs = Pattern.compile("^(whatIs\\(').*('\\);)$");
	private Pattern patternListAllSingle = Pattern.compile("^(listAll\\(').*('\\);)$");
	private Pattern patternNothingParemters = Pattern.compile("^(?!.*(', ')).*$");
	private Pattern patternListAllOrder = Pattern.compile("^(listAll\\(').*(', ?(ASC|DESC)\\);)$");
	private Pattern patternNothingThreeParemters = Pattern.compile("^(?!.*(', ').*(', ')).*$");
	private Pattern patternListAllPattern = Pattern.compile("^(listAll\\(').*(', ?').*('\\);)$");
	
	private Pattern patternListAllPatternOrder = Pattern.compile("^(listAll\\(').*(', ?').*(', ?(ASC|DESC)\\);)$");

	public EnumUFileFunction getCmd(String strCmd) {

		boolean responseListAllPatternOrder = this.patternListAllPatternOrder.matcher(strCmd).find();
		if ( responseListAllPatternOrder ) return EnumUFileFunction.LIST_ALL_PATTERN_ORDER;

		// ---
		boolean responseNothingThreeParemters = this.patternNothingThreeParemters.matcher(strCmd).find();
		boolean responseListAllPattern = this.patternListAllPattern.matcher(strCmd).find();
		if ( responseListAllPattern && responseNothingThreeParemters ) return EnumUFileFunction.LIST_ALL_PATTERN;

		// ---
		boolean responseListAllOrder = this.patternListAllOrder.matcher(strCmd).find();
		if ( responseListAllOrder && responseNothingThreeParemters ) return EnumUFileFunction.LIST_ALL_ORDER;

		// ---
		boolean responseListAll = this.patternListAllSingle.matcher(strCmd).find();
		boolean responseNothingTwoParemters = this.patternNothingParemters.matcher(strCmd).find();
		if ( responseListAll && responseNothingTwoParemters ) return EnumUFileFunction.LIST_ALL_SINGLE;

		// ---
		boolean responseIsExists = this.patternIsExists.matcher(strCmd).find();
		if ( responseIsExists ) return EnumUFileFunction.IS_EXISTS;

		// ---
		boolean responseWhatIs = this.patternWhatIs.matcher(strCmd).find();
		if ( responseWhatIs ) return EnumUFileFunction.WHAT_IS;

		// ---
		boolean responseClear = this.patternClear.matcher(strCmd).find();
		if ( responseClear ) return EnumUFileFunction.CLEAR;

		// ---
		return EnumUFileFunction.UNKNOWN;
	}
}
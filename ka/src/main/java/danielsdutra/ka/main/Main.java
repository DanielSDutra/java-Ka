package danielsdutra.ka.main;

import java.util.Scanner;

import danielsdutra.ka.enumerator.EnumUFileFunction;
import danielsdutra.ka.main.console.GetUFileFunctions;
import danielsdutra.ka.main.console.ResponseUFile;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		GetUFileFunctions getFunction = new GetUFileFunctions();
		try {
			while ( true ) {
				System.out.print("ka> ");
				// ---
				String strCommand = scanner.nextLine();
				EnumUFileFunction enumUFile = getFunction.getCmd(strCommand);
				
				// ---
				if ( enumUFile.compareTo(EnumUFileFunction.IS_EXISTS) == 0 ) {
					ResponseUFile.isExists(strCommand);
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.LIST_ALL_SINGLE) == 0 ) {
					ResponseUFile.listAllSingle(strCommand);
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.LIST_ALL_ORDER) == 0 ) {
					ResponseUFile.listAllOrder(strCommand);
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.LIST_ALL_PATTERN) == 0 ) {
					ResponseUFile.listAllPattern(strCommand);
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.LIST_ALL_PATTERN_ORDER) == 0 ) {
					ResponseUFile.listAllPatternOrder(strCommand);
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.WHAT_IS) == 0 ) {
					ResponseUFile.whatIs(strCommand);
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.CLEAR) == 0 ) {
					ResponseUFile.toClear();
					
				} else if ( enumUFile.compareTo(EnumUFileFunction.UNKNOWN) == 0 ) { 
					ResponseUFile.toUnknown(strCommand);
					
				} else {
					ResponseUFile.toUnknown(strCommand);
					
				}
			}
		} catch (Exception ex) {
			
		} finally {
			scanner.close();
			
		}
	}
}
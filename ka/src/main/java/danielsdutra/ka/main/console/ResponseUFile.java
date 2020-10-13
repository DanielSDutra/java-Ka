package danielsdutra.ka.main.console;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import danielsdutra.ka.enumerator.EnumFile;
import danielsdutra.ka.enumerator.EnumOrder;
import danielsdutra.ka.exception.ExceptionUnknownOrder;
import danielsdutra.ka.utilis.UFile;

public class ResponseUFile {

	public static void listAllPatternOrder(String strCommand) throws ExceptionUnknownOrder {
		
		String regex = strCommand.replaceAll("^(listAll\\(').*(', ')", "").replaceAll("(', ?(ASC|DESC)\\);)$", "");
		String order = strCommand.replaceAll("^(listAll\\('.*', ?)", "").replaceAll("(\\);)$", "");
		String pathDir = strCommand.replaceAll("^(listAll\\(')", "").replaceAll("(', '.*', ?(ASC|DESC)\\);)$", "");

		
		boolean responseIsExists = UFile.isExists(pathDir);
		
		if ( responseIsExists ) {
			EnumFile enumFile = UFile.whatIs(pathDir);
			
			if ( enumFile.equals(EnumFile.IS_DIRECTORY) ) {
				Pattern pattern = Pattern.compile(regex);

				if ( order.endsWith("ASC") ) { 
					printList(UFile.listAll(pathDir, pattern, EnumOrder.ASC)); 

				} else if ( order.endsWith("DESC") ) { 
					printList(UFile.listAll(pathDir, pattern, EnumOrder.DESC));

				}
			} else {
				printResponseWhatIs(enumFile);

			}
		} else {
			printResponseIsExists(responseIsExists);
			
		}
	}

	public static void listAllPattern(String strCommand) {
		String pathDir = strCommand.replaceAll("^(listAll\\(')", "").replaceAll("(', ').*('\\);)$", "");
		String regex = strCommand.replaceAll("^(listAll\\(').*(', ')", "").replaceAll("('\\);)$", "");

		boolean responseIsExists = UFile.isExists(pathDir);
		if ( responseIsExists ) {
			EnumFile enumFile = UFile.whatIs(pathDir);
			
			if ( enumFile.equals(EnumFile.IS_DIRECTORY) ) {
				Pattern pattern = Pattern.compile(regex);
				printList(UFile.listAll(pathDir, pattern));

			} else {
				printResponseWhatIs(enumFile);

			}
		} else {
			printResponseIsExists(responseIsExists);
			
		}
	}

	public static void listAllOrder(String strCommand) throws ExceptionUnknownOrder {
		String pathDir = strCommand.replaceAll("^(listAll\\(')", "").replaceAll("(', ?(ASC|DESC)\\);)$", "");
		String order = strCommand.replaceAll("^(listAll\\('.*', ?)", "").replaceAll("(\\);)$", "");
		boolean responseIsExists = UFile.isExists(pathDir);
		
		if ( responseIsExists ) {
			EnumFile enumFile = UFile.whatIs(pathDir);

			if ( enumFile.equals(EnumFile.IS_DIRECTORY) ) {
				if ( order.equals("ASC") ) { printList(UFile.listAll(pathDir, EnumOrder.ASC)); }
				if ( order.equals("DESC") ) { printList(UFile.listAll(pathDir, EnumOrder.DESC)); }

			} else {
				printResponseWhatIs(enumFile);
				
			}
		} else {
			printResponseIsExists(responseIsExists);
			
		}
	}

	public static void listAllSingle(String strCommand) {
		String pathDir = strCommand.replaceAll("^(listAll\\(')", "").replaceAll("('\\);)$", "");
		boolean responseIsExists = UFile.isExists(pathDir);

		if ( responseIsExists ) {
			EnumFile enumFile = UFile.whatIs(pathDir);

			if ( enumFile.equals(EnumFile.IS_DIRECTORY) ) {
				printList(UFile.listAll(pathDir));

			} else {
				printResponseWhatIs(enumFile);
				
			}
		} else {
			printResponseIsExists(responseIsExists);
			
		}
	}

	public static void whatIs(String strCommand) {
		String pathDir = strCommand.replaceAll("^(whatIs\\(')", "").replaceAll("('\\);)$", "");
		
		boolean isExists = UFile.isExists(pathDir);
		if ( !isExists ) {
			printResponseIsExists(isExists);

		} else {
			EnumFile enumFile = UFile.whatIs(pathDir);
			printResponseWhatIs(enumFile);

		}
	}

	public static void isExists(String strCommand) {
		String pathName = strCommand.replaceAll("^(isExists\\(')", "").replaceAll("('\\);)$", "");
		boolean response = UFile.isExists(pathName);
		printResponseIsExists(response);
	}

	public static void toClear() throws InterruptedException, IOException {
		if (System.getProperty("os.name").contains("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			System.out.println();
			
		} else {
			Runtime.getRuntime().exec("clear");
			System.out.println();
			
		}
	}

	public static void toUnknown(String strCommand) {
		if ( strCommand.equals("exit();") ) {
			System.out.println("ka: Finished.");
			System.exit(0);
			
		} else {
			System.out.println("ka: Unknown command. Try again.");
			
		}
	}

	// ---
	private static void printResponseWhatIs(EnumFile enumFile) {

		if ( enumFile.equals(EnumFile.IS_ARCHIVE) ) {
			System.out.println("ka: It's archive.");
		
		} else if ( enumFile.equals(EnumFile.IS_DIRECTORY) ) {
			System.out.println("ka: It's directory.");

		} else {
			System.out.println("ka: It's unknown.");
			
		}
	}

	private static void printResponseIsExists(boolean response) {

		if ( response ) {
			System.out.println("ka: Exist.");
			
		} else {
			System.out.println("ka: Not exist.");
			
		}
	}

	private static void printList(List<String> list) {
		if ( list.size() > 0 ) {
			if ( list.size() > 1 ) {
				System.out.println("ka: Files in the directory");
				
			} else {
				System.out.println("ka: File in the directory");
				
			}
			for(String str : list) {
				System.out.println("\t" + str + ";");
				
			}
		} else {
			System.out.println("ka: Nothing files in the directory. Try again.");
			
		}
	}	
}

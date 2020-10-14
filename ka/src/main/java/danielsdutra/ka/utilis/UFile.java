package danielsdutra.ka.utilis;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import danielsdutra.ka.enumerator.EnumFile;
import danielsdutra.ka.enumerator.EnumOrder;
import danielsdutra.ka.exception.ExceptionUnknownOrder;

/**
 * Responsible for managing the methods linked to the exploration of local directories.
 * 
 * @author daniel_dutra
 */
public class UFile {

	/**
	 * 
	 * Informs if the link (of the file or directory) exists.
	 * 
	 * @param pathName link to access the file or directory;
	 * @return <b>true</b> when the file exists and <b>false</b>, otherwise;
	 */
	public static boolean isExists(String pathName) {
		boolean response = new File(pathName).exists();
		if ( !response ) {
			System.out.println("\tCaution: '" + pathName + "' doesn't exist.");
			
		}
		return response;
	}
	/**
	 * Creates a list of file names and directory names for a local link.
	 * 
     * <pre>
     * <b>Caution: </b>It does not differentiate between the names of a file or a directory, but usually the files are accompanied by their extension.
     * </pre>
     * 
	 * @param pathDir link from a local directory, example, 'C:\AppControl\Logs\';
	 * 
	 * @return list with the names of the files and the names of the directories of a local link;
	 */
	public static List<String> listAll(String pathDir) {

		List<String> list = new ArrayList<String>();
		list.clear();
		File file = new File(pathDir);
		File afile[] = file.listFiles();
		int i = 0;
		for (int j = afile.length; i < j; i++) {
			File files = afile[i];
			list.add(files.getName());
			
		}
		return list;
	}
	/**
	 * Creates a list of file names and directory names for a local link, order by EnumOrder.
	 * 
     * <pre>
     * <b>Caution: </b>It does not differentiate between the names of a file or a directory, but usually the files are accompanied by their extension.
     * </pre>
     * 
	 * @param pathDir link from a local directory, example, 'C:\AppControl\Logs\';
	 * 
	 * @param enumOrder type order;
	 * 
	 * @return list with the names of the files and the names of the directories of a local link;
	 * 
	 * @throws ExceptionUnknownOrder if unknown EnumOrder;
	 */
	public static List<String> listAll(String pathDir, EnumOrder enumOrder) throws ExceptionUnknownOrder {
		List<String> list = listAll(pathDir);
		// ---
		if ( enumOrder == EnumOrder.ASC ) {
			Collections.sort(list);
			
		} else if ( enumOrder == EnumOrder.DESC ) {
			Collections.sort(list, Collections.reverseOrder());
			
		} else {
			throw new ExceptionUnknownOrder();
			
		}
		return list;
	}
	/**
	 * Creates a list of file names and directory names that fit a regex.
     * <pre>
     * <b>Caution 01: </b>It does not differentiate between the names of a file or a directory, but,
     * usually files are accompanied by their extension - which can
     * be used in the pattern to identify them.
     * </pre>
	 * @param pathDir pathDir local;
	 * @param pattern pattern for select names;
     * <pre>
     * <b>Caution 02:</b>When Pattern is null, insert all names;
     * </pre>
	 * 
	 * @return list with the names of files in a directory according to a regex;
	 */
	public static List<String> listAll(String pathDir, Pattern pattern) {

		List<String> listResponse = new ArrayList<String>();
		listResponse.clear();
		List<String> listFiles = listAll(pathDir);
		for(String nameFile : listFiles) {
			if ( pattern!= null ) {
				boolean patternResponse = pattern.matcher(nameFile).find();
				
				if ( patternResponse ) {
					listResponse.add(nameFile);
					
				}
			} else {
				listResponse.add(nameFile);
				
			}
		}
		return listResponse;
	}
	/**
	 * Creates a list of file names and directory names for a local link, order by EnumOrder.
	 * 
     * <pre>
     * <b>Caution: </b>It does not differentiate between the names of a file or a directory, but usually the files are accompanied by their extension.
     * </pre>
     * 
	 * @param pathDir link from a local directory, example, 'C:\AppControl\Logs\';
	 * @param pattern pattern for select names;
     * <pre>
     * <b>Caution 02:</b>When Pattern is null, insert all names;
     * </pre>
	 * @param enumOrder type order;
	 * 
	 * @return list with the names of the files and the names of the directories of a local link;
	 * 
	 * @throws ExceptionUnknownOrder if unknown EnumOrder;
	 */
	public static List<String> listAll(String pathDir, Pattern pattern, EnumOrder enumOrder) throws ExceptionUnknownOrder {
		List<String> listFiles = listAll(pathDir);
		// ---
		if ( enumOrder == EnumOrder.ASC ) {
			Collections.sort(listFiles);
			
		} else if ( enumOrder == EnumOrder.DESC ) {
			Collections.sort(listFiles, Collections.reverseOrder());
			
		} else {
			throw new ExceptionUnknownOrder();
			
		}
		// ---
		List<String> listResponse = new ArrayList<String>();
		listResponse.clear();
		for(String nameFile : listFiles) {
			if ( pattern!= null ) {
				boolean patternResponse = pattern.matcher(nameFile).find();
				
				if ( patternResponse ) {
					listResponse.add(nameFile);
					
				}
			} else {
				listResponse.add(nameFile);
				
			}
		}
		return listResponse;
	}
	/**
	 * Tells whether a link is related to a file or directory.
	 * 
	 * @param pathDir link that should be analyzed, example, 'C:\AppControl\Logs\acclient.log';
	 * 
	 * @return IS_DIRECTORY when it's a directory, IS_ARCHIVE when it's a file and IS_DIRECTORY, otherwise the opposite;
	 */
	public static EnumFile whatIs(String pathDir) {
		File file = new File(pathDir);
		if ( file.isDirectory() ) {
			return EnumFile.IS_DIRECTORY;
			
		}
		if ( file.isFile() ) {
			return EnumFile.IS_ARCHIVE;
			
		}
		return EnumFile.IS_UNKNOWN;
	}
}
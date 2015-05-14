import java.util.*;
import java.io.*;

/**
 * This class takes in a text file containing data either separated by spaces or commas and creates percentages of how often the 
 * numbers 1-9 occur.
 * 
 * @author Chayse Summers - John Nguyen
 * @class CSC143 - Gandham
 * @date 5/14/15
 *
 */
public class Benford {
	private static List<Double> benfordList;
	
	/**
	 * Default constructor.
	 */
	public Benford(){
		benfordList = new ArrayList<Double>();
	}
	
	public String[] introduction(Scanner console){
		System.out.println("Welcome, this program can plot bar graphs for the percentages of populations in a text file.");
		System.out.println("Text file should be formatted as a comma separated value text file or as follows per line...");
		System.out.println("Example of 1st line: [Country Name] [Population]");
		System.out.print("Please enter the title of this data: ");
		String[] input = new String[2];
		input[0] =console.nextLine();
		System.out.print("Please enter the file pathway: ");//E:/CSC142_143/DataFiles/popData.txt
		input[1] = console.next();
		
		return input;
	}
	
	/**
	 * Takes in a file pathway and checks through the data for creating a count of the occurrence of the numbers 1-9. 
	 * @param inputFile i.e. file pathway gathered in console.
	 */
	public void readCounts(String inputFile){
		String x;
		char y;
		List<Integer> temp = new ArrayList<Integer>();
		try {
			Scanner fileScanner = new Scanner(new File (inputFile));
			inputFile  = inputFile.replace(',', '\n');
			System.out.print("Loading counts... ");
			while(fileScanner.hasNext()){
				x = fileScanner.next();
				String[] z = x.split(",");
				for(String element: z){
					y = element.charAt(0);
					if(y>48 && y<=57){
						temp.add((int)y);
					}
					else{
						
					}
				}
			}
			fileScanner.close();
			System.out.println(" done.");
				
		} catch (FileNotFoundException e) {
			System.out.println("File not found, please check pathway and try again.");
			
		}
		
		int[] counts = new int[9];
		for(int number:temp){
			counts[number-49] = counts[number-49]+1;
		}
		benfordPercents(counts);
	}
	
	/**
	 * Takes in list of counts and turns each into a percentage.
	 * @param counts list of the occurrence of the numbers 1-9.
	 */
	public void benfordPercents(int[] counts){
		double total = 0.0;
		for(int count:counts){
			total = total + count;
		}
		for(int count:counts){
			benfordList.add((count/total)*100);
		}
		
	}

	/**
	 * 
	 * @return percentages
	 */
	public List<Double> getBenfordList() {
		return benfordList;
	}
	
	/**
	 * @return doubleList of expected Benford Percentages i.e. Frequencies.
	 */
	public List<Double> getBenfordFrequencies(){
		List<Double> benF = new ArrayList<Double>();
		double[] bFreq = {30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
		for(double number: bFreq){
			benF.add(number);
		}
		return(benF);
		
	}
}

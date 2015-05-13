import java.util.*;
import java.io.*;

/**
 * This class
 * @author Chayse Summers
 * @class CSC143 - Gandham
 * @date 5/8/15
 *
 */
public class Benford {
	private static List<Double> benfordList;
	
	public Benford(){
		benfordList = new ArrayList<Double>();
	}
	
	public void readCounts(String inputFile){
		String x;
		char y;
		List<Integer> temp = new ArrayList<Integer>();
		try {
			Scanner fileScanner = new Scanner(new File (inputFile));
			System.out.print("Loading counts... ");
			while(fileScanner.hasNext()){
				x = fileScanner.next();
				y = x.charAt(0);
				if(y>48 && y<=57){
					temp.add((int)y);
				}
				else{
					
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
	
	public void benfordPercents(int[] counts){
		double total = 0;
		for(int count:counts){
			total = total + count;
		}
		for(int count:counts){
			benfordList.add((count/total)*100);
		}
		
	}

	public List<Double> getBenfordList() {
		return benfordList;
	}

	public static void setBenfordList(List<Double> benfordList) {
		Benford.benfordList = benfordList;
	}
	
	public double[] getBenfordFrequencies(){
		double[] bFreq = {30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
		return(bFreq);
	}
	

}

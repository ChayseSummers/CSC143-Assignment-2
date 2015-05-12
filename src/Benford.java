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
	private static List<Integer> benfordList;
	
	public Benford(){
		benfordList = new ArrayList<Integer>();
	}
	
	public void readCounts(String inputFile){
		String x;
		char y;
		try {
			Scanner fileScanner = new Scanner(new File (inputFile));
			System.out.print("Loading counts... ");
			while(fileScanner.hasNext()){
				x = fileScanner.next();
				y = x.charAt(0);
				if(y>48 && y<=57){
					benfordList.add((int)y);
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
		System.out.println(benfordList.size());
		for(int number:benfordList){
			counts[number-49] = counts[number-49]+1;
		}
		benfordList.clear();
		for(int number:counts){
			benfordList.add(number);
		}
		benfordPercents();
		}
	
	public void benfordPercents(){
		double[] percents = new double[9];
		double total = 0;
		int i = 0;
		for(int count:benfordList){
			total = total + count;
		}
		for(int count:benfordList){
			percents[i] = (count/total)*100;
			System.out.printf("%.1f percent\n",percents[i]);
			i++;
		}
		
	}

	public static List<Integer> getBenfordList() {
		return benfordList;
	}

	public static void setBenfordList(List<Integer> benfordList) {
		Benford.benfordList = benfordList;
	}
	
	public double[] getBenfordFrequencies(){
		double[] bFreq = {30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
		return(bFreq);
	}
	

}

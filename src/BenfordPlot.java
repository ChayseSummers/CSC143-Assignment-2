import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;


public class BenfordPlot {
	private static int cWidth = 600;
	private static int cHeigth = 400;
	private static List<Double> benfordFrequencies = new ArrayList<Double>();//{30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
	private static int x = 10;
	private static int y = 0;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("Welcome, this program can plot bar graphs for the percentages of populations in a text file.");
		System.out.println("Text file should be formatted as follows per line...");
		System.out.println("Example of 1st line: [Country Name] [Population]");
		Benford x = new Benford();
		for(double number: x.getBenfordFrequencies()){
			benfordFrequencies.add(number);
		}
		System.out.print("Please enter the file pathway: ");//E:/CSC142_143/DataFiles/popData.txt
		x.readCounts(console.next());
		DrawingPanel canvas = new DrawingPanel(cWidth,cHeigth);
		canvas.setBackground(Color.black);
		Graphics2D pen = canvas.getGraphics();
		plotData(x.getBenfordList(), pen, "Population of Countries");
		canvas = new DrawingPanel(cWidth,cHeigth);
		pen = canvas.getGraphics();
		canvas.setBackground(Color.black);
		plotData(benfordFrequencies, pen, "Benford Analysis - Benford Frequencies");

	}

	private static void plotData(List<Double> list, Graphics2D pen, String title) {
		pen.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
		int i = 0;
		int j = 0;
		int bar =0;
		
		for(double number: list){
			bar = (int)(cWidth*(number/35));
			i ++;
			y += 40;
			pen.setColor(Color.YELLOW);
			pen.fillRect(x+10, y, bar, 20);
			pen.drawString(String.valueOf(i), x-2, y+15);	
			number = (double)Math.round(number*10)/10;
			pen.setColor(Color.RED);
			pen.drawString(title, cWidth/3, 20);
			pen.drawString(String.valueOf(number), bar/2, y+15);
			pen.drawString("^",(int)(cWidth*(benfordFrequencies.get(j)/35)), y+15);
			j++;
		}
		x = 10;
		y = 0;
	}

}

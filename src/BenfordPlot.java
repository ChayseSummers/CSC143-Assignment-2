import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
import java.lang.*;


public class BenfordPlot {
	private static int cWidth = 600;
	private static int cHeigth = 400;
	private static List<Double> benfordFrequencies = new ArrayList();//{30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
	private static int x = 10;
	private static int y = 0;

	public static void main(String[] args) {
		DrawingPanel canvas = new DrawingPanel(cWidth,cHeigth);
		Graphics2D pen = canvas.getGraphics();
		Benford x = new Benford();
		x.readCounts("E:/CSC142_143/DataFiles/popData.txt");
		System.out.println(x.getBenfordList());
		plotData(x, pen);
		
		//pen.setColor(Color.RED);
		//pen.fillRect(10, 10, 500, 20);

	}

	private static void plotData(Benford data, Graphics2D pen) {
		List<String> temp = new ArrayList();
		double[] bf = {30.1, 17.6, 12.5, 9.7, 7.9, 6.7, 5.8, 5.1, 4.6};
		for(double number: data.getBenfordFrequencies()){
			pen.setBackground(Color.black);
			y += 40;
			pen.setColor(Color.BLACK);
			pen.drawString("Number here", x, y);	
			pen.setColor(Color.YELLOW);
			pen.fillRect(x+10, y, (int)(cWidth*(number/35)), 20);
		}
		
	}

}

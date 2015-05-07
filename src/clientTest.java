
public class clientTest {

	public static void main(String[] args) {
		Benford x = new Benford();
		x.readCounts("E:/CSC142_143/DataFiles/popData.txt");
		System.out.println(x.getBenfordList());//

	}

}

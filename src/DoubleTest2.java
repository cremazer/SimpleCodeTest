import java.text.DecimalFormat;

public class DoubleTest2 {
	public static void main(String[] args) {
		// 진행도 출력
		double d_cnt = 38168;
		double d_total = 3262623;
		DecimalFormat df = new DecimalFormat("#.##"); 
//		DecimalFormat df = new DecimalFormat("#.#"); 
		double percent = Double.parseDouble(df.format( d_cnt/d_total*100 ));
		
		System.out.println(percent);
	}
}

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest2 {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
////		System.out.println(Integer.parseInt(formattedDate));
//		System.out.println(Integer.parseInt("2147483647"));	// max
		System.out.println(Long.parseLong(formattedDate));
		
		Date date2 = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH");
		String formattedDate2 = sdf2.format(date2);
		System.out.println(formattedDate2);
////		System.out.println(Integer.parseInt(formattedDate));
//		System.out.println(Integer.parseInt("2147483647"));	// max
		System.out.println(Long.parseLong(formattedDate2));
	}
}

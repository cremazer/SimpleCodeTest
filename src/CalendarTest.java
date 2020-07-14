import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar nextAnnounceCal = Calendar.getInstance();
		Date date = nextAnnounceCal.getTime();             
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일");
		String nextAnnounceDate = sdf.format(date);  
		System.out.println(nextAnnounceDate);
	}
}

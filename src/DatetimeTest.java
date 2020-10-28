import java.sql.Timestamp;

/**
 * 
 * @author cremazer
 *
 */
public class DatetimeTest {
	public static void main(String[] args) {

		System.out.println(System.currentTimeMillis());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		
		System.out.println(timestamp.getTime());
	}
}

import java.util.regex.Pattern;

public class PatternTest {
	public static void main(String[] args) {
		String regex = "/goods/360images/barcode/[A-Z]-[0-9]*";
		String requestURI = "/goods/360images/barcode/T-13601";
		
		boolean result = matchRequestURI(regex, requestURI);
		System.out.println("result=" + result);
	}

	private static boolean matchRequestURI(String regex, String requestURI) {
		
		return Pattern.matches(regex, requestURI);
	}
	
}

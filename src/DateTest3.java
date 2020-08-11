import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Calendar 예제
 * 
 * 참고 http://blog.naver.com/javaking75/140187852894
 * 
 * @author cremazer
 *
 */
public class DateTest3 {
	public static void main(String[] args) {

		// 1달 날짜 조회
		int year = 2020;

		for (int month = 1; month <= 12; month++) {

			Calendar cal = Calendar.getInstance(); // 캘린더 인스턴스 얻기

	        int today = cal.get(Calendar.DATE); //오늘 일자 저장

			// 원하는 년도 날짜 세팅
			 cal.set(Calendar.YEAR, year);
			 cal.set(Calendar.MONTH, month - 1);

			cal.set(Calendar.DATE, 1); // 현재 달을 1일로 설정.
			int sDayNum = cal.get(Calendar.DAY_OF_WEEK); // 1일의 요일 얻어오기, SUNDAY (1) .MONDAY(2) , TUESDAY(3),.....
			int endDate = cal.getActualMaximum(Calendar.DATE); // 달의 마지막일 얻기

			// 콘솔 출력
			// System.out.println("startDATE="+cal.get(Calendar.DATE));
			// System.out.println("sDayNum="+sDayNum);
			// System.out.println("endDate="+endDate);

			int nowYear = cal.get(Calendar.YEAR);
			int nowMonth = cal.get(Calendar.MONTH) + 1;
			
			System.out.println("===================== " + nowYear + "년  " + nowMonth + "월 ==================");

			int sDay = sDayNum;

			// 요일명 출력
//			System.out.println(" 일\t 월\t 화\t 수\t 목\t 금\t 토\t");
//			System.out.println("====================================================");
			// 1일이 시작되는 이전의 요일 공백으로 채우기
//			for (int i = 1; i < sDayNum; i++) {
//				System.out.printf("%3s\t", "★");
//			} // for-----------------
//			for (int i = 1; i <= endDate; i++) { // 1부터 마지막일까지 반복.
//
//				if (i == today)
//					System.out.printf("[%2d]\t", i); // 오늘 날짜 표시
//				else
//					System.out.printf("%3d\t", i); // 일반 출력
//
//				if (sDay % 7 == 0)
//					System.out.println(); // 요일이 7배수가 되면 줄바꿈.
//				sDay++; // 요일 카운트
//			} // for-----------------

			
			String sMonth = (nowMonth < 10 ? "0" : "") + nowMonth;
			
			// DATE로 표시하기
			System.out.println("====================================================");
			System.out.println("날짜\t요일번호\t휴일여부");
			System.out.println("====================================================");
			for (int i = 1; i <= endDate; i++) { // 1부터 마지막일까지 반복.
				
				cal.set(Calendar.DATE, i);
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
				String yyyymmdd = sdf.format(cal.getTime());
				
				int day = cal.get(Calendar.DATE);				
				String sDate = (day < 10 ? "0" : "") + day;
				
				int day_of_week = cal.get(Calendar.DAY_OF_WEEK);
				String isHoliday = "N";
				if (day_of_week == 1 || day_of_week == 7) {
					isHoliday = "Y";
				}
				
				// 출력 : 날짜	요일번호	휴일여부
//				System.out.println();
//				System.out.println((nowYear + sMonth + sDate) + "\t" + day_of_week + "\t" + isHoliday);
				System.out.println(yyyymmdd + "\t" + day_of_week + "\t" + isHoliday);
				
//				if (day == today)
//					System.out.printf("[%2d]\t", day); // 오늘 날짜 표시
//				else
//					System.out.printf("%3d\t", day); // 일반 출력
//	
//				if (sDay % 7 == 0)
//					System.out.println(); // 요일이 7배수가 되면 줄바꿈.
//				sDay++; // 요일 카운트
			} // for-----------------
				
			System.out.println();
		}

	}

	/**
	 * 두 날짜 비교
	 * 
	 * @param date1 (YYYYMMDD)
	 * @param date2 (YYYYMMDD)
	 * @return
	 */
	public static boolean dateCompare(String firstDate, String secondDate) {
		boolean result = false;
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();

		if (firstDate != null && !"".equals(firstDate)) {

			// YYYYMMDD 형식으로 설정
			String date1 = firstDate.replaceAll("-", "");
			date1 = date1.replaceAll("/", "");

			// 기준 날짜가 지정되어 있다면 입력된 날짜로 설정한다.
			int year = Integer.parseInt(date1.substring(0, 4));
			int month = Integer.parseInt(date1.substring(4, 6));
			int day = Integer.parseInt(date1.substring(6, 8));

			cal1.set(year, month - 1, day);
		}

		if (secondDate != null && !"".equals(secondDate)) {

			String date2 = secondDate.replaceAll("-", "");
			date2 = date2.replaceAll("/", "");

			// 비교할 대상의 날짜가 지정되어 있다면 입력된 날짜로 설정한다.
			int year = Integer.parseInt(date2.substring(0, 4));
			int month = Integer.parseInt(date2.substring(4, 6));
			int day = Integer.parseInt(date2.substring(6, 8));

			cal2.set(year, month - 1, day);

		}

//		System.out.println(cal1.compareTo(cal2));

		if (cal1.compareTo(cal2) > 0) {
			// 비교값이 0보다 크면, 앞의 날짜가 더 크다
			result = true;
		}

		return result;
	}

	/**
	 * 날짜 가져오기
	 * 
	 * SimpleDateFormat pattern example yyyy-MM-dd 1969-12-31 yyyy-MM-dd 1970-01-01
	 * yyyy-MM-dd HH:mm 1969-12-31 16:00 yyyy-MM-dd HH:mm 1970-01-01 00:00
	 * yyyy-MM-dd HH:mmZ 1969-12-31 16:00-0800 yyyy-MM-dd HH:mmZ 1970-01-01
	 * 00:00+0000 yyyy-MM-dd HH:mm:ss.SSSZ 1969-12-31 16:00:00.000-0800 yyyy-MM-dd
	 * HH:mm:ss.SSSZ 1970-01-01 00:00:00.000+0000 yyyy-MM-dd'T'HH:mm:ss.SSSZ
	 * 1969-12-31T16:00:00.000-0800 yyyy-MM-dd'T'HH:mm:ss.SSSZ
	 * 1970-01-01T00:00:00.000+0000
	 * 
	 * @param recDate 기준날짜, "" 일시 오늘 날짜
	 * @param val     일 수(-:과거,+:미래)
	 * @param ymdType 년월일 구분 (D:일,M:월,Y:년)
	 * @param pattern 형식 (예:yyyy-MM-dd)
	 * @return 계산된 날짜
	 */
	public static String getDate(String recDate, int val, String ymdType, String pattern) {

		int year = 0;
		int month = 0;
		int day = 0;

		Calendar cal = Calendar.getInstance();

		if ("".equals(recDate)) {
			// 현재 날짜 설정
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
			day = cal.get(Calendar.DAY_OF_MONTH);
		} else {
			// 기준 날짜 설정
			year = Integer.parseInt(recDate.substring(0, 4));
			month = Integer.parseInt(recDate.substring(4, 6));
			day = Integer.parseInt(recDate.substring(6, 8));
			cal.set(year, month - 1, day);
		}

		// 날짜 차이 설정
		if (val != 0) {
			if ("D".equals(ymdType)) {
				cal.add(Calendar.DAY_OF_MONTH, val);
			} else if ("M".equals(ymdType)) {
				cal.add(Calendar.MONTH, val);
			} else if ("Y".equals(ymdType)) {
				cal.add(Calendar.YEAR, val);
			} else {
				cal.add(Calendar.DAY_OF_MONTH, val);
			}
		}

		SimpleDateFormat sdf = new SimpleDateFormat(pattern);

		return sdf.format(cal.getTime());
	}
}

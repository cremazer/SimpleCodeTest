import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Calendar 예제
 * 
 * 참고
 * https://code-examples.net/ko-kr/q/50e3ea
 * http://arabiannight.tistory.com/entry/%EC%9E%90%EB%B0%94Java-Calendar-%EC%82%AC%EC%9A%A9%EB%B2%95-%EA%B8%B0%EB%B3%B8%EC%98%88%EC%A0%9C-%ED%8F%AC%ED%95%A8
 * http://jamesdreaming.tistory.com/103
 * 
 * @author cremazer
 *
 */
public class DateTest {
	public static void main(String[] args) {
		
		// 마지막 회차 등록일시
		int lastWinCount = 838;
		String lastCrDt = "20181215203900";
//		int lastWinCount = 837;
//		String lastCrDt = "20181208203900";
//		int lastWinCount = 836;
//		String lastCrDt = "20181207203900";
		
//		System.out.println();
//		System.out.println(lastCrDt.substring(4, 6));
//		System.out.println(lastCrDt.substring(6, 8));
//		System.out.println(lastCrDt.substring(8, 10));
//		System.out.println(lastCrDt.substring(10, 12));
//		System.out.println(lastCrDt.substring(12, 14));
		
		Calendar lastCrDtCal = Calendar.getInstance();
		lastCrDtCal.set(Calendar.YEAR, Integer.parseInt(lastCrDt.substring(0, 4)));
		lastCrDtCal.set(Calendar.MONTH, Integer.parseInt(lastCrDt.substring(4, 6)) - 1);
		lastCrDtCal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(lastCrDt.substring(6, 8)));
		lastCrDtCal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(lastCrDt.substring(8, 10)));
		lastCrDtCal.set(Calendar.MINUTE, Integer.parseInt(lastCrDt.substring(10, 12)));
		lastCrDtCal.set(Calendar.SECOND, Integer.parseInt(lastCrDt.substring(12, 14)));
		
		
		
		
		int year = 0;
		int month = 0;
		int day = 0;
		
		Calendar todayCal = Calendar.getInstance();
		year = todayCal.get(Calendar.YEAR);		
		month = todayCal.get(Calendar.MONTH) + 1;
		day = todayCal.get(Calendar.DAY_OF_MONTH);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);

		System.out.println(getDate("", 0, null, "yyyy-MM-dd HH:mm:ss"));
		System.out.println(todayCal.getTime());
		System.out.println(todayCal.get(Calendar.DAY_OF_WEEK));

		// 토요일 설정
//		todayCal.set(Calendar.YEAR, 2018);
//		todayCal.set(Calendar.MONTH, 12 - 1);
//		todayCal.set(Calendar.DAY_OF_MONTH, 15);
//		todayCal.set(Calendar.HOUR_OF_DAY, 9);
//		todayCal.set(Calendar.MINUTE, 0);
//		todayCal.set(Calendar.SECOND, 0);
		System.out.println();
		System.out.println(todayCal.getTime());
		System.out.println(todayCal.get(Calendar.DAY_OF_WEEK));
		
//		Date today = calendar.getTime();
//		System.out.println(today.getDay());
		
		// 다음 발표일자
		System.out.println();
		System.out.println("다음 발표일자");
		
		
		
		// 토요일 20시 마감
		Calendar nextAnnounceCal = Calendar.getInstance();
		
		// 금요일 설정 OK
//		nextAnnounceCal.set(Calendar.YEAR, 2018);
//		nextAnnounceCal.set(Calendar.MONTH, 12 - 1);
//		nextAnnounceCal.set(Calendar.DAY_OF_MONTH, 15);
//		nextAnnounceCal.set(Calendar.HOUR, 9);
//		nextAnnounceCal.set(Calendar.MINUTE, 0);
//		nextAnnounceCal.set(Calendar.SECOND, 0);
		
		// 오늘이 토요일인가?
		if (7 == todayCal.get(Calendar.DAY_OF_WEEK)
				&& 20 > todayCal.get(Calendar.HOUR)
				) {
			// 토요일이면 당일날 마감일시로 설정
			
			nextAnnounceCal.set(Calendar.HOUR_OF_DAY, 20);
			nextAnnounceCal.set(Calendar.MINUTE, 0);
			nextAnnounceCal.set(Calendar.SECOND, 0);
		} else {
			// 토요일이 아니라면 다음 토요일 설정
			
			nextAnnounceCal.add(Calendar.DAY_OF_MONTH, 1);    //1일 후
			for (int i = 0; i < nextAnnounceCal.DAY_OF_WEEK; i++) {
				Date date = nextAnnounceCal.getTime();
//			System.out.println(date.getDay());
//			System.out.println(date.getMonth()+1);
//			System.out.println(date.getDate());
				year = date.getYear();
				month = date.getMonth()+1;
				day = date.getDate();
				if(date.getDay() == 6){
					break;
				}
				nextAnnounceCal.add(Calendar.DAY_OF_MONTH, 1);    //1일 후
			}
		}
		
		year = nextAnnounceCal.get(Calendar.YEAR);		
		month = nextAnnounceCal.get(Calendar.MONTH) + 1;
		day = nextAnnounceCal.get(Calendar.DAY_OF_MONTH);
		
		nextAnnounceCal.set(Calendar.HOUR_OF_DAY, 20);
		nextAnnounceCal.set(Calendar.MINUTE, 0);
		nextAnnounceCal.set(Calendar.SECOND, 0);
		
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(nextAnnounceCal.getTime());
		
		// 두 날짜 비교
		long diffSec = (nextAnnounceCal.getTimeInMillis() - lastCrDtCal.getTimeInMillis()) / 1000;		
		long diffDays = diffSec / (24*60*60);
		System.out.println(diffDays);
//		SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
//		cal.setTime(sdf.parse("Mon Mar 14 16:02:37 GMT 2011"));// all done
		
		// 다음 예상번호
		int nextWinCount = lastWinCount + ((int)diffDays / 7) + ((int)diffDays % 7 > 0 ? 1 : 0);
		System.out.println("다음 예상번호 : " + nextWinCount);
		
		// 미입력 회차 확인
		if ((int)diffDays / 7 >= 1
				&& (int)diffDays % 7 > 0) {
			System.out.println("미입력된 당첨번호가 존재합니다.");
		}
	}
	
	/**
	 * 두 날짜 비교
	 * 
	 * @param date1
	 *            (YYYYMMDD)
	 * @param date2
	 *            (YYYYMMDD)
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
	   * SimpleDateFormat pattern example
	   * 	yyyy-MM-dd 1969-12-31
	   *    yyyy-MM-dd 1970-01-01
	   *    yyyy-MM-dd HH:mm 1969-12-31 16:00
	   *    yyyy-MM-dd HH:mm 1970-01-01 00:00
	   *    yyyy-MM-dd HH:mmZ 1969-12-31 16:00-0800
	   *    yyyy-MM-dd HH:mmZ 1970-01-01 00:00+0000
	   *    yyyy-MM-dd HH:mm:ss.SSSZ 1969-12-31 16:00:00.000-0800
	   *    yyyy-MM-dd HH:mm:ss.SSSZ 1970-01-01 00:00:00.000+0000
	   *    yyyy-MM-dd'T'HH:mm:ss.SSSZ 1969-12-31T16:00:00.000-0800
	   *    yyyy-MM-dd'T'HH:mm:ss.SSSZ 1970-01-01T00:00:00.000+0000
	   *    
	   * @param recDate 기준날짜, "" 일시 오늘 날짜
	   * @param val 일 수(-:과거,+:미래)
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
			  //현재 날짜 설정
			  year = cal.get(Calendar.YEAR);
			  month = cal.get(Calendar.MONTH) + 1;
			  day = cal.get(Calendar.DAY_OF_MONTH);
		  } else {
			  //기준 날짜 설정
			  year = Integer.parseInt(recDate.substring(0, 4));
			  month = Integer.parseInt(recDate.substring(4, 6));
			  day = Integer.parseInt(recDate.substring(6, 8));
			  cal.set(year, month - 1, day);
		  }
		  
		  //날짜 차이 설정
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

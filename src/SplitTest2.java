
public class SplitTest2 {
	public static void main(String[] args) {
		String data = "쿠팡을 추천 합니다! 고메 바삭 튀겨낸 멘치 돈카츠 (냉동) https://link.coupang.com/re/SHAREA?pageKey=257809466&itemId=808777327&vendorItemId=5056982139&shareChannel=kakaoTalk";
		// url만 추출하기
		System.out.println(data.indexOf("https://"));
		System.out.println(data.substring(data.indexOf("https://")));
		
		String pkData = data.substring(data.indexOf("pageKey="));
		System.out.println(pkData.indexOf("&"));
		
	}
}

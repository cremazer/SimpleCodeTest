
public class SplitTest {
	public static void main(String[] args) {
//		String data = "당첨번호 1 2 3 4 5 6";
//		String[] datas = data.split(" ");
//		for (int i = 0; i < datas.length; i++) {
//			System.out.println(datas[i]);
//		}
		
		String data = "https://link.coupang.com/re/SHAREA?pageKey=35666923&itemId=132309687&vendorItemId=3000213311&shareChannel=kakaoTalk";
		// pageKey 추출하기
		System.out.println(data.indexOf("pageKey="));
		System.out.println(data.substring(data.indexOf("pageKey=")));
		
		String pkData = data.substring(data.indexOf("pageKey="));
		System.out.println(pkData.indexOf("&"));
		
		String strPageKey = pkData.substring(0, pkData.indexOf("&"));
		System.out.println(strPageKey);
		
		String pageKey = strPageKey.split("=")[1];
		System.out.println(pageKey);
		
		// product_id 추출하기
		System.out.println(data.indexOf("itemId="));
		System.out.println(data.substring(data.indexOf("itemId=")));
		
		String pidData = data.substring(data.indexOf("itemId="));
		System.out.println(pidData.indexOf("&"));
		
		String strProductId = pidData.substring(0, pidData.indexOf("&"));
		System.out.println(strProductId);
		
		String productId = strProductId.split("=")[1];
		System.out.println(productId);
		
	}
}

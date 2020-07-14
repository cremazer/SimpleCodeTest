
public class SubstringTest {
	public static void main(String[] args) {
		String data = "/sysmng/smgoodsmng";
//		String data = "/sysmng/smgoodsmng/writeSmGoodsInfo";

		System.out.println("data = " + data.substring(0, 17 + 1));
		
		// 3번째 위치 이전까지만 설정
		int idx = 0;
		for (int i = 0; i < data.length(); i++) {
			System.out.println(data.substring(i, i+1));
			if ("/".equals(data.substring(i, i+1))) {
				idx++;
			}
			
			if (idx == 3) {
				data = data.substring(0, i);
				break;
			}
		}
		
		System.out.println("result=" + data);
	}
}

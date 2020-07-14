import java.util.ArrayList;
import java.util.List;

public class SplitTest3 {
	public static void main(String[] args) {
//		String data = "smlotto@naver.com";
//		System.out.println(data.split("@")[0]);
		
		List<String> exptDataList = new ArrayList<String>();
//		exptDataList.add("3,9,14,18,26,37");
		exptDataList.add("");
		
		for (int i = 0; i < exptDataList.size(); i++) {
			String[] datas = exptDataList.get(i).split(",");
			
			for (int j = 0; j < datas.length; j++) {
				System.out.println(datas[j]);
			}
		}
	}
}

import java.util.HashMap;
import java.util.Map;



public class UpperLeftTest {
	public static void main(String[] args) {
		int[] numbers = {4, 9, 17, 18, 26, 42};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i],1);
		}
		
		int[][] arrNumbers = {
				{0, 0, 0, 4, 0, 0, 0}, 
				{0, 9, 0, 0, 0, 0, 0}, 
				{0, 0, 17, 18, 0, 0, 0}, 
				{0, 0, 0, 0, 26, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 0}, 
				{0, 0, 0, 0, 0, 0, 42}, 
				{0, 0, 0, 0, 0, 0, 0} 
			};
		
		int checkCnt = 0;
		for (int row = 0; row < arrNumbers.length; row++) {
			for (int col = 0; col < arrNumbers[row].length - row; col++) {
				if (map.containsKey(arrNumbers[row][col])) {
					checkCnt++;
				}
			}
			
			// 결과체크
			if (checkCnt == 6) {
				break;
			}
		}
		
		// 결과체크
		if (checkCnt == 6) {
			System.out.println(true);
		} else {
			System.out.println("checkCnt=" + checkCnt);
		}
		
		
		for (int i = 0; i < numbers.length; i++) {
			int row = numbers[i] / 7;
			int col = numbers[i] % 7 - 1;
			
			if(row > 0 && (numbers[i] % 7 == 0)){
				row -= 1;
				col = 6;
			}
			
			arrNumbers[row][col] = numbers[i]; 
		}
		
		for (int i = 0; i < arrNumbers.length; i++) {
			String data = "";
			for (int j = 0; j < arrNumbers[i].length; j++) {
				if (j > 0) {
					data += ",";
				}
				data += arrNumbers[i][j];
			}
			System.out.println(data);
		}
	}
}

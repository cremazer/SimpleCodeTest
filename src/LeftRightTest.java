import java.util.HashMap;
import java.util.Map;

public class LeftRightTest {
	public static void main(String[] args) {
		boolean result = false;
		result = checkLeftRightLinesRange();
		if(result) {
			String comments = "좌우2줄 포함 제외 (로또용지기준)";
			System.out.println(comments);
		} else {
			System.out.println("좌우2줄 통과");
		}
	}
	
	public static boolean checkLeftRightLinesRange() {
		boolean check = false;
		
		int[] numbers = {7,13,15,27,29,44};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			map.put(numbers[i],1);
		}
		
		int[][] arrNumbers = getArrayLikePaper(numbers);
		
		for (int row = 0; row < arrNumbers.length; row++) {
			String data = "";
			for (int col = 0; col < arrNumbers[row].length; col++) {
				if (col > 0 ) {
					data += ",";
				}
				data += arrNumbers[row][col];
			}
			System.out.println(data);
		}
		
		System.out.println(arrNumbers.length);
		System.out.println(arrNumbers[0].length);
		
		int checkCnt = 0;		
		for (int row = 0; row < arrNumbers.length; row++) {
			for (int col = 0; col < arrNumbers[row].length; col++) {
				// 3,4,5열 체크 제외
				if (2 <= col && col <= 4) {
					continue;
				}
				
				System.out.println(arrNumbers[row][col] + " 체크");
				System.out.println(map.containsKey(arrNumbers[row][col]));
				
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
			check = true;
		}
		
		System.out.println("checkCnt="+checkCnt);
		
		return check;
	}
	
	public static int[][] getArrayLikePaper(int[] numbers) {
		int[][] arrNumbers = {
			{0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0}, 
			{0, 0, 0, 0, 0, 0, 0} 
		};
		
		for (int i = 0; i < numbers.length; i++) {
			int row = numbers[i] / 7;
			int col = numbers[i] % 7 - 1;
			
			if(row > 0 && (numbers[i] % 7 == 0)){
				row -= 1;
				col = 6;
			}
			
			arrNumbers[row][col] = numbers[i]; 
		}
		
		return arrNumbers;
	}
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * X패턴 분석
 * @author cremazer
 *
 */
public class ArrayTest3 {
	public static void main(String[] args) {
		int[][] arrNumbers = { 
			{ 1, 2, 3, 4, 5, 6, 7 }, 
			{ 8, 9, 10, 11, 12, 13, 14 }, 
			{ 15, 16, 17, 18, 19, 20, 21 },
			{ 22, 23, 24, 25, 26, 27, 28 }, 
			{ 29, 30, 31, 32, 33, 34, 35 }, 
			{ 36, 37, 38, 39, 40, 41, 42 }, 
			{ 43, 44, 45, 46, 47, 48, 49 } 
		};

		Map<Integer, Integer> lineMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> excludeMap = new HashMap<Integer, Integer>();
		
		int[] exNumbers = {21,27,29,38,40,44};	// 확인회차
		int[] winNumbers = {2,5,14,28,31,32};	// 이전회차
		for (int i = 0; i < winNumbers.length; i++) {
			int number = winNumbers[i];
			
			for (int row = 0; row < arrNumbers.length; row++) {
				for (int col = 0; col < arrNumbers[row].length ; col++) {
					if (arrNumbers[row][col] == number) {
						// 선택한 숫자에서 4방향으로 번호를 map에 저장
						
						int idx = 0;
						
						// 1. 좌상
						do {
//							System.out.println("좌상 = " + arrNumbers[row - idx][col - idx]);
							lineMap.put(arrNumbers[row - idx][col - idx], 1);
							
							if (row - (idx + 1) < 0 || col - (idx + 1) < 0) {
								break;
							} else {
								idx++;
							}
							
						} while (true);
						
						idx = 0;
						
						// 2. 우상
						do {
//							System.out.println("우상 = " + arrNumbers[row - idx][col + idx]);
							lineMap.put(arrNumbers[row - idx][col + idx], 1);
							
							if (row - (idx + 1) < 0 || col + (idx + 1) > 6) {
								break;
							} else {
								idx++;
							}
							
						} while (true);
						
						idx = 0;
						
						// 3. 좌하
						do {
//							System.out.println("좌하 = " + arrNumbers[row + idx][col - idx]);
							lineMap.put(arrNumbers[row + idx][col - idx], 1);
							
							if (row + (idx + 1) > 6 || col - (idx + 1) < 0) {
								break;
							} else {
								idx++;
							}
							
						} while (true);
						
						idx = 0;
						
						// 4. 우하
						do {
//							System.out.println("우하 = " + arrNumbers[row + idx][col + idx]);
							lineMap.put(arrNumbers[row + idx][col + idx], 1);
							
							if (row + (idx + 1) > 6 || col + (idx + 1) > 6) {
								break;
							} else {
								idx++;
							}
							
						} while (true);
					}
				}
			}	
		}
		
		// 제외수
		List<Integer> excludeList = new ArrayList<Integer>();
		for (int i = 1; i <= 45; i++) {
			if (!lineMap.containsKey(i)) {
				excludeList.add(i);
				excludeMap.put(i,1);
			}
		}
		
		// 제외수 확인
//		for (int i = 0; i < excludeList.size(); i++) {
//			System.out.println(excludeList.get(i));
//		}
		
		// 검증
		int appearCnt = 0;
		for (int i = 0; i < exNumbers.length; i++) {
			if (excludeMap.containsKey(exNumbers[i])) {
				appearCnt++;
				System.out.println(exNumbers[i] + ",");
			}
		}
		
		if (appearCnt > 0) {
			System.out.println("제외수 중 " + appearCnt + "개 출현");
		}
		
	}

}

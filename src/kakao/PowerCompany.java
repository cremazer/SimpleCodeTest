package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PowerCompany {
	public static void main(String[] args) {
		List<Integer> model = new ArrayList<Integer>();
		model.add(3);
		model.add(4);
		model.add(6);
		model.add(11);
		model.add(9);
		model.add(9);
		model.add(9);
		model.add(9);
		model.add(8);
		model.add(8);
		model.add(8);
		model.add(8);
		model.add(8);
		model.add(8);
		
		int leastModelCnt = reduceCapacity(model);
		System.out.println("leastModelCnt="+leastModelCnt);
	}
	
	public static int reduceCapacity(List<Integer> model) {
		int leastModelCount = 0;
		int least = (int)Math.ceil(model.size() / 2.0);
		int minCount = 0;
		
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		List<Integer> numberList = new ArrayList<Integer>();
		
		int[] arrModel = new int[model.size()];
		for (int i = 0; i < model.size(); i++) {
			if (!numberMap.containsKey(model.get(i))) {
				numberMap.put(model.get(i), model.get(i));
				numberList.add(model.get(i));
			}
			arrModel[i] = model.get(i);
		}
		
		Arrays.sort(arrModel);
		
		Integer[] arrNumberCount = new Integer[numberList.size()];
		for (int i = 0; i < numberList.size(); i++) {
			int count = 0;
			
			for (int j = 0; j < arrModel.length; j++) {
				if (numberList.get(i) == arrModel[j]) {
					count++;
				}
			}
			
			arrNumberCount[i] = count;
		}
		
		Arrays.sort(arrNumberCount, Collections.reverseOrder());
		
		for (int i = 0; i < arrNumberCount.length; i++) {
			leastModelCount++;
			minCount += arrNumberCount[i];
			if (minCount >= least) {
				break;
			}
		}
		
		return leastModelCount;
	}
}

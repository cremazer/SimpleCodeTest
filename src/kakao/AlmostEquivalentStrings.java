package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlmostEquivalentStrings {
	public static void main(String[] args) {
		
	}
	
	public static List<String> areAlmostEquivalent(List<String> s, List<String> t) {
		List<String> result = new ArrayList<String>();
		
		int maxInputLength = (int) Math.pow(10, 5);
		
		Map<String, Integer> checkChar = new HashMap<String, Integer>();
		
		if (s.size() == t.size() 
				&& (s.size() <= maxInputLength && s.size() >= 1
					|| t.size() <= maxInputLength && t.size() >= 1)
				) {
			
			int maxDifference = 0;
			
			for (String str : s) {
				if (!checkChar.containsKey(str)) {
					// check s
					int sCount = 0;
					int tCount = 0;
					
					for (int i = 0; i < s.size(); i++) {
						if (str.equals(s.get(i))) {
							sCount++;
						}
						if (str.equals(t.get(i))) {
							tCount++;
						}
					}
					
										
					int diffCount = Math.abs(sCount-tCount);
					if (diffCount > maxDifference) {
						maxDifference = diffCount;
					}
					
					checkChar.put(str, diffCount);
				}
			}
			
			for (String str : t) {
				if (!checkChar.containsKey(str)) {
					int sCount = 0;
					int tCount = 0;
					
					for (int i = 0; i < t.size(); i++) {
						if (str.equals(s.get(i))) {
							sCount++;
						}
						if (str.equals(t.get(i))) {
							tCount++;
						}
					}
					
										
					int diffCount = Math.abs(sCount-tCount);
					if (diffCount > maxDifference) {
						maxDifference = diffCount;
					}
					
					checkChar.put(str, diffCount);
				}
			}
			
			if (maxDifference <= 5 && maxDifference >= 1) {
				result.add("YES");
			} else {
				result.add("NO");
			}
			
		} else {
			result.add("NO");
		}
		
		return result;
	}
}

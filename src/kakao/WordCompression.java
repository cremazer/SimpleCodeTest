package kakao;

public class WordCompression {
	public static void main(String[] args) {
		String word = "baac";
		
		word = compressWord(word, 2);
		
		System.out.println("word="+word);
	}
	
	public static String compressWord(String word, int K) {
		System.out.println("compressWord word="+word+", K="+K);
		int maxLength = (int) Math.pow(10,5);
		
		if ((1 <= word.length() && word.length() <= maxLength)
				&& (1 <= K && K <= word.length())) {
			
			for (int i = 0; i < word.length(); i++) {
				int startIdx = 0;
				int endIdx = 0;
				int cnt = 0;
				String checkChar = word.substring(i, i+1);
				
				for (int j = 0; j < word.length(); j++) {
					boolean equal = false;
					if (checkChar.equals(word.substring(j, j+1))) {
						System.out.println("j="+j);
						cnt++;
						equal = true;
					}
					
					if (equal) {
						if (startIdx == 0) {
							startIdx = j;
						} else {
							endIdx = j;
						}
					}
				}
				
				if (startIdx != 0 && endIdx != 0 && cnt == 2) {
					String removeWord = word.substring(0, startIdx) + word.substring(startIdx + 2, word.length());
					System.out.println("removeWord="+removeWord);
					word = compressWord(removeWord, K);
				}
			}
			
		}
		
		return word;
	}
}

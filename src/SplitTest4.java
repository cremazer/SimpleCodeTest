public class SplitTest4 {
	public static void main(String[] args) {
		String seqs = "1,2,3";
		String[] seqArr = seqs.split(",");
		
		for (int i = 0; i < seqArr.length; i++) {
			System.out.println(seqArr[i]);
		}
		
	}
}

public class SplitTest5 {
	public static void main(String[] args) {
		String seqs = "('1','2','3')";
		// seqs.replaceAll("(", "").replaceAll(")", "");
		seqs = seqs.substring(1, seqs.length()-1);
		String[] seqArr = seqs.split(",");
		
		for (int i = 0; i < seqArr.length; i++) {
			
			System.out.println(seqArr[i]);
		}
		
	}
}

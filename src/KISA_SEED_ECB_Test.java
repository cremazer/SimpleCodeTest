
public class KISA_SEED_ECB_Test {
	public static void main(String[] args) {
		
		String KEY = "smlotto";
//		String USER_KEY = "rbtj88!@#$";
		String USER_KEY = "smlotto";
		
		byte[] in = KEY.getBytes();
		
		for (int i = 0; i < in.length; i++) {
			System.out.println(in[i]);
		}
		
		int inLen = in.length;
		int[] pdwRoundKey = KISA_SEED_ECB.chartoint32_for_SEED_ECB(in, inLen);
//		byte[] pbUserKey = USER_KEY.getBytes();
//		KISA_SEED_ECB.SeedRoundKey(pdwRoundKey, pbUserKey);
		
		
//		byte[] pbszUserKey = "smlotto".getBytes();
//		byte[] pbData = "01066792430".getBytes();
//		int offset = 0;
//		int length = "01066792430".length();
//		byte[] encData = KISA_SEED_ECB.SEED_ECB_Encrypt(pbszUserKey, pbData, offset , 7 );
	
//		KISA_SEED_ECB.SEED_ECB_init(pInfo, enc, pbszUserKey);
		
		
//		System.out.println(encData.toString());
	}
}

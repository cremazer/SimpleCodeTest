
public class StringLengthTest2 {
	public static void main(String[] args) {
		String number = "";
		for (int i = 1; i <= 45; i++) {
			if (!"".equals(number)) {
				number += ",";
			}
			number += i;
		}
		
		System.out.println(number);
		System.out.println(number.length());
		
		String thumbnailImage = "http://k.kakaocdn.net/dn/i1AkC/btqxfEqMWZQ/HBY4X6xFFCvYksLfKuwH41/profile_110x110c.jpg";
		System.out.println(thumbnailImage.length());
	}
}

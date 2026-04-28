package com.practice.leetcode.blind75.string;

public class LongstRepetngCharReplace {

	public static void main(String[] args) {

			String s = "AABAAB";
			String s2 = "ABBABA";
			
			String s3 = "ABBA";
			int k = 2;
			System.out.println(longstRepetngCharReplace(s3, k));

}

	private static int longstRepetngCharReplace(String str, int k) {
		
		char[] strArray = str.toCharArray();
		int[] charFre = new int[26];
		
		int max_Freq_Count = 0;
		int maxLength = 0;
		int wStart = 0;
		int wEnd = 0;
		
		for (wEnd = 0; wEnd < strArray.length; wEnd++) {
			
			charFre[strArray[wEnd] - 'A']++;
			
			int char_Count = charFre[strArray[wEnd] - 'A'];
			max_Freq_Count = Math.max(max_Freq_Count, char_Count);
			
			if(wEnd-wStart-max_Freq_Count+1 > k) {
				charFre[strArray[wStart] - 'A']--;
				wStart++;
			}
			maxLength = Math.max(maxLength, (wEnd-wStart)+1);
		}
		return maxLength;
	}
}

package HW_2;

public class Task_0 {

	public static void main(String[] args) {
		String jewels = "aB";
		String stones = "aaaAbbbB";
		String result = findJewelsInStones(jewels, stones);
		System.out.println(result); // a3B1
	}

	public static String findJewelsInStones(String jewels, String stones) {
		int count = 0;
		for (int i = 0; i < stones.length(); i++) {
			if (jewels.indexOf(stones.charAt(i)) != -1) {
				count++;
			}
		}
		String result = "";
		for (int i = 0; i < jewels.length(); i++) {
			int jewelCount = 0;
			for (int j = 0; j < stones.length(); j++) {
				if (jewels.charAt(i) == stones.charAt(j)) {
					jewelCount++;
				}
			}
			result += jewels.charAt(i) + Integer.toString(jewelCount);
		}
		return result;
	}
}

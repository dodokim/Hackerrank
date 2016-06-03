// checks if a given string can be permuted into a palindrome
public class PalindromeCheck
{
	public static Boolean palindrome(String s)
	{
		int n = s.length();
		int[] character = new int[256];
		for (int i = 0; i < n; i++) {
			character[s.charAt(i)]++;
		}
		int bad = 0;
		for (int j = 0; j < 256; j++)
		{
			character[j] = character[j] % 2;
			if (character[j] == 1) bad++;
			if (bad > 1) return false;
			// else return true;
		}
		return true;
	}
	public static void main(String[] args)
	{
		String s = args[0];
		System.out.println(palindrome(s));
	}
}
public class PalindromeChecker {

    public static void main(String[] args) {
        String str1 = "A man, a plan, a canal, Panama!";
        String str2 = "race a car";
    	

        System.out.println("Is \"" + str1 + "\" a palindrome? " + isPalindrome(str1));
        System.out.println("Is \"" + str2 + "\" a palindrome? " + isPalindrome(str2));
    }

    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}


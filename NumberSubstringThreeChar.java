public class NumberSubstringThreeChar {
    public int numberOfSubstrings(String s) {
        int left = 0, count = 0;
        int[] freq = new int[3]; // To store the frequency of 'a', 'b', 'c'

        for (int right = 0; right < s.length(); right++) {
            // Increment the frequency of the current character
            freq[s.charAt(right) - 'a']++;

            // Check if we have at least one 'a', 'b', and 'c' in the current window
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                // Once all three characters are present, all substrings starting from
                // 'left' to the end are valid
                count += s.length() - right;

                // Shrink the window from the left
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        NumberSubstringThreeChar solution = new NumberSubstringThreeChar();
        String s = "abcabc";
        System.out.println("Number of substrings containing all three characters: " + solution.numberOfSubstrings(s));  // Output: 10
    }
}

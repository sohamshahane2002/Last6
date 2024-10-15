 public class BinarySubarraySum {
    public int numSubarraysWithSum(int[] nums, int S) {
        // Two pointers and sliding window approach
        int left = 0, currentSum = 0, result = 0;

        // Iterate with the right pointer expanding the window
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right]; // Add current element to the current sum
            
            // Shrink the window if currentSum is greater than S
            while (currentSum > S && left <= right) {
                currentSum -= nums[left]; // Remove element from the left
                left++; // Move left pointer to the right
            }
            // If current sum matches S, increment the result
            if (currentSum == S) {
                result++;
                // Check for additional valid subarrays that end at 'right'
                int tempLeft = left;
                while (tempLeft < right && currentSum == S) {
                    result++;
                    currentSum -= nums[tempLeft];
                    tempLeft++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        BinarySubarraySum solution = new BinarySubarraySum();
        int[] nums = {1, 0, 1, 0, 1}; 
        int S = 2; 
        
        int result = solution.numSubarraysWithSum(nums, S);
        System.out.println("Number of subarrays with sum " + S + ": " + result);
    }
}
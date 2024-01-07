package leetcode.daily.dsa.Done;

/*
 * 300. Longest Increasing Subsequence
Solved
Medium
Topics
Companies
Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */
public class Day05 {
	
	    public static int lengthOfLIS(int[] nums)
	    {
	        int[] tails = new int[nums.length];
	        int size = 0;
	        for (int x : nums)
	        {
	            int i = 0, j = size;
	            while (i != j) 
	            {
	                int m = (i + j) / 2;
	                if (tails[m] < x)
	                    i = m + 1;
	                else
	                    j = m;
	            }
	            tails[i] = x;
	            if (i == size) ++size;
	        }
	        return size;
	    }

	public static void main(String[] args)
	{
		int[] arr= {7,7,7,7,7,7,7};
		int result=lengthOfLIS(arr);
		System.out.println(result);
	}

}

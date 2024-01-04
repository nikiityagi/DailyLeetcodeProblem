package leetcode.daily.dsa.Done;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/////////////////////////////////////MEDIUM////////////////////////////////////
/*
2610. Convert an Array Into a 2D Array With Conditions
You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

The 2D array should contain only the elements of the array nums.
Each row in the 2D array contains distinct integers.
The number of rows in the 2D array should be minimal.
Return the resulting array. If there are multiple answers, return any of them.

Note that the 2D array can have a different number of elements on each row.

Example 1:

Input: nums = [1,3,4,1,2,3,1]
Output: [[1,3,4,2],[1,3],[1]]
Explanation: We can create a 2D array that contains the following rows:
- 1,3,4,2
- 1,3
- 1
All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
It can be shown that we cannot have less than 3 rows in a valid array.
Example 2:

Input: nums = [1,2,3,4]
Output: [[4,3,2,1]]
Explanation: All elements of the array are distinct, so we can keep all
of them in the first row of the 2D array.*/

public class Day02 {
	
	public static List<List<Integer>> findMatrix(int[] v) {
        Map<Integer, Integer> um = new HashMap<>();
        for (int i : v) {
            um.put(i, um.getOrDefault(i, 0) + 1);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        while (!um.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> toErase = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : um.entrySet()) {
                int f = entry.getKey();
                int s = entry.getValue();
                temp.add(f);
                s--;
                if (s == 0) {
                    toErase.add(f);
                }
                um.put(f, s);
            }
            ans.add(temp);
            for (int i : toErase) {
                um.remove(i);
            }
        }
        return ans;
    }

	public static void main(String[] args) {
		
		int[] arr= {1,3,4,1,2,3,1};
		List<List<Integer>> ll=findMatrix(arr);
		System.out.println(ll);
	}

}

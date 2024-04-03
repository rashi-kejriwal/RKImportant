package programs;

import java.util.HashMap;
import java.util.Map;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target. You may assume that each input would have exactly one solution, and you may not use the same element twice. You can return the answer in any order. Example 1: Input: nums = [2,7,11,15], target = 9 Output: [0,1]
public class twoSum {

    final int[] solution = new int[2];
    Map<Integer, Integer> twoSumsMap = new HashMap<Integer, Integer>();

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int checkNum = target - nums[i];
            if (twoSumsMap.containsKey(checkNum)) {
                solution[0] = twoSumsMap.get(checkNum);
                solution[1] = i;
                return solution;

            } else {
                twoSumsMap.put(nums[i], i);
            }
        }
        return solution;
    }

}

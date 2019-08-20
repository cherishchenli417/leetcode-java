package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	
    public List<List<Integer>> solution(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j-1])
                    continue;
                int left = j + 1, right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i] ,nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1])
                            left++;
                        while (left < right && nums[right] == nums[right-1])
                            right--;
                        left++;
                        right--;
                    } else if (sum < target)
                        left++;
                    else
                        right--;
                }
            }
        }
        
        return result;
    }
    
}

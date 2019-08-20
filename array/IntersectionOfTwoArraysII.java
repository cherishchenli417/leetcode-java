package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
	
	public int[] solution(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums1)
			map.put(num, map.getOrDefault(num, 0) + 1);

		List<Integer> list = new ArrayList<Integer>();
		for (int num : nums2) {
			if (map.containsKey(num) && map.get(num) > 0) {
				list.add(num);
				map.put(num, map.get(num) - 1);
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			result[i] = list.get(i);

		return result;
	}
	
}

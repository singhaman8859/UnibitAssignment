package Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1 {
	
	// brute force approach for finding the combinations of elements whose sum = target value 
	// time complexity of this function will be O(n^2);

	public static List<List<Integer>> firstCombination(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();

		for (int a = 0; a < arr.length - 1; a++) {
			for (int b = a + 1; b < arr.length; b++) {
				// System.out.println(arr[a] + "---" + arr[b] + "=======" + (arr[a] + arr[b]));
				if ((arr[a] + arr[b]) == target) {

					res.add(Arrays.asList(arr[a], arr[b]));
				}
			}
		}

		return res;
	}
	
	// this method is done with the help of hashmap for finding the combination of 2 values whose sum target 
	// but the time complexity of this function will be O(n+K)
	public static int[][] firstCombinations2(int[] nums, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		List<int[]> combinations = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				List<Integer> indices = map.get(complement);
				for (int index : indices) {
					combinations.add(new int[] { nums[index], nums[i] });
				}
			}
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], new ArrayList<>());
			}
			map.get(nums[i]).add(i);
		}

		int[][] result = new int[combinations.size()][2];
		for (int i = 0; i < combinations.size(); i++) {
			result[i] = combinations.get(i);
		}

		return result;
	}
	
	// this function is for find the combination of doubled target 
	// as this mention that first we have to find the combination of two element and then we have to merge
	// those elements only and also the array provided in this function is already sorted in ascending order
	// so if the 2 elements sum = target and i have to find the combination of target*2 so 4 elements sum definetly = target*2
	//same thing i have did i am taking 2 elements from starting and 2 from last because arr is sorted
	// this function will return the uniq elements combination of doubled target 

	public static List<List<Integer>> secondCombination(int[] arr, int target) {
		List<List<Integer>> res = new ArrayList<>();

		int left = 0;
		int right = arr.length - 1;
		// System.out.println("summm"+ (arr.length/(target/2)));
		for (int a = 0; a < (arr.length) / (target / 2); a++) {
			List<Integer> l = new ArrayList<>();
			l.add(arr[left++]);
			l.add(arr[right--]);
			l.add(arr[left++]);
			l.add(arr[right--]);
			res.add(l);

		}

		return res;

	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2, 2, -4, 6, -2, 8 };
		int target = 4;
		List<List<Integer>> res = Question1.firstCombination(nums, target);
		System.out.println("combination for first target" + res);

		int[] mergedArr = new int[res.size() * 2];
		int count = 0;
		for (List<Integer> ele : res) {
			mergedArr[count++] = ele.get(0);
			mergedArr[count++] = ele.get(1);
		}
		Arrays.sort(mergedArr);
		System.out.println("merged array " + Arrays.toString(mergedArr));

		System.out.println("combination for doubled target" + Question1.secondCombination(mergedArr, target * 2));

	}

}

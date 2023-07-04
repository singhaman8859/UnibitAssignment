package Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question1 {

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

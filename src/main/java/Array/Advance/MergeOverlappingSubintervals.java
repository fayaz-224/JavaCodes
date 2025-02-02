package Array.Advance;

import java.util.*;

public class MergeOverlappingSubintervals {

    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length;
        //Sort the arr based on the start value
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));  //Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // if the current interval does not lie in the last interval:
            if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
                ans.add(Arrays.asList(arr[i][0], arr[i][1])); // Add a new interval to ans
            }
            else {  // if the current interval lies in the last interval:
                ans.get(ans.size() - 1)
                   .set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));  //merge them
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        List<List<Integer>> ans = mergeOverlappingIntervals(arr);
        System.out.print("The merged intervals are: " + ans);

//        for (List<Integer> it : ans) {
//            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
//        }
//        System.out.println();
    }
}


/*
Example 1:
Input:
 intervals=[[1,3],[2,6],[8,10],[15,18]]
Output:
 [[1,6],[8,10],[15,18]]

Explanation:
 Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.

Example 2:
Input:
 [[1,4],[4,5]]
Output:
 [[1,5]]

Explanation:
 Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].
 */
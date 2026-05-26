import java.util.*;
import java.collections.*;

class Solution {
    public List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        // code here
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        // List<List<Integer>> ans1 = new ArrayList<>();
        int l = lower;
        
        for (int i = 0; i < n; i++) {
            // System.out.println(l);
            if(arr[i] - l > 1) {
                List<Integer> temp = new ArrayList<>();
                if (i > 0) {
                    temp.add(l+1);
                } else {
                    temp.add(l);
                }
                if (arr[i] - l > 2) {
                    temp.add(arr[i] -1);
                } else {
                    temp.add(l+1);
                }
                ans.add(temp);
            }
            l = arr[i];
        }
        if(upper - arr[n-1] > 0) {
            List<Integer> temp = new ArrayList<>();
            if (upper - arr[n-1] > 1) {
                temp.add(arr[n-1] + 1);
            } else {
                temp.add(l+1);
            }
            temp.add(upper);
            ans.add(temp);
        }
        // System.out.println(ans);
        return ans;
        
    }
}
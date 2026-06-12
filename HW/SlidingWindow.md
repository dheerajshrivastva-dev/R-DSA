# Sliding window

## 2nd class

### 2461. Maximum Sum of Distinct Subarrays With Length K [link]{https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/}

``` java

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        // So subarry is length of k so when we have a subarray where all element is unique subarray then its simple
        // ex [1,2,3,4,5,6.7] k = 3
        // [1,2,3] [2,3,4], [4,5,6], [5,6,7]
        // but if its [1,2,3,4,4,4,4]
        // [1,2,3], [2,3,4] freq = {2-1, 3-1, 4-1},  [3,4,4] X -> it was freq {3-1, 4-2} , [4,4,4] X freq {4-3}

        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        long max = 0;
        long currentSum = 0;

        for (int i = 0; i< nums.length; i++) {
            // now add nums[i] freq and increase currentSum
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            currentSum += nums[i];
            // if length of map is k we need to record max sum
            if(map.size()== k) {
                max = Math.max(max, currentSum);
            }
            if(i + 1 >= k ) {
                // now when k element has been added now we apply kedance sub from start and add from last (default) --> window created
                currentSum -= nums[start];
                int startFreq = map.get(nums[start]);
                if(startFreq > 1) {
                    map.put(nums[start], startFreq-1);
                } else {
                    map.remove(nums[start]);
                }
                start ++;
                
            }
        }
        return max;
    }
}

```
### 643. Maximum Average Subarray I [link](https://leetcode.com/problems/maximum-average-subarray-i/description/)

``` java

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = Integer.MIN_VALUE;
        long currentSum = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length) {
            currentSum += nums[j];
            if(j+1 >= k) {
                maxSum = Math.max(maxSum, currentSum);
                currentSum -= nums[i];
                i++;
            }
            j++;
        }
        double ans = maxSum/k;
        return ans;
    }
}

```

### 209. Minimum Size Subarray Sum [link](https://leetcode.com/problems/minimum-size-subarray-sum/description/)

``` java

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;

        int currentSum = 0;

        while(i < nums.length) {
            if (currentSum >= target) {
                int length = j == 0 ? j-i+1 : j-i;
                minLength = Math.min(minLength, length);
                currentSum -= nums[i];
                i++;
            } else {
                if(j < nums.length ){
                    currentSum += nums[j];
                    j++;
                }else {
                    i++;
                }
                // System.out.println(" j = "+ j);  
            }
            // System.out.println(" i = "+ i);  
        }
        return minLength == Integer.MAX_VALUE? 0 : minLength;


    }
}


```

# Solutions

## 1. Two Sum - [Link](https://leetcode.com/problems/two-sum/description/)

``` java

// solution 1

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] ans = new int[2];

        Map<Integer, Integer> hash = new HashMap<>();


        for(int i = 0; i < nums.length; i++) {
            int second = target - nums[i];
            if(hash.containsKey(second)) {
                int val = hash.get(second);
                return new int[] {val, i};
            } else {
                hash.put(nums[i], i);
            }
        }
        return ans;
    }
}


```

##  167. Two Sum II - Input Array Is Sorted - [Link](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/)

``` java

// Solution 1 - TLE 

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = 1;
        int n = numbers.length;

        while (i < n) {
            if (numbers[i] + numbers[j] == target) {
                return new int[] {i+1, j+1};
            } else if (numbers[i] + numbers[j] < target) {
                j++;
            } else {
                i++;
                j = i+1;
            }
        }
        return new int[2];
    }
}

// Solution 2 - very big time complexity but pass

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = 1;
        int n = numbers.length;

        while (i < n) {
            if (j == n) {
                i++;
                j = i+1;
            } else if (numbers[i] + numbers[j] == target) {
                return new int[] {i+1, j+1};
            } else if (numbers[i] + numbers[j] < target) {
                j++;
            } else {
                i++;
                j = i+1;
            }
        }
        return new int[2];
    }
}

// Solution 3 -> Fix and binary search

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        for (int i = 0; i<n; i++) {
            // now finary serach the diff
            int diff = target - numbers[i];
            int left = i+1;
            int right = n-1;
            while(left <= right) {
                int mid = (left + right)/2;
                if(numbers[mid] == diff) {
                    return new int[]{i+1, mid+1};
                } else if (numbers[mid] > diff){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return new int[2];
    }
}

// Solution 4 -> 2 pointer (after class)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // two pointer approach
        int i = 0;
        int j = numbers.length -1;
        while(i < j) {
            if(numbers[i] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] == target) {
                return new int[] {i+1, j+1};
            } else {
                i++;
            }
        }
        return new int[2];
    }
}


```

## 88. Merge Sorted Array - [Link](https://leetcode.com/problems/merge-sorted-array/description/)

``` java

// solution before watching solution - wrong or TLE

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) {
            return;
        } else if (m==0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = m-1;
        int j = m + n -1;
        int k = n-1;
        while(k >= 0) {
            if (nums1[i] <= nums2[k]) {
                nums1[j] = nums2[k];
                if(j>0)j--;
                k--;
            } else {
                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
                if(i>0) i--;
                if(j>0) j--;
            }
        }
    }
}

// Solution after solution
// Understood: second array will have some left then we have to copy remaining, and if not first array is sorted and all element of second is on correct place.

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) {
            return;
        } else if (m==0) {
            for(int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = m-1;
        int j = m + n -1;
        int k = n-1;
        while(i>=0 && k>=0) {
            if (nums1[i] <= nums2[k]) {
                nums1[j] = nums2[k];
                j--;
                k--;
            } else {
                int temp = nums1[i];
                nums1[i] = nums1[j];
                nums1[j] = temp;
                i--;
                j--;
            }
        }
        while(k>=0){
            nums1[j] = nums2[k];
            j--;
            k--;
        }

    }
}

```

## 118. Pascal's Triangle - [Link](https://leetcode.com/problems/pascals-triangle/)

``` java

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> sol1 = new ArrayList<Integer>();
        sol1.add(1);
        ans.add(sol1);

        for(int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            List<Integer> prev = ans.get(i-1);
            for(int j = 0; j <= i; j++) {
                if(j==0 || j==i) {
                    temp.add(1);
                } else {
                    temp.add(prev.get(j) + prev.get(j-1));
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}

```

## 119. Pascal's Triangle II - [Link](https://leetcode.com/problems/pascals-triangle-ii/)

``` java

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prev = new ArrayList<>();
        prev.add(1);

        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0 || j==i) {
                    temp.add(1);
                } else {
                    temp.add(prev.get(j) + prev.get(j-1));
                }
            }
            prev = temp;
        }
        return prev;
    }
}

```

## 169. Majority Element - [Link](https://leetcode.com/problems/majority-element/description/)

``` java

class Solution {
    
    public int majorityElement(int[] nums) {
        // count freq
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int pv = map.get(nums[i]);
                map.put(nums[i], pv+1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(max < value) {
                max = value;
                ans = entry.getKey();
            }
        }
        return ans;
    }
}

```

## 229. Majority Element II - [Link](https://leetcode.com/problems/majority-element-ii/description/)

``` java

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<Integer>();

        Set<Integer> set = new HashSet<>();
        // sort the array
        Arrays.sort(nums);
        // fix window of n/3
        int i = 0;
        while(i <= 2*n/3 && i + n/3 < n) {
            if(nums[i] == nums[i + n/3]) {
                if (!set.contains(nums[i])) {
                    ans.add(nums[i]);
                    set.add(nums[i]);
                }
                i = i+n/3 + 1;
            } else {
                i++;
            }
        }
        return ans;
        
    }
}

```

## Missing ranges of numbers - [Link geekforgeeks](https://www.geeksforgeeks.org/problems/missing-ranges-of-numbers1019/1)

``` java

class Solution {
     static List<List<Integer>> missingRanges(int[] arr, int lower, int upper) {
        // code here
        int n = arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        // List<List<Integer>> ans1 = new ArrayList<>();
        int l = lower;
        
        for (int i = 0; i < n; i++) {
            // System.out.println(l);
            List<Integer> temp = new ArrayList<>();
            if(arr[i] - l > 1) {
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
            }  else {
                if (i==0 && arr[i] - l == 1) {
                    temp.add(l);
                    temp.add(l);
                    ans.add(temp);
                }
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


```

## 121. Best Time to Buy and Sell Stock [Link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/)

``` Java

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (ans < diff) {
                    ans = diff;
                }
            }
        }
        return ans;
    }
}

// workign solution

// Note - Go to future then take care of past

class Solution {
    public int maxProfit(int[] prices) {
        int profitMax = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            profitMax = Math.max(profitMax, prices[i] - minBuy);
            minBuy = Math.min(minBuy, prices[i]);
        }
        return profitMax;
    }
}

```

## 122. Best Time to Buy and Sell Stock II [link](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

``` java

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}

```

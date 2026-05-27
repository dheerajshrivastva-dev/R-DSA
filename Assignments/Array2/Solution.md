# Solutions Array 2

## 283. Move Zeroes [Link](https://leetcode.com/problems/move-zeroes/description/)

``` Java

class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;

        while (j < nums.length && i < nums.length) {
            if(nums[i] !=0) {
                i++;
                j++;
            } else if (nums[j] == 0) {
                j++;
            } else {
                nums[i] = nums[j];
                nums[j] = 0;
                j++;
                i++;
            }
        }
    }
}

```

## 217. Contains Duplicate [Link](https://leetcode.com/problems/contains-duplicate/description/)

``` Java

// sol 1

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                return true;
            }
        }
        return false;
    }
}

// sol 2

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }
}

// sol 3

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}

// I was not able to solve in 1 ms :(

```
## 219. Contains Duplicate II [Link](https://leetcode.com/problems/contains-duplicate-ii/description/)

``` Java

// Brute force

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            for ( int j = i+1; j < (i+k > n -1 ? n : i+k+1); j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}

```

## 228. Summary Ranges [link](https://leetcode.com/problems/summary-ranges/description/)

``` java

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if(nums.length < 1) return ans;

        int i = 0;
        int j = 1;

        while(j < nums.length) {
            // System.out.print("before " + i + " : " + j + " ");
            if(nums[j] - nums[j-1] == 0 || nums[j] - nums[j-1] == 1) {
                // System.out.println((nums[j] - nums[j-1]) + " gg " + j + " hh " + nums[j]+ " "+ nums[j-1]);

                j++;
            } else {
                if(nums[i] != nums[j-1]){
                    ans.add(nums[i] + "->" + nums[j-1]);
                }
                else {
                    ans.add(nums[i]+"");
                }
                i = j;
                j++;
            }
            // System.out.println(" => After"+ i + " : " + j);

        }
        if(i == nums.length-1) {
            ans.add(nums[i]+"");
        } else {
            ans.add(nums[i] + "->" + nums[j-1]);
        }
        return ans;
    }
}

```

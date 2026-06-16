# Solution sliding window 1

## 219. Contains Duplicate II [link](https://leetcode.com/problems/contains-duplicate-ii/description/)

``` java

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int i = 0;
        int j = 0;
        // apply window then find duplicate
        Set<Integer> set = new HashSet<>();
        while(j < nums.length) {
            if(set.contains(nums[j])) return true;
            set.add(nums[j]);

            if(j >= k) {
                set.remove(nums[i]);
                i++;
            }
            j++;

        // now increase i till i==j
        // also check same

        }
        return false;
    }
}

```

## Problem 2 is same as Probblem 1 so solvong 217. Contains Duplicate [link](https://leetcode.com/problems/contains-duplicate/description/)



``` java

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

```

## Problem 3 220. Contains Duplicate III

``` java

// from sorted set not learn yet

// this going TLE

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        List<Integer> window = new ArrayList<>();
        int k = indexDiff == nums.length ? indexDiff - 1: indexDiff;
        int i = 0;
        for(int j = 0; j < nums.length; j++) {
            window.add(nums[j]);
            if(j >= k ) {
                // we need to return true if current array has the two sum type
                boolean ans = getAns(window, valueDiff);
                // System.out.println("j= "+j + ", i= " + i);
                if(ans) return ans;
                window.remove(0);
                i++;
            }
        }
        return false;
    }
    static boolean getAns(List<Integer> list, int diff) {
        // sort
        List<Integer> sorted = new ArrayList<>(list);
        Collections.sort(sorted);
        
        Set<Integer> set = new HashSet<>();

        int n = list.size();
        int i = 0; 
        int j = 1;
        while(j < n) {

            if(i!=j && sorted.get(j)-sorted.get(i) > diff) {
                i++;
            } else if(i!=j && sorted.get(j)-sorted.get(i) <= diff){
                return true;
            }
            j++;
        }
        return false;
    }
}

```

## 239. Sliding Window Maximum [link](https://leetcode.com/problems/sliding-window-maximum/description/)

``` java

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();

        int i = 0;
        Deque<Integer> dq = new LinkedList<>();

        for(int j = 0; j < nums.length; j++) {
            while(!dq.isEmpty() && dq.peekFirst() < nums[j]) dq.pollFirst();
            dq.addFirst(nums[j]);

            if(j+1 >= k) {
                ans.add(dq.peekLast());
                if(dq.peekLast() == nums[i]) {
                    dq.pollLast();
                }
                i++;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

```

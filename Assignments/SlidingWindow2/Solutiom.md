# Sliding Window 2 Assignment

## 395. Longest Substring with At Least K Repeating Characters [link](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/description/)

``` java

// doubt class 15th june 2026 -> says its recursion problem

```

## 3. Longest Substring Without Repeating Characters [link](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

``` java

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // variable window
        Map<Character, Integer> map = new HashMap<>();

        int i = 0;
        int ans = 0;
        int count = 0;
        for(int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
            if(map.get(s.charAt(j)) > 1) {
                ans = Math.max(ans, count);
                while(map.get(s.charAt(j)) > 1) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                    i++;
                    count--;
                }

            }
            count++;
        }
        ans = Math.max(ans, count);
        return ans;
    }
}

```

## 438. Find All Anagrams in a String [link](https://leetcode.com/problems/find-all-anagrams-in-a-string/description/)

``` java

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();

        int[] freq = new int[26];

        for(int i = 0; i < p.length(); i++) {
            freq[p.charAt(i) - 'a'] = freq[p.charAt(i) - 'a']  +1;
        }
        // System.out.print(Arrays.toString(freq));

        int i = 0;
        int j = 0;

        int[] freq2 = new int[26];

        while(j < s.length()) {
            freq2[s.charAt(j) - 'a'] = freq2[s.charAt(j) - 'a']  +1;
            // System.out.print(Arrays.toString(freq2));
            if (j+1 >= p.length()) {
                if(Arrays.equals(freq, freq2)) {
                    ans.add(i);
                }
                freq2[s.charAt(i) - 'a'] = freq2[s.charAt(i) - 'a']  -1;
                i++;
            }
            j++;

        }
        return ans;
    }
}

```

## 643. Maximum Average Subarray I [link](https://leetcode.com/problems/maximum-average-subarray-i/description/)

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

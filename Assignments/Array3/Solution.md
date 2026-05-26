# Solutions

## 1470. Shuffle the Array - [Link](https://leetcode.com/problems/shuffle-the-array/description/)

``` Java

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = 0;

        while(i < nums.length) {
          ans[i] = nums[j];
          ans[i+1] = nums[j+n];
          i+=2;
          j++;
        }
        return ans;
    }
}

```

## 66. Plus One [Link](https://leetcode.com/problems/plus-one/description/)

``` java

class Solution {
    public int[] plusOne(int[] digits) {
        int toAdd = 1;
        for(int i = digits.length-1; i>=0; i--) {
            if (toAdd == 0) return digits;
            int r = (digits[i] + toAdd)/10;
            int val  = (digits[i] + toAdd)%10;
            digits[i] = val;
            toAdd = r;
        }
        if (toAdd > 0) {
            int[] ans = new int[digits.length+1];
            ans[0] = 1;
            return ans;
        }
        return digits;
    }
}

```

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
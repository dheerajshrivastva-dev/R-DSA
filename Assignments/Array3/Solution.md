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

## 1480. Running Sum of 1d Array [Link](https://leetcode.com/problems/running-sum-of-1d-array/description/)

``` java

class Solution {
    public int[] runningSum(int[] nums) {
        int ps = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] + ps;
            ps = nums[i];
        }
        return nums;
    }
}

```

## 414. Third Maximum Number [Link](https://leetcode.com/problems/third-maximum-number/description/)

``` java

class Solution {
    public int thirdMax(int[] nums) {
        int[] max = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int c = 0;
        Boolean b = false;
        for (int i = 0; i < 3; i++) {
            b = false;
            for (int j = 0; j < nums.length; j++) {
                if(i == 0) {    
                    if(nums[j] > max[i])
                        max[i] = nums[j];
                } else {
                    if(nums[j] >= max[i] && nums[j] < max[i-1]) {
                        // System.out.println(j + " " + i + " : "+ c);
                        max[i] = nums[j];
                        b = true;
                    }
                }
            }
            if(b) {
                c++;
            }
        }

        if (c < 2) {
            return max[0];
        } else {
            return max[2];
        }
    }
}

```
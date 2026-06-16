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

## 303. Range Sum Query - Immutable [link](https://leetcode.com/problems/range-sum-query-immutable/description/)

``` java

class NumArray {
    int [] arr;
    public NumArray(int[] nums) {
        this.arr = nums;
    }
    
    public int sumRange(int left, int right) {
        int ans = 0;
        while(left <= right) {
            ans += this.arr[left++];
        }
        return ans;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

 // optimise sol 2
 
 class NumArray {
    int [] arr;
    public NumArray(int[] nums) {
        this.arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prev = i > 0 ? this.arr[i-1] : 0; 
            this.arr[i] = nums[i] + prev;
        }
    }
    
    public int sumRange(int left, int right) {
        int prev = left > 0 ? this.arr[left-1] : 0;
        
        return this.arr[right] - prev;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */

```

## 304. Range Sum Query 2D - Immutable [link](https://leetcode.com/problems/range-sum-query-2d-immutable/description/)

``` java

class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        this.mat = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int prev  = j > 0 ? this.mat[i][j-1] : 0;
                this.mat[i][j] = matrix[i][j] + prev;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            int prev = col1 > 0 ? this.mat[i][col1-1] : 0;
            ans += this.mat[i][col2] - prev;
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

```

## 27. Remove Element [link](https://leetcode.com/problems/remove-element/description/)

``` java

class Solution {
    public int removeElement(int[] nums, int val) {
        // two pointers
        // start will check if its target if yes swap with last one and decrease last
        int i = 0; 
        int j = nums.length -1;

        while(i <= j) {
            if(nums[i] == val) {
                swap(nums, i, j);
                j--;
            } else {
                i++;
            }
        }
        return i;
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j ] = temp;
    }
}

```

## 349. Intersection of Two Arrays [link](https://leetcode.com/problems/intersection-of-two-arrays/description/)

``` java

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])) {
                ans.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int[] typeAns = new int[ans.size()];
        int c = 0;
        for(int a : ans) {
            typeAns[c] = a;
            c++;
        }
        return typeAns;
    }
}

```
## 350. Intersection of Two Arrays II [link](https://leetcode.com/problems/intersection-of-two-arrays-ii/description/)

``` Java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums2.length; i++) {
            if(map.getOrDefault(nums2[i], 0) > 0) {
                ans.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        int[] typeAns = new int[ans.size()];
        int c = 0;
        for(int a : ans) {
            typeAns[c] = a;
            c++;
        }
        return typeAns;
    }
}
```

## 496. Next Greater Element I [link](https://leetcode.com/problems/next-greater-element-i/description/)

``` Java
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            int catchIndex = -1;
            ans[i] = -1;

            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j] && catchIndex == -1) {
                    // lets find next in nums2 which is greater than nums[j]
                    catchIndex = j;
                } else if (catchIndex != -1) {
                    // we have found j
                    if (nums2[catchIndex] < nums2[j]) {
                        ans[i] = nums2[j];
                        break;
                    }
                }
            }
            
        }
        return ans;
    }
}
```

## 503. Next Greater Element II [link](https://leetcode.com/problems/next-greater-element-ii/)

``` java

// [1,2,3,4,3]

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
            for (int j = 1; j < n; j++) {
                int next = (i + j) % n;
                if (nums[next] > nums[i]) {
                    ans[i] = nums[next];
                    break;
                }
            }
        }
        return ans;
    }
}



```

## 556. Next Greater Element III [link](https://leetcode.com/problems/next-greater-element-iii/description/)

``` java

class Solution {
    public int nextGreaterElement(int n) {
        long ans = (long)n;
        // Logic is here to traverse number digit from 0 - 10 - 100 and so on unit digit to next and if any current didgit is less than prev we got out target -> because if we replace this with any prev value that is just bigger than this and sort other digit we will have our ans.
        // n = 12387532
        // here if we traverse
        // 12 3 and 8 here we notice first decrease
        // now we have to find greter or equal to 3+1=4
        // if we check there is only 5
        // so answer => 12*10+5 = 125 then sort [8,7,6,3,2]
        // so ans = 125 23678 is the correct answer

        // add freq of all number for record how many time whose, and in this we have digits sorted because of index
        int[] digitFreq = new int[10];
        
        int lastDigit = -1;
        int currentDigit = -1;


        while(ans > 0) {
            currentDigit = (int)ans%10;
            ans = ans/10;
            digitFreq[currentDigit] ++;
            if(lastDigit > currentDigit) {

                int target = currentDigit + 1;
                while(digitFreq[target] == 0) target++; // this will stop if found else will keep increasing one by one and will find because we has bigger before at leat lastDigit

                ans = ans * 10 + target;
                digitFreq[target]--;

                // sort remaining and add it
                for (int d = 0; d < 10; d++) {
                    while(digitFreq[d] > 0) {
                        ans = ans * 10 + d;
                        digitFreq[d]--;
                    }
                }
                if (ans <= Integer.MAX_VALUE) {
                    return (int)ans;
                } else {
                    return -1;
                }

            }
            lastDigit = currentDigit;
        }
        return -1;
    }
}

```

## 1366. Rank Teams by Votes [link](https://leetcode.com/problems/rank-teams-by-votes/description/)

``` java
// after doubt class 15th june 2026
class Solution {
    public String rankTeams(String[] votes) {
        // lets create freq matrix 26*total team 0,25
        // will record rank or all letters by makeing n-index as place value
        // sort will make rearrenge
        // ["WXYZ","XYZW"]
        //[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,3,2,1]
        //[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,4,3,2]
        // int[] freq = new int[26];
        int[][] mat = new int[26][votes[0].length()+1];

        for(int i = 0; i < votes.length; i++) {
            String vote = votes[i]; // vote
            for(int j = 1; j <= vote.length(); j++) {
                char team = vote.charAt(j-1);
                mat[team-'A'][0] = team;
                mat[team-'A'][j] ++;
            }
        }
        // System.out.println(Arrays.deepToString(mat));

        Arrays.sort(mat, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                for(int i = 1; i<= votes[0].length(); i++) {
                    if(a[i] > b[i]) {
                        return -1;
                    }
                    if(b[i] > a[i]) {
                        return 1;
                    }
                }
                return 1;
            }
        });
        // System.out.println(Arrays.deepToString(mat));

        char[] ansArr = new char[votes[0].length()];

        for(int i = 0; i < votes[0].length(); i++) {
            ansArr[i]= (char)mat[i][0];
        }

        return new String(ansArr);
    }
}

```

## 1338. Reduce Array Size to The Half [link](https://leetcode.com/problems/reduce-array-size-to-the-half/description/)

``` java

// After doubt class 15th june 2026

class Solution {
    public int minSetSize(int[] arr) {
        List<Integer> keys = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }

        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                keys.add(map.get(arr[i]));
                map.remove(arr[i]);
            }
        }

        Collections.sort(keys);
        int ans = 0;
        int target = arr.length/2;
        int size = arr.length;
        for(int i = keys.size()-1; i >= 0; i--) {
            ans++;
            size -= keys.get(i);
            if(size <= target) {
                return ans;
            }
        }
        return ans;
    }
}

```

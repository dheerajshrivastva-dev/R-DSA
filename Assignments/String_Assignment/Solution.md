# String

## 5. Longest Palindromic Substring [link](https://leetcode.com/problems/longest-palindromic-substring/description/)

``` java

```

## 3. Longest Substring Without Repeating Characters [link](https://leetcode.com/problems/longest-substring-without-repeating-characters/description/)

``` java

// sol 1 using map

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

// sol 2 using set


class Solution {
    public int lengthOfLongestSubstring(String s) {
        // variable window
        Set<Character> set = new HashSet<>();

        int i = 0;
        int ans = 0;
        int count = 0;
        for(int j = 0; j < s.length(); j++) {
            
            if(set.contains(s.charAt(j))) {
                ans = Math.max(ans, count);
                // System.out.println(ans + " " + count + " J "+j + " i "+ i);
                while(set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                    count--;
                }
                // System.out.println(ans + " " + count + " J "+j+ " i "+ i);
                count++;
                set.add(s.charAt(j));
            } else {
                count++;
                set.add(s.charAt(j));
            }
            
        }
        ans = Math.max(ans, count);
        return ans;
    }
}

```

## 14. Longest Common Prefix [link](https://leetcode.com/problems/longest-common-prefix/description/)

``` java

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < strs[0].length(); i++) {
            for(int j = 0; j < strs.length; j++) {
                String str = strs[j];
                if(i == str.length()) {
                    return sb.toString();
                }

                if(strs[j].charAt(i) != strs[0].charAt(i)) {
                    return sb.toString();
                }

            }
            sb.append(strs[0].charAt(i));
        }
        return sb.toString();
    }
}

```

## 20. Valid Parentheses [link](https://leetcode.com/problems/valid-parentheses/description/)

``` java
// not solved I think this need queue

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch:s.toCharArray()) {
            switch(ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if(stack.size() == 0 || stack.pop() != '{') return false;
                    break;
                case ']':
                    if(stack.size() == 0 || stack.pop() != '[') return false;
                    break;
                case ')':
                    if(stack.size() == 0 || stack.pop() != '(') return false;
                    break;
                default:
                    return false;

            }
        }
        return stack.size() > 0 ? false: true;
    }
}

```

## 49. Group Anagrams [link](https://leetcode.com/problems/group-anagrams/description/)

``` java

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int[] freq = new int[26];
            for(int j = 0; j < str.length(); j++) {
                freq[str.charAt(j)-'a']++;
            }
            String key = Arrays.toString(freq);
            List<String> thisAnswer = new ArrayList<>();
            thisAnswer.add(str);
            map.compute(key, (k, v) -> {
                if (v == null) return thisAnswer;
                else {
                    v.add(str);
                    return v;
                }
            });
        }

        for(Map.Entry<String, List<String>> e: map.entrySet()) {
            ans.add(e.getValue());
        }
        return ans;
    }
}

```

## 91. Decode Ways [link](https://leetcode.com/problems/decode-ways/description/)

``` java



```
## 
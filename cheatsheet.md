# Java DSA Cheatsheet

## Boilerplate

```java
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        // your code
    }
}
```

## Input (Scanner)

```java
Scanner sc = new Scanner(System.in);

int n       = sc.nextInt();
long l      = sc.nextLong();
double d    = sc.nextDouble();
String word = sc.next();         // reads one token (no spaces)
String line = sc.nextLine();     // reads full line
sc.nextLine();                   // consume leftover newline after nextInt()

// read n integers
int[] a = new int[n];
for (int i = 0; i < n; i++) a[i] = sc.nextInt();

// read n×m grid
int[][] grid = new int[n][m];
for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
        grid[i][j] = sc.nextInt();
```

## Input (BufferedReader — faster for large input)

```java
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
int n = Integer.parseInt(br.readLine().trim());
int[] a = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
StringTokenizer st = new StringTokenizer(br.readLine());
int x = Integer.parseInt(st.nextToken());
int y = Integer.parseInt(st.nextToken());
```

## Print / Output

```java
System.out.println(val);            // with newline
System.out.print(val);              // no newline
System.out.printf("%.2f\n", 3.14);  // formatted
System.out.printf("%d %s\n", n, s);

String.format("%05d", n);           // zero-padded string
String.format("%-10s|", s);         // left-aligned, width 10

// fast output for many lines
PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
pw.println(val);
pw.flush();  // must flush at end
```

## Print Arrays / Collections

```java
// 1D array
System.out.println(Arrays.toString(arr));       // [1, 2, 3]

// 2D array
System.out.println(Arrays.deepToString(grid));  // [[1,2],[3,4]]

// List
System.out.println(list);                       // [1, 2, 3]

// manual loop
for (int x : arr) System.out.print(x + " ");
System.out.println();

// join with delimiter
System.out.println(String.join(", ", strList));
```

## Class

```java
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

// generic
class Pair<A, B> {
    A first;
    B second;
    Pair(A first, B second) { this.first = first; this.second = second; }
}
```

## Methods / Functions

```java
// static method (use in competitive / DSA context)
static int add(int a, int b) {
    return a + b;
}

// varargs
static int sum(int... nums) {
    int s = 0;
    for (int n : nums) s += n;
    return s;
}

// return multiple values via array or int[]
static int[] minMax(int[] a) {
    int lo = a[0], hi = a[0];
    for (int x : a) { lo = Math.min(lo, x); hi = Math.max(hi, x); }
    return new int[]{lo, hi};
}
```

## Loops

```java
// classic
for (int i = 0; i < n; i++) { }

// reverse
for (int i = n - 1; i >= 0; i--) { }

// two pointer style
for (int l = 0, r = n - 1; l < r; l++, r--) { }

// for-each
for (int x : arr) { }
for (Map.Entry<Integer, Integer> e : map.entrySet()) { }

// while
while (condition) { }

// do-while
do { } while (condition);

// labeled break (exit outer loop)
outer:
for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
        if (condition) break outer;
```

## Conditionals & Ternary

```java
if (a > b) { } else if (a == b) { } else { }

int max = (a > b) ? a : b;

// switch (Java 14+ expression form)
int day = 3;
String name = switch (day) {
    case 1 -> "Mon";
    case 2 -> "Tue";
    default -> "Other";
};
```

## Type Conversions

```java
int    → String : String.valueOf(n)  or  n + ""
String → int    : Integer.parseInt(s)
int    → long   : (long) n
double → int    : (int) d            // truncates
char   → int    : (int) ch  or  ch - '0'  (digit)  or  ch - 'a'  (lowercase)
int    → char   : (char)(n + 'a')
String → char[]: s.toCharArray()
char[] → String: new String(chars)
int[]  → List  : // no direct; use loop or Arrays.stream(a).boxed().collect(...)
List   → int[]: list.stream().mapToInt(x->x).toArray()
```

## Sorting with Comparator

```java
// sort 2D array by first element
Arrays.sort(arr, (a, b) -> a[0] - b[0]);

// sort by length then lexicographically
Arrays.sort(strs, (a, b) -> a.length() != b.length()
    ? a.length() - b.length() : a.compareTo(b));

// sort list of objects
list.sort((a, b) -> a.val - b.val);

// reverse sort
Arrays.sort(arr, Comparator.reverseOrder()); // works for Integer[], not int[]
```

## ArrayList

```java
List<Integer> list = new ArrayList<>();
list.add(val);               // append
list.add(idx, val);          // insert at index
list.get(idx);               // O(1) read
list.set(idx, val);          // O(1) update
list.remove(idx);            // remove by index
list.remove(Integer.valueOf(val)); // remove by value
list.size();
list.contains(val);
list.indexOf(val);
Collections.sort(list);
Collections.sort(list, (a, b) -> b - a); // desc
Collections.reverse(list);
list.subList(from, to);      // [from, to)
```

## LinkedList (as Deque)

```java
Deque<Integer> dq = new LinkedList<>();
dq.addFirst(val);   // push front
dq.addLast(val);    // push back
dq.peekFirst();     // front without remove
dq.peekLast();
dq.pollFirst();     // remove front
dq.pollLast();      // remove back
dq.isEmpty();
dq.size();
```

## Stack

```java
Deque<Integer> stack = new ArrayDeque<>();
stack.push(val);    // addFirst
stack.pop();        // removeFirst
stack.peek();       // peekFirst
stack.isEmpty();
```

## Queue

```java
Queue<Integer> q = new LinkedList<>();
q.offer(val);       // enqueue
q.poll();           // dequeue (null if empty)
q.peek();           // front (null if empty)
q.isEmpty();
q.size();
```

## PriorityQueue (Heap)

```java
PriorityQueue<Integer> minH = new PriorityQueue<>();
PriorityQueue<Integer> maxH = new PriorityQueue<>(Collections.reverseOrder());
// custom comparator
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

minH.offer(val);
minH.poll();        // removes min
minH.peek();        // reads min
minH.size();
```

## HashMap

```java
Map<Integer, Integer> map = new HashMap<>();
map.put(k, v);
map.get(k);                          // null if missing
map.getOrDefault(k, def);
map.containsKey(k);
map.containsValue(v);
map.remove(k);
map.size();
map.isEmpty();
map.putIfAbsent(k, v);
map.merge(k, 1, Integer::sum);       // freq count shorthand
for (Map.Entry<Integer,Integer> e : map.entrySet()) { e.getKey(); e.getValue(); }
map.keySet();
map.values();
```

## TreeMap (sorted keys)

```java
TreeMap<Integer, Integer> tm = new TreeMap<>();
tm.firstKey();
tm.lastKey();
tm.floorKey(k);     // largest key <= k
tm.ceilingKey(k);   // smallest key >= k
tm.higherKey(k);    // strictly > k
tm.lowerKey(k);     // strictly < k
tm.headMap(k);      // keys < k
tm.tailMap(k);      // keys >= k
```

## HashSet

```java
Set<Integer> set = new HashSet<>();
set.add(val);
set.remove(val);
set.contains(val);  // O(1)
set.size();
```

## TreeSet (sorted)

```java
TreeSet<Integer> ts = new TreeSet<>();
ts.first();
ts.last();
ts.floor(val);      // largest <= val
ts.ceiling(val);    // smallest >= val
ts.higher(val);     // strictly > val
ts.lower(val);      // strictly < val
ts.headSet(val);    // < val
ts.tailSet(val);    // >= val
ts.subSet(lo, hi);  // [lo, hi)
```

## Arrays utility

```java
int[] a = new int[n];
Arrays.fill(a, val);
Arrays.sort(a);
Arrays.sort(a, from, to);          // sorts [from, to)
Arrays.binarySearch(a, val);       // array must be sorted
Arrays.copyOf(a, newLen);
Arrays.copyOfRange(a, from, to);
Arrays.equals(a, b);
Arrays.toString(a);                // debug print
int[][] grid = new int[r][c];
Arrays.stream(a).sum();
Arrays.stream(a).max().getAsInt();
Arrays.stream(a).min().getAsInt();
```

## Collections utility

```java
Collections.sort(list);
Collections.sort(list, Comparator.reverseOrder());
Collections.reverse(list);
Collections.shuffle(list);
Collections.min(list);
Collections.max(list);
Collections.frequency(list, val);
Collections.binarySearch(list, val);  // list must be sorted
Collections.fill(list, val);
Collections.swap(list, i, j);
Collections.nCopies(n, val);          // immutable list of n copies
Collections.unmodifiableList(list);
```

## String / StringBuilder

```java
String s = "hello";
s.length();
s.charAt(idx);
s.indexOf(ch);
s.lastIndexOf(ch);
s.substring(from, to);   // [from, to)
s.contains("sub");
s.startsWith("pre");
s.endsWith("suf");
s.equals(other);
s.equalsIgnoreCase(other);
s.toCharArray();
s.split("regex");
s.trim();
s.toLowerCase();
s.toUpperCase();
String.valueOf(num);
Integer.parseInt(str);
Character.isDigit(ch);
Character.isLetter(ch);
Character.toLowerCase(ch);

StringBuilder sb = new StringBuilder();
sb.append(val);
sb.insert(idx, val);
sb.deleteCharAt(idx);
sb.delete(from, to);
sb.reverse();
sb.toString();
sb.length();
sb.charAt(idx);
sb.setCharAt(idx, ch);
```

## Math

```java
Math.max(a, b);
Math.min(a, b);
Math.abs(val);
Math.pow(base, exp);     // returns double
Math.sqrt(val);          // returns double
Math.log(val);           // natural log
Math.floor(val);
Math.ceil(val);
Math.round(val);
Integer.MAX_VALUE;       // 2^31 - 1
Integer.MIN_VALUE;       // -2^31
Long.MAX_VALUE;
```

## Bit tricks

```java
n & 1           // check odd
n >> 1          // divide by 2
n << 1          // multiply by 2
n & (n - 1)     // clear lowest set bit (check power of 2 if == 0)
n & (-n)        // isolate lowest set bit
Integer.bitCount(n)      // count set bits
Integer.highestOneBit(n)
Integer.numberOfTrailingZeros(n)
```

# Time and Space complixity

## Problem 1

``` text

Problem 1 :  
int a = 0, b = 0; 
for (i = 0; i < N; i++) { 
  a = a + rand(); 
} 
for (j = 0; j < M; j++) { 
  b = b + rand(); 
} 

```

## Ans

``` text


First loop till N

second Loop till M

Time Complixity => O(Max(M,N));

Space => O(1) no extra space used

OverAllSpace => O(1) no extra space

```

## Problem2

``` text

Problem 2 :   
int a = 0; 
for (i = 0; i < N; i++) { 
  for (j = N; j > i; j--) { 
    a = a + i + j; 
  } 
} 


```

## Ans

``` text

Total run

i = 0
   loop => J = 10 to J = 1
i = 9
   loop => J = 10 to j = 2

Total = [9,8,7,6,5,4,3,2,1] ==> N(N-1)/2

So

Time Complixity => O(N^2)
Space ''        => O(1) // no extra space
Over all Space '' => O(1) 


```

## Problem 3

``` text

Problem 3 :  
int a = 0, i = N; 
while (i > 0) { 
  a += i; 
  i /= 2; 
} 



```

## Ans

```text

Time Complixity => O(lonN) // if its end twice fast every time its log2N => logN
Space ''        => O(1)
Overall Space => O(1)

```

## Problem 4

``` text

for(var i=0;i<n;i++) 
i*=k 

```

## Ans

``` text

Time complixity => O(log (base k) N)

```

## Problem 5

``` text
Problem 5 :   
var value = 0; 
for(var i=0;i<n;i++) 
  for(var j=0;j<i;j++) 
    value += 1;  

```

## Ans

``` text

Time => O(n^2)
Space => O(1)
Total Space => O(1)

```

# Path compression in union find
```
    private int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]); // path compression
        return parent[x];
    }
```
# BST Predecessor/Successor
```
public class InorderSuccessorPredecessor {
	static int successor, predecessor;

	public void successorPredecessor(Node root, int val) {
		if (root != null) {
			if (root.data == val) {
				// go to the right most element in the left subtree, it will the
				// predecessor.
				if (root.left != null) {
					Node t = root.left;
					while (t.right != null) {
						t = t.right;
					}
					predecessor = t.data;
				}
				if (root.right != null) {
					// go to the left most element in the right subtree, it will
					// the successor.
					Node t = root.right;
					while (t.left != null) {
						t = t.left;
					}
					successor = t.data;
				}
			} else if (root.data > val) {
				// we make the root as successor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the successor, in that case we need
				// parent to be the successor
				successor = root.data;
				successorPredecessor(root.left, val);
			} else if (root.data < val) {
				// we make the root as predecessor because we might have a
				// situation when value matches with the root, it wont have
				// left subtree to find the predecessor, in that case we need
				// parent to be the predecessor.
				predecessor = root.data;
				successorPredecessor(root.right, val);
			}
		}
	}
```
# Collections.sort用法
1. 用在List<Integer>
2. 用在String
# Deque
[239](https://leetcode.com/problems/sliding-window-maximum/)
# Math
1. Math.sqrt return double type
2. [319](https://leetcode.com/problems/bulb-switcher/) 根本扯
# Rotation/Reverse
1. please be careful of the rotation times K might exceed the totalLength, therefore, K should be modulo totalLength.
2. [151](https://leetcode.com/problems/reverse-words-in-a-string/); [61](https://leetcode.com/problems/rotate-list/);[189](https://leetcode.com/problems/rotate-array/); [186](https://leetcode.com/problems/reverse-words-in-a-string-ii/); [190](https://leetcode.com/problems/reverse-bits/); [7](https://leetcode.com/problems/reverse-integer/)
# Bit manipulation
[190](https://leetcode.com/problems/reverse-bits/)
[393](https://leetcode.com/problems/utf-8-validation/)
1. integer to binary number: 
```
int x = 100;
System.out.println(Integer.toBinaryString(x));
```
2. use 0b to format integer
```
int binaryInt = 0b101;
```
# MAX/MIN Integer
```
public static final int	MAX_VALUE	2147483647
public static final int	MIN_VALUE	-2147483648
```
# 求Y軸對稱
[356](https://leetcode.com/problems/line-reflection/)
1. sum = max + min
2. sum - 某個X = 對稱後的Ｘ
# GCD
```
private int generateGCD(int a,int b){
    
        	if (b==0) return a;
        	else return generateGCD(b,a%b);
        	
        }
```
# StringBuilder API
```
sb.setCharAt(int index, char c)
sb.deleteCharAt(int index)
```
# Special String API
```
public boolean startsWith(String prefix, int toffset)
or
public boolean startsWith(String prefix)
```
# Map/Set operation
1. in set
```
map.entrySet().iterator.next().getValue()
```
2. iterate Key
```
map.keySet()
```
# indexOf
```
public int indexOf(int ch )

public int indexOf(int ch, int fromIndex)

int indexOf(String str)

int indexOf(String str, int fromIndex)
```
# Arrays.API
```
Arrays.sort(int []array, int fromIndex, int toIndex)
toIndex is exclusive!!!
```
# Queue API
[339](https://leetcode.com/problems/nested-list-weight-sum/)
```
Queue<T> queue = new LinkedList<>(list);
queue.addAll(list);
```
# Decending order using Arrays.sort
```
Arrays.sort(cal, Collections.reverseOrder());	
```
```
	This is not allowed
        Arrays.sort(cal, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
	
	This is allowed
	Integer []arr = new Integer[]{5,3,1,6,9,4,2};
        Arrays.sort(arr, new Comparator<>(){
           public int compare(Integer a, Integer b){
           return b.compareTo(a);
           return b - a;
        }
        });
```
# TreeSet decending order
```
Set<Integer> sorted = new TreeSet<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });	
```

# compare double
```
Leetcode 857.	
        Arrays.sort(workers, new Comparator<double []>(){
            public int compare(double []a, double []b){
                return Double.compare(a[0], b[0]);
            }
            
        });	
```	
# String API
```
String.replaceAll(regex, replacement)
```

# Reverse Order
```
PriorityQueue<Integer> neheap = new PriorityQueue<>(Collections.reverseOrder());
```
	

# Mountain Related
1.判斷 nums[mid] < nums[mid + 1]

# Majority Element(背
[169](https://leetcode.com/problems/majority-element/)
[229](https://leetcode.com/problems/majority-element-ii/)

# Split Regex
1. [165](https://leetcode.com/problems/compare-version-numbers/) split("\\."); instead of split(".");

# Rewrite Comparator
[937](https://leetcode.com/problems/reorder-data-in-log-files/)
[179](https://leetcode.com/problems/largest-number/)

# OverFlow Handle
[7](https://leetcode.com/problems/reverse-integer); [8](https://leetcode.com/problems/string-to-integer-atoi); [564](https://leetcode.com/problems/find-the-closest-palindrome/)

# Plus one
1. [66](https://leetcode.com/problems/plus-one/); [67](https://leetcode.com/problems/add-binary/);[369](https://leetcode.com/problems/plus-one-linked-list/);[989](https://leetcode.com/problems/add-to-array-form-of-integer/)

# Long type necessary?
[633](https://leetcode.com/problems/sum-of-square-numbers/); [564](https://leetcode.com/problems/find-the-closest-palindrome/)

# Palindrome
[214](https://leetcode.com/problems/shortest-palindrome/)
# Subarray
1. use hashmap
[325](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)
[209](https://leetcode.com/problems/minimum-size-subarray-sum/)
[713](https://leetcode.com/problems/subarray-product-less-than-k/)
[523](https://leetcode.com/problems/continuous-subarray-sum/)
[974](https://leetcode.com/problems/subarray-sums-divisible-by-k/)
[525](https://leetcode.com/problems/contiguous-array/)


# TreeMap/TreeSet 
[363](https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/)

# StringBuilder api
```
deleteCharAt(int index)
```
# Sliding Window Related
[159](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem)
567 & 438 同個寫法
[567](https://leetcode.com/problems/permutation-in-string/) 
[438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) 
[76](https://leetcode.com/problems/minimum-window-substring/)

-----------------------------------------------------------------------------------------------------------------

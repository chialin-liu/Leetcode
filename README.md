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
# Map/Set operation
1. in set
```
map.entrySet().iterator.next().getValue()
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
```
# OverFlow Handle
[7](https://leetcode.com/problems/reverse-integer); [8](https://leetcode.com/problems/string-to-integer-atoi); [564](https://leetcode.com/problems/find-the-closest-palindrome/)

# Plus one
1. [66](https://leetcode.com/problems/plus-one/); [67](https://leetcode.com/problems/add-binary/);[369](https://leetcode.com/problems/plus-one-linked-list/);[989](https://leetcode.com/problems/add-to-array-form-of-integer/)

# Long type necessary?
[633](https://leetcode.com/problems/sum-of-square-numbers/); [564](https://leetcode.com/problems/find-the-closest-palindrome/)

# Palindrome
[214](https://leetcode.com/problems/shortest-palindrome/)

### LC-4<https://leetcode.com/problems/median-of-two-sorted-arrays/>
1. [Teaching](https://www.youtube.com/watch?time_continue=1405&v=LPFhl65R7ww&feature=emb_logo)
### LC-7<https://leetcode.com/problems/reverse-integer/>
1. be careful of overflow handling
### LC-8<https://leetcode.com/problems/string-to-integer-atoi/>
1. be careful of Integer.MIN or Integer.MAX
2. be careful of " empty space "
### LC-45<https://leetcode.com/problems/jump-game-ii/>
1. greedy:
### LC-61: <https://leetcode.com/problems/rotate-list/>
1. connect the tail node to the head; to form a loop
2. find the new head node, and then break up the point
### LC-65<https://leetcode.com/problems/valid-number/>
1. be carefull "e9", "1 ", " 005047e+" cases
### LC-66<https://leetcode.com/problems/plus-one/>
1. if last digit is not 9: no need to handle carry
2. if it is 9, for loop
3. and then declare another bit for carry 
### LC-67<https://leetcode.com/problems/add-binary/>
1. same as plus one
### LC-151 <https://leetcode.com/problems/reverse-words-in-a-string/>
1. use trim() to remove head/tail empty space
2. use split("\\s+") to remove more than one space
### LC-157<https://leetcode.com/problems/read-n-characters-given-read4/>
1. n is the max length of buffer 
### LC-158
### LC-186:<https://leetcode.com/problems/reverse-words-in-a-string-ii/>
1. reverse entire array, and then use left/right pointer to reverse each seperate character between the empty space
### LC-189 <https://leetcode.com/problems/rotate-array>
1. three step reverse can form O(1) space complexity
### LC-190 <https://leetcode.com/problems/reverse-bits/>
1. bit manipulation
### LC-214<https://leetcode.com/problems/shortest-palindrome/>
1. use left, right pointer to check equality; if not update the end pointer
2. reverse the substring(end + 1) and add in front
### LC-218
1. [huahua](https://www.youtube.com/watch?v=8Kd-Tn_Rz7s)
### LC-273<https://leetcode.com/problems/integer-to-english-words/>
1. be careful "if num == 0" return "Zero"
### LC-328 <https://leetcode.com/problems/odd-even-linked-list/>
1. be carefull of the while loop case
### LC-369<https://leetcode.com/problems/plus-one-linked-list/>
1. be careful of reverse(head) cannot be called twice
### LC-564<https://leetcode.com/problems/find-the-closest-palindrome/>
1. be careful pattern "999", i will output "989" instead of "1001"
2. be careful OverFlow
3. use five cases to find the difference smallest
4. pow(10, n.length()) + 1 rather pow(10, n.length() + 1) + 1
### LC-633<https://leetcode.com/problems/sum-of-square-numbers/>
1. use sqrt to calculate the difference between c & a^2
2. be careful of long type in a
### LC-725 <https://leetcode.com/problems/split-linked-list-in-parts/>
1. do not miss to cut down the tail to null; if not doing this step, you will have duplicate numbers
2. in while loop, stop at the tail node
3. be carefull of the cur == null case

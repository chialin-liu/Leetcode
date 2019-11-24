# Rotation/Reverse
1. please be careful of the rotation times K might exceed the totalLength, therefore, K should be modulo totalLength.
2. [151](https://leetcode.com/problems/reverse-words-in-a-string/); [61](https://leetcode.com/problems/rotate-list/);[189](https://leetcode.com/problems/rotate-array/); [186](https://leetcode.com/problems/reverse-words-in-a-string-ii/); [190](https://leetcode.com/problems/reverse-bits/); [7](https://leetcode.com/problems/reverse-integer/)
# Bit manipulation
[190](https://leetcode.com/problems/reverse-bits/)

# OverFlow Handle
[7](https://leetcode.com/problems/reverse-integer); [8](https://leetcode.com/problems/string-to-integer-atoi)


### LC-7<https://leetcode.com/problems/reverse-integer/>
1. be careful of overflow handling
### LC-8<https://leetcode.com/problems/string-to-integer-atoi/>
1. be careful of Integer.MIN or Integer.MAX
2. be careful of " empty space "

### LC-61: <https://leetcode.com/problems/rotate-list/>
1. connect the tail node to the head; to form a loop
2. find the new head node, and then break up the point
## LC-65<https://leetcode.com/problems/valid-number/>
1. be carefull "e9", "1 ", " 005047e+" cases
### LC-151 <https://leetcode.com/problems/reverse-words-in-a-string/>
1. use trim() to remove head/tail empty space
2. use split("\\s+") to remove more than one space
### LC-186:<https://leetcode.com/problems/reverse-words-in-a-string-ii/>
1. reverse entire array, and then use left/right pointer to reverse each seperate character between the empty space
### LC-189 <https://leetcode.com/problems/rotate-array>
1. three step reverse can form O(1) space complexity
### LC-190 <https://leetcode.com/problems/reverse-bits/>
1. bit manipulation
### LC-328 <https://leetcode.com/problems/odd-even-linked-list/>
1. be carefull of the while loop case
### LC-725 <https://leetcode.com/problems/split-linked-list-in-parts/>
1. do not miss to cut down the tail to null; if not doing this step, you will have duplicate numbers
2. in while loop, stop at the tail node
3. be carefull of the cur == null case

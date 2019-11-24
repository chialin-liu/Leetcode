# Rotation/Reverse
1. please be careful of the rotation times K might exceed the totalLength, therefore, K should be modulo totalLength.
2. [151](https://leetcode.com/problems/reverse-words-in-a-string/); [61](https://leetcode.com/problems/rotate-list/);[189](https://leetcode.com/problems/rotate-array/); [186](https://leetcode.com/problems/reverse-words-in-a-string-ii/)

### LC-61: <https://leetcode.com/problems/rotate-list/>
1. connect the tail node to the head; to form a loop
2. find the new head node, and then break up the point
### LC-151 <https://leetcode.com/problems/reverse-words-in-a-string/>
1. use trim() to remove head/tail empty space
2. use split("\\s+") to remove more than one space
### LC-186:<https://leetcode.com/problems/reverse-words-in-a-string-ii/>
1. reverse entire array, and then use left/right pointer to reverse each seperate character between the empty space
### LC-189 <https://leetcode.com/problems/rotate-array>
1. three step reverse can form O(1) space complexity

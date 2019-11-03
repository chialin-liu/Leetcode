This problem can be solved using hashmap in O(N) time complexity and needs additional O(N) space complexity.
in Brute force, we use two for-loop, time complexity is O(N^2), it is too large
## Follow up:
1. what if we have duplicate numbers?
2. if there are more than one pair meets the requirement, how can we print all candidates?
Because we need to return the index, therefore, we have to use hashmap to store the value and index. If we dont have to return the index
then, we can only use "set" instead.

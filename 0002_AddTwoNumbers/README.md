## Error case pattern
L1: [1], L2: [9, 9], we ignore if (L1 == null && L2 != null), the carry add L2.val will probably overflow the amount, therefore we need use while(carry == 1)
After trying to write by myself, I directly see the video solution
# mind the if sum == 1 after the while-loop

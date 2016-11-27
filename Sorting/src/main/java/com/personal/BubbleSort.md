#Bubble Sort

This is the simplest sorting algorithm. 

Logic (e.g..  9 8 6 4 1 0)
 Pass 1 : compare each pair, swap if greater element is first in the order. At the end You get max element @last index
        After pass 1 : 8 6 4 1 9 0
 Pass 2 : This is a new problem if we drop last element 9 . i.e. 8 6 4 1 0
           6 4 1 0 8     9
 Pass 3 :  4 1 0 6     8 9
 Pass 4 :  1 0 4     6 8 9
 Pass 5 :  0 1     4 6 8 9
 Pass 6 :  0     1 4 6 8 9

Algorithm 
1. Perform 1 pass to get the maximum number bubbled out in the end.  
   0 1 4 8 6 9
   '9' has been bubbled out in the end.
2. Dropping the last index, you get the same problem as in 1.
   Except last index ('9'), You have the same problem in hand i.e. (0 1 4 8 6) 
   Perform same operation for this reduced index, until no more elements to compare.

Time Compexity : 
Best case :  O(n^2).
Space Compexity : O(1)

An advanced version is implemented to reduce the Best case complexity to O(n). 

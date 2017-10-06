# leetcode_practice

  This folder is to save leetcode submitted code and there are no input testcase
  
  All codes would not be accepted without any change since they were compiled in local PC and leetcode has its own compilation. Codes could be accepted after deleting the definition of packages and some imports. 
  
# TO DO
  652
  322
  393
  101
  385
  236
  450
  344
  657
  504
  316
  640
  230
  394
  321
  467
  
# 每日十题：https://goo.gl/Q4tlea
# 面经：https://goo.gl/qihF2v
  Problem
You want to create a certain target string S, which consists only of lowercase English letters. You start with an empty string, and you are allowed to perform the following operations:
Add any single lowercase letter to the end of your string.
Copy any substring of your string (that is, all of the characters between some start point in your string and some end point in your string) to the clipboard. Doing this overwrites whatever was in the clipboard before. The clipboard starts off empty.
Add the entire contents of the clipboard to the end of your string. (The contents of the clipboard do not change.)
What is the smallest number of operations needed to create your target string? Note that you must create exactly the target string, with no additional letters.
Input
The first line of the input gives the number of test cases, T. T lines follow. Each line contains the target string S.
Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the minimum number of operations (as described in the problem statement) needed to create the target string.
Limits
S consists only of lowercase English letters in the range a through z.Small dataset
1 ≤ T ≤ 100.
1 ≤ length of S ≤ 6.

Large dataset
1 ≤ T ≤ 100.
1 ≤ length of S ≤ 300.

Sample

Input 
  
Output 
  
3
abcabab
aaaaaaaaaaa
vnsdmvnsnsdmkvdmkvnsdmk

 Case #1: 6
Case #2: 7
Case #3: 15

 
The optimal solution for Sample Case #1 is:
Type a.
Type b.
Type c.
Copy ab to the clipboard.
Paste ab at the end of the string.
Paste ab at the end of the string.
The optimal solution for Sample Case #2 is:Type a.
Type a.
Type a.
Copy aaa to the clipboard.
Paste aaa at the end of the string.
Copy aaaaa to the clipboard.
Paste aaaaa at the end of the string.

Problem
In this problem, we will consider a trapezoid to be a convex quadrilateral with exactly one pair of parallel sides. If the lengths of the two non-parallel sides are equal, we say the trapezoid is isosceles.
You have some wooden sticks of various lengths, and you need to pick exactly four of them to form the four sides of an isosceles trapezoid. How many different sets of four sticks will allow this? Even if two sticks have the same length, they are considered to be different sticks. Sticks could not be bended and broke into parts.
Input
The first line of the input gives the number of test cases, T. T test cases follow; each consists of two lines. The first line consists of one integer N, the number of sticks. The second line consists of N integers; the i-th of these, Li, represents the length of the i-th stick.
Output
For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1), and y is the number of different sets of four sticks that can form an isosceles trapezoid, as described above.
Limits
1 ≤ T ≤ 100.
1 ≤ Li ≤ 109.

Small dataset
1 ≤ N ≤ 50.

Large dataset
1 ≤ N ≤ 5000.

Sample

Input 
  
Output 
  
5
5
2 3 3 4 3
4
1 5 3 1
4
2 2 3 3
4
999999998 999999999 999999999 1000000000
9
3 4 1 4 2 5 3 1 3
 Case #1: 5
Case #2: 0
Case #3: 0
Case #4: 1
Case #5: 73

 
In Sample Case #1, there are five ways to choose four out of the five given sticks, and any one of those five sets of four sticks can be used to form an isosceles trapezoid. 
In Sample Case #2, note that the set {1, 1, 3, 5} cannot form an isosceles trapezoid, even though two of its sticks are of equal length.
In Sample Case #3, note that the set {2, 2, 3, 3} can form a rectangle, but in this problem, a rectangle is not considered to be an isosceles trapezoid.

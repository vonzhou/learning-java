
☆☆☆  数组 Array
Pascal's Triangle 就是普通的迭代，注意细节，如果让求 (a+b)^n 的系数，是不是可以想到帕斯卡三角形这里。
Plus One 简单，空间申请大一格，而后处理进位，这里无需考虑溢出的问题，大数相加的问题？
Container With Most Water 通过两指针来找到满足某条件的两个点。
(◇)3Sum  找3数之和是0，难点在于如何消除重复的triple，不能用JCF的Set，需要进一步思考！！
Unique Binary Search Trees  1-n能构成多少个BST，排列组合的思想
Rotate Array 很常见

-----------------------
☆☆☆  链表 Link List
Linked List Cycle 判断链表是否有循环，两指针问题，看是否会邂逅，
Add Two Numbers 遍历相加，简单。

☆  栈 Stack
Valid Parentheses 括号匹配问题，只要思路清晰，很简单。
Min Stack 利用两个栈来实现常数时间的获得最小元素，时间空间权衡的例子。

--------------------
☆☆☆  树 Tree 
Balanced Binary Tree  什么是剪枝，避免多次遍历；
Path Sum
(◇)Binary Tree Postorder/Inorder/Preorder Traversal 考察二叉树的前中后序的非递归实现，难点是后序遍历。
Populating Next Right Pointers in Each Node 将每一层的节点用next串接起来，难点在于常数空间复杂度。

----------------------
☆☆☆  字符串 String
split方法注意理解, 原理是啥？ 是否总能符合自己的需求；
区分 空格字符，空串，null 的含义；
Valid Palindrome 回文的判断，重点是对一些边界的考虑；
Valid Number 判数据是否有效，主要是全面，特别是科学计数的表示方法，以及正负的考虑，漏掉任何一种情况都不会 AC；
			思路一定要清晰，像 3.  0.  .1  -0  -.0   -.0   .0E-0  +1e0 都是有效的
			对于浮点数左右两边不能同时为空，对于科学计数法左边是浮动数或整数，右边是整数。
Add Binary 直接遍历俩字符串，有点归并排序的味道，不过这里是相加构造新的StringBuilder。
ZigZag Conversion 	把之字形表示的字符串分层表示，花了2.5h，重在找到一种迭代模式，剩下的都是细节。	
Reverse String In Words 如果用库函数分词的话主要注意开头的空格是否存在 ； 用C如何实现in place ？
Compare Version Numbers 考虑全面，才会找到正确的思路，虽然不难

----------------------
☆☆☆  动态规划

Triangle
Minimum Path Sum   
Maximum Subarray 找连续元素之后最大的子数组


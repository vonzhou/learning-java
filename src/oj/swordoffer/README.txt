
剑指offer编程实现-Java

1. 实现=运算符函数（C++）；
2. 实现Singleton模式；

3. 在一个二维数组中，每一行从左至右递增，每一列从上至下递增， 判断该数组中是否包含某个整数（FindInPartiallySortedMatrix）
4.实现一个函数，把字符串中的每个空格替换为“%20”,输出  （ReplaceBlank）；
  相关：有两个排序数组A1，A2，A1后面有足够的空间，实现把A2数组的数字插入到A1中(MergeTwoSortedArr)；
5.从后往前输出一个链表的序列 （ PrintListReversely）
6. 根据二叉树的前序遍历和中序遍历结果构建二叉树 （假设遍历结果不含重复数字） （ConstructBinaryTree）
7. 用两个栈实现队列，要求实现appendTail,delteHead方法  （QueueWithTwoStacks）；
相关：用两个队列实现一个栈（StackWithTwoQueues）；
8. 旋转数组的最小数字 - MinNumberInRotatedArray;
9. 求斐波那契数列第n项  - Fibonacci;
相关：一只青蛙每次可以跳一级或两级台阶，那么到达n级台阶有多少种跳法?
10.输入一个整数，输出其二进制表示中1的个数   - NumberOf1InBinary;
相关：用一条语句判断一个整数是不是2的整数次方 - IsPowerOf2;
相关：输入两个整数m,n ，要改变m的二进制表示中多少位可以得到n - BitsReverseTotal;
11.实现函数 double power(double base,int exponent)实现base的exponent次方，不需要考虑大数问题 - Power;
12. 打印出1到最大的n位数  - Print1ToMaxNDigits;
13. 给定单向链表的头指针和一个节点的指针，实现O(1)删除该节点 - DeleteNodeInList;
14. 调整数组顺序使得奇数位于偶数的前面  - ReorderOddEven;
15. 链表中倒数第k个节点   - KthNodeFromEnd;
相关：求链表的中间节点;
相关：判断一个单链表是否形成了一个环;
16.  反转链表    -- ReverseList；
相关：用递归实现；
17. 合并两个排序的链表 （递归，非递归）-- MergeSortedLists；
18. 判断二叉树B是不是A的子结构   -- SubstructureInTree ;
19. 二叉树的镜像  -- MirrorOfBinaryTree;
20. 顺时针打印矩阵  -- PrintMatrixClockwise ;
21. 包含min函数的栈   -- StackWithMin ;
22. 输入两个整数序列，第一个序列表示栈的压入顺序，判断第二个序列是否为该站的弹出顺序，假设压入栈的所有数字均不相等    -- StackPushPopOrder ;
23. 从上往下打印二叉树,层序遍历   --  LevelTraverseBinaryTree;
24. 判断一个整数数组是否为某二叉搜索树的后序遍历结果，假设输入数组的任意两个数字都不相同      --   SequenceOfBST ;
25. 打印出二叉树中结点和为输入整数的所有路径，从根节点往下一直到叶节点所经过的节点形成一条路径       -- PathInTree;
26. 实现ComplexListNode clone(CompleListNode head)复制一个复杂链表    ---   CopyComplexList ;
27. 将二叉搜索树转换成一个排序的双向链表，不能创建任何新的节点，只能调整树中节点指针     ---  ConvertBinarySearchTree ;
28. 字符串的排列      --  StringPermutation  ;
相关： 求字符数组的子集合   -- ExhaustiveSubset ;
相关： 输入8个数字判断有没有可能把这8个数字放到正方体8个顶点上使得三组对面上4顶点之和相等  ;
相关：8X8 八皇后问题     ;
29. 数组中出现次数超过一半的数字   --  MoreThanHalfNumber;
30. 最小的k个数   -- KLeastNumbers ;
31. 连续子数组的最大和    -- GreatestSubarraySum ;
32. 从1到n整数十进制表示中1出现的次数      -- NumberOf1 ;
33. 给定一个正整数数字，打印出能拼接的所有数字中最小的一个   --  ConstructMinFromIntArray; 
34. 把只包含因子2,3,5的数称作丑数 Ugly Number，求按从小到大顺序的第1500个丑数，习惯上把1当做第一个丑数   -- UglyNumber ;
35. 在字符串中找出第一个只出现一次的字符     --  FirstNotRepeatChar;
相关：输入两个字符串 从第一个字符串中删除在第二个字符串中出现的所有字符         --  StringFilter;
相关：删除字符串中所有重复出现的字符 如输入"goole"则结果是"gole".  -- DeleteRepeatChars ;
相关：如果两个单词出现的字母相同 ，每个字母出现的次数也相同的，则互为变位词      -- AnagramWords ;
36. 求一个数组中逆序对的总数      --   InversePairs;
37. 两个链表的第一个公共节点     -- FirstCommonNodeInLists ;
38. 数字在排序数组中出现的次数         -- NumberKInSortedArr  ;
39. 求二叉树的深度   -- TreeDepth ;
           判断一个二叉树是否是平衡二叉树   ---- IsBalancedTree;
40. 一个整型数组中除了两个数字之外 每个数字都出现了两次 找出这两个只出现一次的数字          --  TwoNumAppearOnce;
简单的是：一个数字只有一个数出现一次，剩下的都出现2次，找出这个数字     -  NumAppearOnce;
41. 题目1：输入一个递增排序的数组和一个数s，在数组中查找两个数使得他们之和为s，输出任意一对即可    -- TwoNumWithSum ;
题目2：打印出所有和为s的连续整数序列（至少含有两个数）            -- ContinuousSeqWithSum ;
42.题目1：输入一个英文句子 翻转句子中单词的书序 但单词内字符顺序不变 为简单起见 标点符号和普通字母一样处理     -- ReverseSentenceByWords;
题目2：实现字符串的左旋操作，即把字符串前面的若干个字符转移到字符串的尾部       -- LeftRotateString;
43.把n个骰子扔在地上，所以骰子朝上一面的点数之和为s，输入n，打印出s所有可能的值出现的概率             --- DicesProbability; 
44. 从扑克牌中随机抽5张牌，判断是否为顺子，2-10位数字本身A=1,J Q K 分别为11 12 13大小王看成任意数字      -- ContinuousCards ;


对员工按年龄排序，时间效率是O(N)  - SortAges;










需要总结：
P54  sizeof(数组)；
P59 字符串常量 字符数组；
P71 二叉树的遍历方式 递归/非递归 实现；
P72 Java中基于红黑树的集合有哪些 ？
P81 熟练掌握各种排序算法
P92 斐波那契数学公式证明？
P108 阅读Double.compare()代码 
P 学习Java8 lambda expression 
体会 pass by value    -- PassByValue;








 
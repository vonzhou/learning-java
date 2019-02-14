package oj.leetcode;

import java.util.*;

/**
 * 71. Simplify Path
 * Created by vonzhou on 2019/2/14.
 */
public class SimplyPath {

    /**
     * AC
     * .. 需要一个出栈的过程, 最后逆序拼接
     * 耗时15ms
     */
    public String simplifyPath(String path) {
        // 使用双端队列模拟栈的行为
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir); // 有效的目录就入栈
        }

        // 使用LinkedList.push 入栈的时候,是在头部插入的, 形成的结果是
        //|栈顶| index = 0
        //|栈底| index = 1
        // 所以直接iterator遍历就可以
        String res = "";
        for (String dir : stack)
            res = "/" + dir + res;

        return res.isEmpty() ? "/" : res;
    }

    /**
     * AC
     * Dequeue 改用 Stack
     */
    public String simplifyPath3(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty())
                stack.pop();
            else if (!skip.contains(dir))
                stack.push(dir);
        }
//        System.out.println(stack);
        // 顺序也要调整
        String res = "";
        ListIterator<String> iter = stack.listIterator(stack.size());
        while (iter.hasPrevious()) {
            res = "/" + iter.previous() + res;

        }

        return res.isEmpty() ? "/" : res;
    }

    /**
     * 行不通!!!
     * 2. 自己的思路:不断替换的思想
     */
    public String simplifyPath2(String path) {
        if (!path.endsWith("/")) {
            path = path + "/";
        }
        path = path.replaceAll("/+", "/");
        path = path.replaceAll("\\./", "");
        return path;

    }

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("/home/", "/../", "/home//foo/", "/a/./b/../../c/", "/a/../../b/../c//.//", "/a//b////c/d//././/..");

        for (String s : inputs) {
//            System.out.println(Arrays.asList(s.split("/")));
            System.out.println(s);
            System.out.println(new SimplyPath().simplifyPath(s));
//            System.out.println(new SimplyPath().simplifyPath3(s));
            System.out.println("--------------");
        }
    }
}

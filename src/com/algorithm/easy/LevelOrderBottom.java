package com.algorithm.easy;

import java.util.*;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom {


    /**
     * 最优代码分析
     * 1.递归实现
     * 2.每次判断数组数量是否小于对应的层数，如果是则new一个数组
     * 3.依次给数组中赋值
     * 4.反转数组
     */
    public List<List<Integer>> levelOrderBottomPre(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrder(result, root, 0);
        Collections.reverse(result);
        return result;
    }

    private void levelOrder(List<List<Integer>> result, TreeNode root, int i) {
        if (root == null) {
            return;
        }
        if (result.size() <= i) {
            result.add(new ArrayList<>());
        }
        result.get(i).add(root.val);
        levelOrder(result, root.left, i + 1);
        levelOrder(result, root.right, i + 1);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> keyMap = new HashMap<>();
        addValue(result, root, keyMap, 1);
        result.remove(0);
        return result;
    }

    public void addValue(List<List<Integer>> result, TreeNode node, Map<Integer, List<Integer>> keyMap, int du) {
        List<Integer> list = null != keyMap.get(du) ? keyMap.get(du) : new ArrayList<Integer>();
        if (null == keyMap.get(du)) {
            result.add(0, list);
            keyMap.put(du, list);
        }
        if (null != node) {
            list.add(node.val);
            addValue(result, node.left, keyMap, du + 1);
            addValue(result, node.right, keyMap, du + 1);
        }
    }

    public static void main(String[] args) {
        new LevelOrderBottom().test();
    }

    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        for (List<Integer> allList : levelOrderBottom(root)) {
            for (Integer eveInt : allList) {
                System.out.print(eveInt + ",");
            }
            System.out.println("");
        }
    }


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
}

package com.algorithm.easy;

import java.util.*;

/**
 * ����һ����������������ڵ�ֵ�Ե����ϵĲ�α����� ��������Ҷ�ӽڵ����ڲ㵽���ڵ����ڵĲ㣬���������ұ�����
 * <p>
 * ���磺
 * ���������� [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * �������Ե����ϵĲ�α���Ϊ��
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class LevelOrderBottom {


    /**
     * ���Ŵ������
     * 1.�ݹ�ʵ��
     * 2.ÿ���ж����������Ƿ�С�ڶ�Ӧ�Ĳ������������newһ������
     * 3.���θ������и�ֵ
     * 4.��ת����
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

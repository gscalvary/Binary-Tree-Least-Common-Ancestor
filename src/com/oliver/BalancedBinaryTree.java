package com.oliver;

import java.util.ArrayList;

public class BalancedBinaryTree<T> {

    private ArrayList<BalancedBinaryTreeNode<T>> treeNodes;

    public BalancedBinaryTree() {

        treeNodes = new ArrayList<BalancedBinaryTreeNode<T>>();
    }

    public void insert(T data) {

        if(data == null) return;

        treeNodes.add(new BalancedBinaryTreeNode<T>(data));
    }

    public ArrayList<BalancedBinaryTreeNode<T>> getChildren(BalancedBinaryTreeNode<T> node) {

        ArrayList<BalancedBinaryTreeNode<T>> children = new ArrayList<BalancedBinaryTreeNode<T>>();

        int size = treeNodes.size();

        for(int i = 0; i < size; i++) {
            if(treeNodes.get(i) == node) {
                int childIndex = 2 * i + 1;
                if(childIndex < size) {
                    children.add(treeNodes.get(childIndex));
                    if(childIndex + 1 < size) {
                        children.add(treeNodes.get(childIndex + 1));
                    } else {
                        children.add(null);
                    }
                } else {
                    children.add(null);
                    children.add(null);
                }
                return children;
            }
        }

        children.add(null);
        children.add(null);
        return children;
    }

    public BalancedBinaryTreeNode<T> getHead() {

        return treeNodes.get(0);
    }

    public BalancedBinaryTreeNode<T> getNode(int i) {

        // Input check.
        if(i < 0 || i >= treeNodes.size()) return null;

        // Return the requested node.
        return treeNodes.get(i);
    }

    public BalancedBinaryTreeNode<T> getParent(BalancedBinaryTreeNode<T> node) {

        // Input check.
        if(node == null || node == getHead()) return null;

        // Iterate through the binary tree, find the input node then calculate the parent node returning it.
        for(int i = 0; i < treeNodes.size(); i++) {
            if(treeNodes.get(i) == node) {
                return treeNodes.get((i - 1)/2);
            }
        }

        // The node is not part of this binary tree, return null.
        return null;
    }
}
package com.oliver;

import java.util.HashSet;

/* A brute force approach that stores the nodes on the path from one node to root and then traverses the path from the
   other node to root checking each node against the ancestors of the first node.  The algorithm returns the first
   matched node which corresponds to the LCA.
   O(h) time and space complexity where h is the height of the binary tree.

   A more efficient approach computes the depth of each node in the tree, traverses towards root from the deepest node
   until it reaches the same depth of the shallower node and then traverses towards root from both nodes in tandem until
   a common ancestor is found (a check is done each step of the way).
   O(h) time but O(1) space where h is the height of the binary tree.
 */

public class LCAComputer<T> {

    private BalancedBinaryTree<T> bt;

    public LCAComputer(BalancedBinaryTree<T> bt) {

        this.bt = bt;
    }

    public BalancedBinaryTreeNode<T> computeLCA(BalancedBinaryTreeNode<T> a, BalancedBinaryTreeNode<T> b) {

        // Check input.
        if(a == null || b == null) return null;
        if(a == b) return a;

        // Compute and store the ancestors of a.
        HashSet<BalancedBinaryTreeNode<T>> aAncestors = new HashSet<BalancedBinaryTreeNode<T>>();
        BalancedBinaryTreeNode<T> parent = a;

        while(parent != null) {
            aAncestors.add(parent);
            parent = bt.getParent(parent);
        }

        // Iterate through the ancestors of b finding and returning the most recent ancestor that is also an ancestor of
        // a.
        parent = b;

        while(parent != null) {
            if(aAncestors.contains(parent)) return parent;
            parent = bt.getParent(parent);
        }

        return null;
    }
}

package com.oliver;

public class Main {

    public static void main(String[] args) {

        BalancedBinaryTree<Integer> bt = new BalancedBinaryTree<Integer>();
        bt.insert(314);
        bt.insert(6);
        bt.insert(6);
        bt.insert(271);
        bt.insert(561);
        bt.insert(2);
        bt.insert(271);
        bt.insert(28);
        bt.insert(0);

        LCAComputer<Integer> lcaComputer = new LCAComputer<Integer>(bt);
        BalancedBinaryTreeNode<Integer> lca = lcaComputer.computeLCA(bt.getNode(5), bt.getNode(8));

        System.out.println("The LCA of " + bt.getNode(5).getData() + " and " + bt.getNode(8).getData() + " is "
                + lca.getData());
    }
}

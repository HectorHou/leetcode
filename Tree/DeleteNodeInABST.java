package com.hm;
//450. Delete Node in a BST
//        DescriptionHintsSubmissionsSolutions
//        Total Accepted: 15376
//        Total Submissions: 42566
//        Difficulty: Medium
//        Contributors:
//        tsipporah5945
//        Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
//
//        Basically, the deletion can be divided into two stages:
//
//        Search for a node to remove.
//        If the node is found, delete the node.
//        Note: Time complexity should be O(height of tree).
//
//        Example:
//
//        root = [5,3,6,2,4,null,7]
//        key = 3
//
//        5
//        / \
//        3   6
//        / \   \
//        2   4   7
//
//        Given key to delete is 3. So we find the node with value 3 and delete it.
//
//        One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
//
//        5
//        / \
//        4   6
//        /     \
//        2       7
//
//        Another valid answer is [5,2,6,null,4,null,7].
//
//        5
//        / \
//        2   6
//        \   \
//        4   7
/**
 * Created by hm on 17-6-6.
 */
public class DeleteNodeInABST {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {
        // if root is null, return null
        if (root == null)
            return null;

        //if root's value equals key, delete it by checking if the left node is null.
        if (root.val == key) {
            if (root.left == null)
                return root.right;
            else {
                changeLeftTree(root);
                return root;
            }
        } else { // if root's value donot equals key
            TreeNode p = root, pre = root;
            //find the parent of the key node
            while (p != null && p.val != key) {
                pre = p;
                if (p.val < key)
                    p = p.right;
                else
                    p = p.left;
            }
            //key node not exists
            if (p == null)
                return root;

            //delete node by checking if the left node is null.
            if (p.left == null && pre.val < p.val)
                pre.right = p.right;
            else if (p.left == null && pre.val > p.val)
                pre.left = p.right;
            else
                changeLeftTree(p);
            return root;
        }
    }

    //find the parent of the max value node in the left tree
    private TreeNode findParentOfMaxNode(TreeNode t) {
        if (t.left.right == null)
            return t;
        t = t.left;
        while (t.right.right != null)
            t = t.right;
        return t;
    }

    //change the key value node's value to the left max node's value
    private void changeLeftTree(TreeNode root) {
        TreeNode t = findParentOfMaxNode(root);
        if (t == root) {
            root.val = root.left.val;
            root.left = root.left.left;
        } else {
            root.val = t.right.val;
            t.right = t.right.left;
        }
    }
}

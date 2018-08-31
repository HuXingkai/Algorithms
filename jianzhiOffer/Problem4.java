package jianzhiOffer;

/**
 * Created by andy on 2018/8/30.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Problem4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root=findTree(pre,in,0,pre.length,0,in.length);
        return root;
    }

    /**
     * 递归寻找树结构
     * @param pre 前序遍历序列
     * @param in  中序遍历序列
     * @param preX 左树的初始位置
     * @param preY 左树的结束位置
     * @param inX  右树的初始位置
     * @param inY  右树的结束位置
     * @return
     */
    public TreeNode findTree(int[] pre, int[] in, int preX, int preY, int inX, int inY) {
        if (preX  > preY||inX>=inY) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preX]);
        //找到根节点在中序遍历序列的位置
        int index = 0;
        for (int i=inX;i<inY;i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }

        root.left=findTree(pre,in,preX+1,preX+index-inX,inX,index);
        root.right=findTree(pre,in,preX+index-inX+1,preY,index+1,inY);
        return root;
    }

    public static void print(TreeNode tree) {
        while (tree != null) {
            System.out.println(tree.val);
            TreeNode left = tree.left;
            TreeNode right = tree.right;
            print(left);
            print(right);
            break;
        }
        return;
    }

    public static void main(String[] args) {
        Problem4 p = new Problem4();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode tree = p.reConstructBinaryTree(pre, in);
        print(tree);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        this.val = x;
    }
}
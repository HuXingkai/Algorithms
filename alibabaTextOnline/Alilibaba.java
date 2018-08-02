package alibabaTextOnline;

/**
 * Created by andy on 2017/7/9.
 * 题目地址：http://blog.csdn.net/shenzhuan7/article/details/62881076
 */
public class Alilibaba {
    private static int sum;

    public static void main(String[] args) {

        //113,215,221  111,222,333,344
        int[] a={113};
        TreeNode rooTreeNode=CreateBinaryTree(a);

        printPaths(rooTreeNode);
        System.out.println(Alilibaba.sum);
    }

    //二叉树结构
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val=val;
        }
    }
    //创建二叉树
    public static TreeNode CreateBinaryTree(int[] data) {
        TreeNode root=new TreeNode(0);
        int len=data.length;
        for (int i = 0; i < len; i++) {
            String s=String.valueOf(data[i]);
            int first=Character.getNumericValue(s.charAt(0));
            int second=Character.getNumericValue(s.charAt(1));
            int val=Character.getNumericValue(s.charAt(2));
            TreeNode cur=new TreeNode(val);
            if(first==1)
                root=cur;
            else if (first==2) {
                if(second==1)
                    root.left=cur;
                else {
                    root.right=cur;
                }

            }else if (first==3) {
                if(second==1)
                    root.left.left=cur;
                else if (second==2) {
                    root.left.right=cur;
                }else if (second==3) {
                    root.right.left=cur;
                }else {
                    root.right.right=cur;
                }
            }else{
                if (second==1) {
                    root.left.left.left=cur;
                }else if (second==2) {
                    root.left.left.right=cur;
                }else if (second==3) {
                    root.left.right.left=cur;
                }else if (second==4) {
                    root.left.right.right=cur;
                }else if (second==5) {
                    root.right.left.left=cur;
                }else if (second==6) {
                    root.right.left.right=cur;
                }else if (second==7) {
                    root.right.right.left=cur;
                }else {
                    root.right.right.right=cur;
                }
            }
        }
        return root;
    }

    //
    public static void printTreePaths(TreeNode root,int[] path,int len){
        if(root==null)return;
        path[len]=root.val;
        //System.out.println(path[len]);
        len++;
        if(root.left==null&&root.right==null){
            //System.out.println(Arrays.toString(path));
            Alilibaba.sum+=Sum(path);
        }else {
            printTreePaths(root.left, path, len);
            printTreePaths(root.right, path, len);
        }
    }

    public static int printPaths(TreeNode root) {
        int[] path=new int[4];
        printTreePaths(root, path, 0);
        return 1;
    }
    public static int Sum(int[] a) {
        int res=0;
        for (int i = 0; i < a.length; i++) {
            res+=a[i];
        }
        return res;
    }
}

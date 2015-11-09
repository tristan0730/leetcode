/**
 * Created by yiyangtan on 8/28/15.
 */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Solutions {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        List<Integer> re = new ArrayList<Integer>();
        List<TreeNode> q1 = new ArrayList<TreeNode>();
        List<TreeNode> q2 = new ArrayList<TreeNode>();
        q1.add(root);
        while(!q1.isEmpty()||!q2.isEmpty()){
            if(!q1.isEmpty()){
                for(int i=0;i<q1.size();i++){
                    TreeNode temp = q1.get(i);
                    re.add(temp.val);
                    if(temp.left!=null){
                        q2.add(temp.left);
                    }
                    if(temp.right!=null){
                        q2.add(temp.right);
                    }
                }
                result.add(new ArrayList<Integer>(re));
                re.clear();

                q1.clear();
            }
            else if(!q2.isEmpty()){
                for(int i=0;i<q2.size();i++){
                    TreeNode temp = q2.get(i);
                    re.add(temp.val);
                    if(temp.left!=null){
                        q1.add(temp.left);
                    }
                    if(temp.right!=null){
                        q1.add(temp.right);
                    }
                }
                result.add(new ArrayList<Integer>(re));
                re.clear();
                q2.clear();
            }
        }
        return result;
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        //if both are empty or none, return null
        if(preorder==null || inorder==null || preorder.length==0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);

        //if length of preorder or inorder is 1, return a TreeNode with this value;
        if(preorder.length==1||inorder.length==1){
            root.val = preorder[0];
            return root;
        }

        //locate first value of preorder in inorder
        int index = 0;
        for(index=0;index<inorder.length;index++){
           if(inorder[index]==preorder[0]) break;
        }

        //divide preorder and inorder for recursion
        //System.out.println("inorder[1]: " + inorder[1]+" preorder[0]: "+preorder[0]+" Index: "+index);
        root.left = buildTree(Arrays.copyOfRange(preorder,1,index+1), Arrays.copyOfRange(inorder,0,index));
        root.right = buildTree(Arrays.copyOfRange(preorder,index+1,preorder.length), Arrays.copyOfRange(inorder,index+1,inorder.length));
        return root;
    }
    public static void main(String [] args){
        int [] preorder = {1,2,4,5,3,6,7};
        int [] inorder = {4,2,5,1,6,3,7};
        TreeNode root = buildTree(preorder,inorder);
        List<List<Integer>> result = levelOrder(root);
        System.out.println("[");
        for(int i=0;i<result.size();i++){
            String temp = "[";
            for(int j=0;j<result.get(i).size();j++){
                temp += Integer.toString(result.get(i).get(j));
                temp +=",";
            }
            temp = temp.substring(0,temp.length()-1);
            temp += "]";
            System.out.println(temp);
        }
        System.out.print("]");
    }
}
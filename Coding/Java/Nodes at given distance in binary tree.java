//https://practice.geeksforgeeks.org/problems/nodes-at-given-distance-in-binary-tree/1#
class Solution
{
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> res = new ArrayList<Integer>();
        dfs(root, target, k, res);
        Collections.sort(res);
        return res;
        
    }
    public static int dfs(Node root, int target, int k, ArrayList<Integer> res) {
        if(root == null) 
            return -1;
        if(root.data == target) {
            nodesAtGivenDistance(root, k, res);
            return 1;   
        }
        int left = dfs(root.left, target, k, res);
        if(left != -1) {
            if(left == k) {
                res.add(root.data);
                return -1;
            }
            else {
                nodesAtGivenDistance(root.right, k - left - 1, res);
                return left + 1;
            }
        }
        else {
             int right = dfs(root.right, target, k, res);
             if(right != -1) {
                 if(right == k) {
                     res.add(root.data);
                     return -1;
                 }
                 else {
                     nodesAtGivenDistance(root.left, k - right - 1, res);
                     return right + 1;
                 }
             }
        }
        return - 1;
    }
    public static void nodesAtGivenDistance(Node root, int k, ArrayList<Integer> res) {
        if(root == null || k < 0) {
            return;
        }
        else if(k == 0) {
            res.add(root.data);
            return;
        }
        else {
            nodesAtGivenDistance(root.left, k - 1, res);
            nodesAtGivenDistance(root.right, k - 1, res);
        }
    }
};
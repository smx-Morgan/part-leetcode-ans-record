

public class week04 {
}
class Solution130 {
    int row,col;
    public void solve(char[][] board) {
        if(board == null || board.length==0){
            return;
        }
        row=board.length;
        col=board[0].length;
        for(int i = 0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='O')board[i][j]='X';
                if(board[i][j]=='-')board[i][j]='O';
            }
        }
        return;
    }
    public void dfs(char[][] board,int i,int j){
        if(i<0||j<0||i>=row||j>=col||board[i][j]!='O'){
            return;
        }
        board[i][j]='-';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}
class Solution538 {
    int num = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root != null){
            convertBST(root.right);

            root.val =root.val + num;
            num = root.val;

            convertBST(root.left);
            return root;
        }
        return null;

    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
      }
  }

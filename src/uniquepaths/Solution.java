package uniquepaths;

public class Solution {
	public int unique = 0;
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.print(s.uniquePaths(2,3));
	}
	public int uniquePaths(int m, int n) {
        permute(m,n);
        return unique;
    }
    public void permute(int m, int n){
         if(m == 1 && n == 1){
            unique ++;
            return;
        }
        if(m == 0 || n == 0){
            return;
        }
        
        permute(m-1,n);
        permute(m,n-1);
    }
}

package zigzagconversion;
import java.util.*;
public class Solution {
	public static void main(String[] args){
		String s = "ABCD";
		int numRows = 2;
		System.out.print(convert(s,numRows));
	}
    public static String convert(String s, int numRows) {
        if(s == null || numRows < 2 || s.length() < 1 || numRows > s.length())
            return s;
        char[][] matrix = new char[numRows][s.length()];
        int row = 0;
        int col = 0;
        boolean down = true;
        boolean up = false;
        for(int i = 0; i < s.length(); i++){
            if(row < numRows && down){
                matrix[row++][col] = s.charAt(i);
            }
            if(row < numRows && up){
                matrix[row--][col++] =s.charAt(i); 
            }
            if(row == numRows){
                down = false;
                up = true;
                row = row - 2;
                col++;
            } 
            if(row == 0){
                up = false;
                down = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int x = 0; x < numRows; x++){
            for(int y = 0; y < s.length(); y++){
                if(matrix[x][y] != 0)
                    sb.append(matrix[x][y]);
            }
        }
        return sb.toString();
    }
}

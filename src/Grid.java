package src;

import java.io.File;


public class Grid {
	private int[][][] grid;
	
	public Grid(int row, int col, int depth){
		grid = new int[row][col][depth];
	}
	
	public String toString(){
		String result = "[";
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				for(int k = 0; k < grid[0][0].length; k++){
					result += grid[i][j][k] + ", ";
				}
			}
		}
		result += "]";
		return result;
	}
	
	public void fill(File input){
		String current = "";
			
	}
}

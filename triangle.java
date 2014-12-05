//Anmol Raina
//By starting at the top of the triangle and moving to adjacent numbers on the row below, find the maximum possible
// total from top to bottom

import java.util.Scanner;
import java.io.*;
import java.util.*;

public class triangle{
	public static int largestSum(int[][] numbers, int check){
		int row = check-1;
		//through recursion
		if(row>=0){				//check for base case
			for(int column=0;column<=row;column++){			//start from the bottom and keep returning new triangle with max sum possible so far
				if(numbers[row+1][column]<numbers[row+1][column+1]){
					numbers[row][column] += numbers[row+1][column+1]; 
				}else{
					numbers[row][column] += numbers[row+1][column];
				}
			}
			return largestSum(numbers, row);
		}
		
		//through iteration
		// while(row>=0){
		// 	for(int column=0;column<=row;column++){		//start from the bottom and add the max of the adjacent columns in i+1th row to ith row
		// 		if(numbers[row+1][column]<numbers[row+1][column+1]){
		// 			numbers[row][column] += numbers[row+1][column+1]; 
		// 		}else{
		// 			numbers[row][column] += numbers[row+1][column];
		// 		}
				
		// 	}
		// 	row--;

		// }

		return numbers[0][0];
	}
	public static void main(String[] args){
		File  fileName =new File("triangle.txt");
		try{
			Scanner file = new Scanner(fileName);
			int[][] numbers = new int[100][100];
			int i = 0;
			int counter = 0;
			while(file.hasNextInt()){
				if (i<100){
					for(int j=0;j<=i;j++){
						counter++;
						numbers[i][j] = file.nextInt();
						}
					i++;
				}
			}
			int maxSum = largestSum(numbers, i-1);
			System.out.println("Max sum possible = "+maxSum);
		}catch(Exception e){
		   System.out.println("Invalid File!!!");
		}    
	}
}
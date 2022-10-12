/**********************************************Exercise 8.35**********************************************/

import java.util.*;

public class maxSquare {
    public static void main(String[] args) {
        System.out.print("Enter: ");
        Scanner input = new Scanner(System.in);
        
        //Data stores max square size(data[0]), 
        //and the start position (X, Y) of max suqare submatrix(data[1], data[2]).
        int[] data = new int[3];
        
        //Get square size.
        data[0] = input.nextInt();
        int[][] number = new int[data[0]][data[0]];
        System.out.println("Enter the matrix row by row: ");
        
        //Get square data from the terminal.
        for (int i = 0; i < data[0]; i++) {
            for (int j = 0; j < data[0]; j++) {
                number[i][j]= input.nextInt();
            }
        }

        //Find max block, get the maxsize and position.
        data = findLargestBlock(number);
        System.out.println("The maximum square submatrix is at (" + data[1] + ", " + data[2] + ") with size " + data[0]);
        input.close();
    }

    public static int[] findLargestBlock(int[][] m) {
        int size = 0;
        int length = m[0].length; //It's a square, so its width = length.
        int[] temp = new int[3];

        //Try to find maximum block.
        //Start from where data = 1.
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int tempSize = 0;
                if (m[i][j] == 1) {
                    tempSize = 0;
                    do {
                        tempSize++;
                    } while(compute(m, i, j, tempSize + 1)); //Judge if the block can be expanded. If not, return the size, position, etc.
                }
                
                //Update maximum block data.
                if (tempSize > size) {
                    temp[0] = tempSize;
                    size = tempSize;
                    temp[1] = i;
                    temp[2] = j;
                }
            }
        }
        return temp;
    }

    public static boolean compute(int[][] m, int x, int y, int size) {
        if (x + size > m[0].length || y + size > m[0].length) {
            return false;
        }
        else {
            for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if (m[i][j] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}

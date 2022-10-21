/******************************9.13******************************/
package exercises;
import java.util.Scanner;

class Location{
	public double maxValue = -65536;
	public int row = 0;
	public int column = 0;
}

public class testLocation {
	public static void main(String[] args) {
		Location L;
		int x, y;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter rows and columns: ");
		x = input.nextInt();
		y = input.nextInt();
		double[][] values = new double[x][y];
		
		System.out.println("Enter the array:");
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				values[i][j] = input.nextDouble();
			}
		}
		input.close();
		
		L = locateLargest(values);
		System.out.println("The location of the largest element is " + L.maxValue + " at (" + L.row
				+ ", " + L.column +").");
	}
	public static Location locateLargest(double[][] a) {
		Location Lo = new Location();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] > Lo.maxValue) {
					Lo.row = i;
					Lo.column = j;
					Lo.maxValue = a[i][j];
				}
			}
		}
		return Lo;
	}
}

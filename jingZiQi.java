import java.util.*;

public class jingZiQi {
    public static void main(String[] args) {
        int[][] position = new int[3][3];
        
        //init: make every position into 0 for blank.
        //position = 1 means player X occupies the position, while position = 2 means player O occupies the position.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                position[i][j] = 0;
            }
        }
        
        int row, col;
        boolean end = false;
        boolean valid = true;
        
        Scanner input = new Scanner(System.in);
        
        while (!end) {
            //Player X's turn.
            do {
                valid = true;
                System.out.print("Enter a row (0, 1, or 2) for player X: ");
                row = input.nextInt();
                System.out.print("Enter a column (0, 1, or 2) for player X: ");
                col = input.nextInt();
                if (position[row][col] != 0) {
                    System.out.println("This position has been occupied! Enter again!");
                    valid = false;
                }
            } while(!valid);
            
            //Player X occupy this specific position.
            position[row][col] = 1;
            showMap(position);
            
            //If Player X win, display message and exit loop.
            if (isEnd(position)) {
                System.out.print("Player X wins!");
                end = true;
                continue;
            }
            
            //Player O's turn.
            do {
                valid = true;
                System.out.print("Enter a row (0, 1, or 2) for player O: ");
                row = input.nextInt();
                System.out.print("Enter a column (0, 1, or 2) for player O: ");
                col = input.nextInt();
                if (position[row][col] != 0) {
                    System.out.println("This position has been occupied! Enter again!");
                    valid = false;
                }
            } while (!valid);
            
            //Player O occupy this specific position.
            position[row][col] = 2;
            showMap(position);

            //If Player O win, display message and exit loop.
            if (isEnd(position)) {
                System.out.println("Player O wins!");
                end = true;
                continue;
            }
        }
        input.close();
    }

    public static void showMap(int[][] position) {
        System.out.println("--------------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("|  " + XorO(i, j, position) + "  ");
            }
            System.out.println("|");
            System.out.println("--------------------");
        }
    }

    public static char XorO(int i, int j, int[][] position) {
        switch (position[i][j]) {
            case 1: return 'X';
            case 2: return 'O';
            default: return ' ';
        }
    }

    public static boolean isEnd(int[][] position) {
        if (position[0][0] != 0) {
            if (position[0][0] == position[1][0] && position[1][0] == position[2][0]) {
                return true;
            }
            if (position[0][0] == position[0][1] && position[0][1] == position[0][2]) {
                return true;
            }
        }
        if (position[1][1] != 0) {
            if (position[0][0] == position[1][1] && position[1][1] == position[2][2]) {
                return true;
            }
            if (position[0][2] == position[1][1] && position[1][1] == position[2][0]) {
                return true;
            }
            if (position[1][1] == position[0][1] && position[0][1] == position[2][1]) {
                return true;
            }
            if (position[1][1] == position[1][0] && position[1][0] == position[1][2]) {
                return true;
            }
        }
        if (position[2][2] != 0) {
            if (position[2][2] == position[2][1] && position[2][1] == position[2][0]) {
                return true;
            }
            if (position[2][2] == position[1][2] && position[1][2] == position[0][2]) {
                return true;
            }
        }
        return false;
    }
}

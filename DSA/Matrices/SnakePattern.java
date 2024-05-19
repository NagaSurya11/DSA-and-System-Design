package DSA.Matrices;

import java.util.ArrayList;

public class SnakePattern {
    // Function to return list of integers visited in snake pattern in matrix.
    static ArrayList<Integer> snakePattern(int matrix[][]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            if(i % 2 == 0) {
                for(int j = 0; j < matrix[i].length; j++) {
                    result.add(matrix[i][j]);
                }
            }else {
                for(int j = matrix[i].length - 1; j >= 0; j--) {
                    result.add(matrix[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int matrix[][] = {{45, 48, 54},
             {21, 89, 87},
             {70, 78, 15}};
        snakePattern(matrix).forEach(i -> {
            System.out.print(i + " ");
        });
    }
}

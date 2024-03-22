package task3;

public class Task3 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3,4 ,5},
                {5, 7, 9,2,1},
                {0, 9, 1,8,7},
                {6,3,6,6,6},
                {99,100,-2,3,1}
        };

        int minElement = findMinOnDiagonal(matrix);
        System.out.println("Минимальный элемент на диагонали: " + minElement);
    }

    public static int findMinOnDiagonal(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            if (i != size - 1 - i) { // Проверка на то , что элемент не находится на пересечии диагоналей
                if (matrix[i][size - 1 - i] < min) {
                    min = matrix[i][size - 1 - i];
                }
            }
        }
        return min;
    }
}

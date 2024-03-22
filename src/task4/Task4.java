package task4;

public class Task4 {

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0},
                {0, 0}
        };

        int layers = 1; // Количество слоев

        int[][] newMatrix = increaseMatrixLayer(matrix, layers);

        // Вывод новой матрицы
        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[0].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] increaseMatrixLayer(int[][] matrix, int layers) {
        int rows = matrix.length + 2 * layers;
        int cols = matrix[0].length + 2 * layers;

        int[][] newMatrix = new int[rows][cols];

        // Заполнение новой матрицы
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Проверяем, находится ли текущая ячейка внутри оригинальной матрицы
                if (i >= layers && i < rows - layers && j >= layers && j < cols - layers) {
                    // Оставляем значения из оригинальной матрицы без изменений
                    newMatrix[i][j] = matrix[i - layers][j - layers];
                } else {
                    // Вычисляем значение для слоев
                    int distanceToBorder = Math.min(Math.min(i, rows - i - 1), Math.min(j, cols - j - 1));
                    newMatrix[i][j] = layers - distanceToBorder;
                }
            }
        }

        return newMatrix;
    }
}
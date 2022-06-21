public class Matrix {

    /**
     * Create a matrix from a String.
     * <p>
     * The string if formatted as follow:
     * - Each row of the matrix is separated by a newline
     * character \n
     * - Each element of the rows are separated by a space
     *
     * @param s The input String
     * @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] lines = s.split("\n");
        int[][] matrix = new int[lines.length][lines[0].split(" ").length];

        for (int i = 0; i < matrix.length-1; i++) {
            String[] value = lines[i].split(" ");
            for (int j = 0; j < value.length; j++) {
                matrix[i][j] = Integer.parseInt(value[j]);
            }
        }
        return matrix;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int[] lines : matrix) {
            for (int value : lines) {
                sum += value;
            }
        }
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] M = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                M[i][j] = matrix[j][i];
            }
        }
        return M;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int [][] outputMatrix = new int[matrix1.length][matrix2[0].length];

        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    outputMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return outputMatrix;
    }
}

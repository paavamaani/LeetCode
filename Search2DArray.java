#https://leetcode.com/problems/search-a-2d-matrix

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = (rows * cols) - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int rmid = mid / cols;
            int cmid = mid % cols;

            if(matrix[rmid][cmid] == target) {
                return true;
            }
            else if(matrix[rmid][cmid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}
class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        // Traverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;

            // Two-pointer approach
            while (left <= right) {
                // Swap and invert at the same time
                int temp = image[i][left] ^ 1;   // invert left
                image[i][left] = image[i][right] ^ 1; // invert right
                image[i][right] = temp;

                left++;
                right--;
            }
        }
        return image;
    }
}

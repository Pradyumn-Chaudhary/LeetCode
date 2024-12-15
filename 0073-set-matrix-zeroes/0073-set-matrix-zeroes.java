class Solution {
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> Itrack = new ArrayList<>();
        ArrayList<Integer> Jtrack = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    Itrack.add(i);
                    Jtrack.add(j);
                }
            }
        }
        for(int i = 0;i<Itrack.size();i++){
            int k = Itrack.get(i);
            int l = Jtrack.get(i);
            for(int m = 0;m<matrix.length;m++){
                matrix[m][l] = 0;
            }
            for(int n = 0;n<matrix[0].length;n++){
                matrix[k][n] = 0;
            }
        }
    }
}
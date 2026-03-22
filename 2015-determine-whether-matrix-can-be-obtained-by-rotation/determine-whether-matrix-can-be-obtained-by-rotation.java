class Solution {

    public boolean check(int[][] mat,int[][] target){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]!=target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){
                int val = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = val;
            }
        }

        int low = 0;
        int high = n-1;
        while(low<high){
            for(int i=0;i<m;i++){
                int val = mat[i][low];
                mat[i][low] = mat[i][high];
                mat[i][high] = val;
            }
            low++;
            high--;
        }
        return mat;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;

        for (int rot = 0; rot < 4; rot++) {
            if (check(mat, target)) {
                return true;
            }
            mat = rotate(mat);
        }

        return false;

    }

}
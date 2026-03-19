class Solution {

    boolean validate(int[] left, int[] right, boolean[] visited, int index) {
        if (visited[index]) {
            return false;
        }
        visited[index] = true;
        boolean l = true;
        if (left[index] != -1) {
            l = validate(left, right, visited, left[index]);
        }
        boolean r = true;
        if (right[index] != -1) {
            r = validate(left, right, visited, right[index]);
        }
        return l && r;
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {

        int parent[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                parent[leftChild[i]]++;
                if (parent[leftChild[i]] > 1) {
                    return false;
                }
            }
            if (rightChild[i] != -1) {
                parent[rightChild[i]]++;
                if (parent[rightChild[i]] > 1) {
                    return false;
                }
            }
        }

        int root = -1;

        for (int i = 0; i < n; i++) {
            if (parent[i] == 0) {
                if (root == -1) {
                    root = i;
                } else {
                    return false;
                }
            }
        }

        if(root==-1){
            return false;
        }

        boolean visited[] = new boolean[n];
        if (validate(leftChild, rightChild, visited, root) == false) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                return false;
            }
        }
        return true;
    }
}
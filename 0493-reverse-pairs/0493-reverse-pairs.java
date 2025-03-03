class Solution {
    public static int divide(int[] arr, int si, int ei) {
        int count = 0;
        if (si < ei) {
            int mid = si + (ei - si) / 2;
            count += divide(arr, si, mid);
            count += divide(arr, mid + 1, ei);
            count += conquer(arr, si, mid, ei);
        }
        return count;
    }

    public static int conquer(int[] arr, int si, int mid, int ei) {
        int idx = 0, idx1 = si, idx2 = mid + 1, count = 0;
        int conquered[] = new int[ei - si + 1];
        while (idx1 <= mid && idx2 <= ei) {
            if (arr[idx1] < arr[idx2]) {
                conquered[idx++] = arr[idx1++];
            } else {
                count += countPair(arr,idx1, mid, idx2);
                conquered[idx++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            conquered[idx++] = arr[idx1++];
        }
        while (idx2 <= ei) {
            conquered[idx++] = arr[idx2++];
        }
        System.arraycopy(conquered, 0, arr, si, conquered.length);
        return count;
    }

    public static int countPair(int[] arr,int idx1, int mid, int idx2) {
        int count = 0;

        while (idx1 <= mid && arr[idx1] <= 2 * arr[idx2]) {
            idx1++;
        }

        if(arr[idx1]>2*arr[idx2]){
        count += mid - idx1 + 1;
        }
        return count;
    }

    public int reversePairs(int[] arr) {
        return divide(arr, 0, arr.length - 1);
    }
}
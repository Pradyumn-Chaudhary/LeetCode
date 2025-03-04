class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx = 0, idx1 = 0, idx2 = 0;
        int conquer[] = new int[nums1.length + nums2.length];
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] < nums2[idx2]) {
                conquer[idx++] = nums1[idx1++];
            } else {
                conquer[idx++] = nums2[idx2++];
            }
        }
        while (idx1 < nums1.length) {
            conquer[idx++] = nums1[idx1++];
        }
        while (idx2 < nums2.length) {
            conquer[idx++] = nums2[idx2++];
        }
        double result = -1;
        if (conquer.length % 2 == 0) {
            int mid = conquer.length / 2;
            result = (conquer[mid] + conquer[mid - 1]) / 2.0; // Take correct middle values
        } else {
            result = conquer[conquer.length / 2]; // Correct middle index for odd length
        }

        return result;
    }
}
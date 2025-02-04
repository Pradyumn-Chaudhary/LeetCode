class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        int arr[] = {intervals[0][0],intervals[0][1]};
        for(int i = 0;i<intervals.length;i++){
            if (arr[1] >= intervals[i][0]) { 
                // Merge overlapping intervals
                arr[1] = Math.max(arr[1], intervals[i][1]);
            } else {
                // Add the previous interval to list and move to next
                list.add(arr);
                arr = intervals[i]; // Create a new reference
            }
        }
        list.add(arr);
        int array[][] = new int[list.size()][2];
        int i = 0;
        for(int[] a : list){
            array[i][0] = a[0];
            array[i][1] = a[1];
            i++;
        }
        return array;
    }
}
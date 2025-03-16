class Solution {
    public static boolean canRepair(int[] ranks, int cars, long time) {
        long carRepaired = 0;
        for (int rank : ranks) {
            carRepaired += (long) Math.sqrt(time / rank);
            if (carRepaired >= cars) return true; // Early exit for efficiency
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        int min = Integer.MAX_VALUE;
        for (int rank : ranks) {
            min = Math.min(min, rank);
        }
        
        long low = 1, high = (long) min * cars * cars;
        while (low < high) {  
            long mid = low + (high - low) / 2; 
            if (canRepair(ranks, cars, mid)) {
                high = mid;  
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

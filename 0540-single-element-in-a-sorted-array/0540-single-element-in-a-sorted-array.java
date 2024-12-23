class Solution {
    public int singleNonDuplicate(int[] arr) {
        if(arr.length == 0){
            return -1;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int low = 0,high = arr.length-1;
        while(low<=high){
            int mid = (low + high) / 2;
            if(mid == 0){
                if(arr[mid]!=arr[mid+1])
                return arr[mid];
            }else if(mid == arr.length-1){
                if(arr[mid]!=arr[arr.length-2])
                return arr[mid];
            }else{
                if(arr[mid] != arr[mid-1] && arr[mid]!=arr[mid+1])
                return arr[mid];
                if(arr[mid]==arr[mid-1]){
                    if(mid%2==0)
                    high = mid - 1;
                    else
                    low = mid +  1;
                }else{
                    if(mid%2!=0)
                    high = mid - 1;
                    else
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
}
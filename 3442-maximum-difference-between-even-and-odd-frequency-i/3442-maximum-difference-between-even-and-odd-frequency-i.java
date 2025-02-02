class Solution {
    public int maxDifference(String s) {
        int n = s.length();
        int odd = 0;
        int even = Integer.MAX_VALUE;
        int arr[] = new int[26];
        for(int i = 0;i < n ;i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<26;i++){
           if(arr[i]>0){
                if(arr[i]%2==0){
                    if(even == Integer.MAX_VALUE){
                        even = arr[i];
                    }
                even = Math.min(even,arr[i]);
            }else{
                 odd = Math.max(odd,arr[i]);
            }
           }
        }
        return odd - even;
    }
}
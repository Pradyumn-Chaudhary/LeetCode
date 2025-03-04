class Solution {
    public boolean checkPowersOfThree(int n) {
        if(n == 0 || n == 2){
            return false;
        }
        if(n == 1){
            return true;
        }
        return checkPowersOfThree(n/3);
    }
}
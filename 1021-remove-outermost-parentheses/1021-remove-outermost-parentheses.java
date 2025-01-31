class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> S = new Stack<>();
        StringBuilder str = new StringBuilder();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            S.push(s.charAt(i));
            if(s.charAt(i)=='(')
            c++;
            else
            c--;
            if(c==0){
                S.pop();
                StringBuilder sb = new StringBuilder();
                while(!S.isEmpty()){
                    sb.append(S.pop());
                }
                sb.deleteCharAt(sb.length()-1);
                sb.reverse();
                str.append(sb);
            }
        }
        return str.toString();
    }
}
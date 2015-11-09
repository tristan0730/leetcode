public class Solution {
    public String longestPalindrome(String s) {
        HashSet<String> set = new HashSet<>();
        if(s==null||s.length()==0) return s;
        String result = s.substring(0,1);
        for(int i=1;i<s.length();i++){
            String p1 = exp(s,i,i);
            String p2 = exp(s,i-1,i);

            if(p1.length()>result.length()){
                result = p1;
            }
            if(p2.length()>result.length()){
                result = p2;
            }
        }
        return result;
    }
    // this expand at a certain index to check longest palindrome at each postion
    public String exp(String s, int l, int r){
        while(l>=0&&r<s.length()){
            if(s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            else{
                break;
            }
        }
        return s.substring(l+1,r);
    }
}
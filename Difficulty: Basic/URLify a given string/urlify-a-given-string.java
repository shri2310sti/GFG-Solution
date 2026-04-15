class Solution {
    String URLify(String s) {
        String res = "";
        for(char c : s.toCharArray()){
            if(c == ' ')
                res += "%20";
            else
                res += c;
        }
        return res;
    }
}
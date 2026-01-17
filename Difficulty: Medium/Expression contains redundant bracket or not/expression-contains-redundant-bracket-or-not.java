class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray())
        {
            if(ch==')')
            {
                int c=0;
                while(!st.isEmpty() && st.peek()!='(')
                {
                    int top=st.pop();
                    if(top=='+' || top=='-'||top=='*'||top=='/')
                        c++;
                }
                if(!st.isEmpty())
                    st.pop();
                if(c==0)
                    return true;
            }
            else
            st.push(ch);
        }
        return false;
        // code here
        
    }
}
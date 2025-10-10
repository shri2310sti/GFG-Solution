class Solution {
  public static int[] count_NGE(int arr[], int indices[]) {
      int queries = indices.length;
      int n = arr.length;
    int[] res=new int[queries];
    int[] ngeCnt=new int[n];
    Stack<Integer> decStack=new Stack<>();
    Stack<Integer> inStack=new Stack<>();
    
    for (int i=n-1;i>=0;i--) {
        while (!inStack.isEmpty() && inStack.peek()>arr[i])
            decStack.push(inStack.pop());
            
        while (!decStack.isEmpty() && decStack.peek()<=arr[i])
            inStack.push(decStack.pop());
            
        if (!decStack.isEmpty())
            ngeCnt[i]=decStack.size();
            
        decStack.push(arr[i]);
    }
    
    for (int q=0;q<queries;q++)
        res[q]=ngeCnt[indices[q]];
        
    return res;
  }
}
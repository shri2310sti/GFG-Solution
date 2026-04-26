class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        // code here
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
       ArrayList<Integer> res = new ArrayList<>();
       int i=0,j=0,k=0;
       while(i<a.length && j<b.length && k<c.length){
           if(a[i] == b[j] && b[j] == c[k]){
              // res.add(a[i]);
               if(res.isEmpty() || res.get(res.size() - 1) != a[i]) {
                    res.add(a[i]);
                }
               i++;
               j++;
               k++;
           }
           else if(a[i]<b[j]) i++;
           else if(b[j]<c[k]) j++;
           else k++;
       }
      return res;
    }
}
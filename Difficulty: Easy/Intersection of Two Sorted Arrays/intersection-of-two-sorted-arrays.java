class Solution {

    // Function to find the intersection of two arrays
    ArrayList<Integer> intersection(int[] a, int[] b) {
        ArrayList<Integer> list =new ArrayList<>();
        int i=0;
        int j=0;
        while (i < a.length && j < b.length) {

        if (a[i] == b[j] )
        {
        if (list.size() == 0 || a[i] != list.get(list.size() - 1)){ 
            list.add(a[i]);
        }
         
            i++;
           j++;
        }
           
        else if(a[i]<b[j]){
            i++;
        }
        else if(a[i]>b[j]){
            j++;
        }
        
 
    }
        return list;

}           
}
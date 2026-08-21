class Solution {

     int transform(String A, String B) {



     if(A.length()!= B.length()){

             return -1;

         }



         int m = 0;

         int n=0;

       char[] a =A.toCharArray();

       char[] b = B.toCharArray();

        Arrays. sort(a);

        Arrays. sort(b);

        if(!Arrays.equals(a, b))return -1;



         int count =0;

         int i=A.length()-1;

         int j =B.length()-1;





         while(i>=0 && j>=0){

             if(A.charAt(i)==B.charAt(j)){

                 i--;

                 j--;

             }else{

                 count++;

                 i--;

             }

         }





         return count;

     }

 }
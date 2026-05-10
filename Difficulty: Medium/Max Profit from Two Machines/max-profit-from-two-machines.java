class Solution {

    public int maxProfit( int x, int y, int[] a, int[] b) {

        int n=a.length;

        Integer[]idx=new Integer[n];

        for(int i=0;i<n;i++){

            idx[i]=i;

        }

    Arrays.sort(idx,(i,j)->Math.abs(b[j]-a[j])-Math.abs(b[i]-a[i]));

    long ans=0;

    for(int i:idx){

        if((a[i]>b[i]&&x>0)||y==0){

            ans+=a[i];x--;

        }else{

            ans+=b[i];y--;

        }

    }

    return(int) ans;

    }

}
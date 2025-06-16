// // User function Template for Java

// class Solution {
//     public int findKRotation(List<Integer> arr) {
//         // Code here
//         int low = 0, high = arr.size() - 1;
        
//         while(low <= high){
//             int mid = (low + high) / 2;
//             if(arr.get(mid) <= arr.get(high)) high = mid;
//             else low = mid + 1;
//         }
//         return low;
//     }
// }


class Solution {
    public int findKRotation(List<Integer> arr) {
        int low = 0, high = arr.size() - 1;

        while (low < high) {
            int mid = (high + low) / 2;

            if (arr.get(mid) <= arr.get(high)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low; // Index of minimum element = rotation count
    }
}

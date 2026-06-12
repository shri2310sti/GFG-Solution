class Solution {
    public boolean kSubstr(String s, int k) {
        
        Map<String,Integer> map=new HashMap<>();
        int i=0;
        int count=0;
        if(s.length()%k != 0){
            return false;
        }
      
        while(i<s.length()){
            String val=s.substring(i, i+k);
            map.put(val, map.getOrDefault(val, 0) + 1); 
            i=i+k;
        }
        
        if((map.size()==2 && map.containsValue(1)) || map.size()<2){
            return true;
        }
        
        return false;
    }
}


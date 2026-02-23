class Solution {
    public boolean hasAllCodes(String s, int k) {
        int need=1<<k;
        Set<String> seen=new HashSet<>();

        for(int i=0;i<=s.length()-k;i++){
            String sub=s.substring(i,i+k);
            seen.add(sub);

            if(seen.size()==need){
                return true;
            }

        }
        return false;

    }
}
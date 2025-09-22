class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxFreq=0;
        for(int freq:map.values()){
            if(freq>maxFreq){
                maxFreq=freq;
            }
        }
        int total=0;

        for(int num:nums){
            if(map.get(num)==maxFreq){
                total++;
            }
        }
        return total;

    }
}
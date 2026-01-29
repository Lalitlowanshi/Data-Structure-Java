class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int [] ans = new int[k];
        int idx = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int i=0; i<k; i++){
            int max = 0;
            int key = 0;
            for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                int value = entry.getValue();

                if(value > max){
                    max = value;
                    key = entry.getKey();
                }
            }
            map.remove(key);
            ans[idx++] = key;
        }
        return ans;
    }
}
        // for(Integer key : map.keySet()){
        //     int value = map.get(key);
        // }

        // for(Integer value : map.values()){
        //     int key = map.get(value);
        // }

class Solution {
    public int maxProduct(int[] nums) {
        int max =Integer.MIN_VALUE;
        int second_largest = Integer.MIN_VALUE;

        for(int i= 0; i< nums.length; i++) {
            if(nums[i] > max) {
                second_largest = max;
                max = nums[i];
            } else if(nums[i] > second_largest){
                second_largest = nums[i];
            }
        }

        return (max -1)*(second_largest -1);
    }
}
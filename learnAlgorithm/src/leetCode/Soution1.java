package leetCode;

public class Soution1 {
    public int[] twoSum(int[] nums, int target) {
int count=0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i]==target){
                ++count;
                for (int j=(i+1); j < nums.length; ++j) {
                    if(0== nums[j]){
                        return new int[]{i, j};
                    }
                }
            }
            int segNum=nums[i];
            int findNum = target - segNum;
            for (int j=(i+1); j < nums.length; ++j) {
                if(findNum== nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Soution1 solution1=new Soution1();
        solution1.twoSum(new int[]{2,7,11,15},9);
    }
}

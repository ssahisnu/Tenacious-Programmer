package dsa_sheet.striver.arrays01;

//https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    static class Solution {
        public void nextPermutation(int[] nums) {
            if(nums.length<=1)
                return;
            //identify the previous index where the increasing order ends
            int index = nums.length-2;
//$$$$$$$ increasing sequence is not just >; should be >= $$$$$$$$$$
            while(index>=0 && nums[index]>=nums[index+1]) {
                index--;
            }

            if(index>=0) {

                int indexOfNextBigElement = nums.length-1;

                while(indexOfNextBigElement>0) {
                    if(nums[indexOfNextBigElement]>nums[index]) {
                        break;
                    }
                    indexOfNextBigElement--;
                }

                swap(nums, index, indexOfNextBigElement);
            }

            reverseList(nums, index+1);
        }

        private void reverseList(int[] nums, int startIndex) {
            if(startIndex>=nums.length-1)
                return;
            int endIndex = nums.length-1;
            while(startIndex<endIndex) {
                swap(nums, startIndex++, endIndex--);
            }
        }

        private void swap(int[] nums, int first, int second) {
            int temp = nums[first];
            nums[first] = nums[second];
            nums[second] = temp;
        }
    }



// 1234      -> 1243 (swap the last sorted pair)

// 1342      -> 1423 (step 1: swap the before element after the increasing order stops(from last), with the next greater val
//                        step 2: reverse the last part after the swap so that it becomes sorted)

// 1324      -> 1342  same as above but step 2 is not needed as one element is in last part

// 4321      -> 1234  same as above step but here step1 swap would not be possible and step 2 would reverse the complete array as swap index+1 is 0
}

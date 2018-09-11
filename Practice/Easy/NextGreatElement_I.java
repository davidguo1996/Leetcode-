package Easy;

import cse131.ArgsProcessor;

public class NextGreatElement_I {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {2, 4};
		int[] nums2 = {1, 2, 3, 4};
		int[] output = new int[nums1.length];
		for (int i = 0; i < nums1.length; ++i) {
			for(int j = 0; j < nums2.length; ++j) {
				
				//find the same element in nums2[]
				
				if (nums1[i] == nums2[j]) {
					
					//check if overflow
					
					if((j == nums2.length - 1) || (nums2[j+1] <= nums1[i]) ){
						output[i] = -1;
					}
					else {
						output[i] = nums2[j+1];
					}
				}
			}
		}
		for (int k = 0; k < output.length; ++k) {
			System.out.print(output[k] + "  ");
		}

	}

}

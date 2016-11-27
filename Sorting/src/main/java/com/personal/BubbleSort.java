package com.personal;

public class BubbleSort {
	//Time complexity O(n) best case   --> sorted input
	// 				  O(n^2) worst case
	//Space complexity : O(1)
	public void advancedBubbleSort(int[] input){
		int isSwapped = 1, nIterations=0;
		for(int j = input.length-1 ; j >= 0 && isSwapped==1; j--,nIterations++){
			isSwapped = 0;
			for(int i = 0;i<= j-1; i++){
				if(input[i] > input[i+1]){
					//swap the elements
					isSwapped = 1;
					int temp = input[i+1];
					input[i+1] = input[i];
					input[i] = temp;
				}
			}
		}
		System.out.println("advsort() : Number of iteraions : "+nIterations);
	}
	//Time complexity O(n^2) best case
	//Space complexity : O(1)
	public void sort(int[] input){
		int niterations = 0;
		for(int j = input.length-1; j >= 0; j--,niterations++){
			for(int i = 0;i<= j-1; i++){
				if(input[i] > input[i+1]){
					//swap the elements
					int temp = input[i+1];
					input[i+1] = input[i];
					input[i] = temp;
				}
			}
		}
		System.out.println("sort() : Number of iteraions : "+niterations);
	}
	public static void main(String[] args){
		int[] input = {1,2,0,3,6,1};
		new BubbleSort().advancedBubbleSort(input);
		for(int i = 0;i < input.length; i++)
			System.out.print(input[i]+ " ");
	}

}

package JAVA;

import java.util.Scanner;

class Puzzle {
    
    // 1. Find Missing Number
    public void findnum(int[] arr, int n) {
        int expectedsum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int num : arr) {
            sum += num;
        } 
        int result = expectedsum - sum;
        System.out.println("The missing number in the array is " + result);
    } 

    // 2. Bubble Sort
    public void sortarr(int[] arr) {
        System.out.print("UnSorted Array : ");
        for (int num : arr) {
            System.out.print(num + " ");
        } 

        // Bubble Sort implementation
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        } 

        System.out.print("\nSorted Array   : ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    } 

    // 3. Linear Search
    public void search(int[] arr) {
        int tofind = 5;
        int index = -1;
        
        for (int i = 0; i < arr.length; i++) {
            if (tofind == arr[i]) {
                index = i;
                break; // Stop searching once we find it!
            } 
        } 

        if (index != -1) {
            System.out.println("The number " + tofind + " is found at index " + index);
        } else {
            System.out.println("Not Found");
        }
    } 

    // 4. Find Largest
    public void largest(int[] arr) {
        // Fix: Initialize to the first element to support negative numbers safely
        int large = arr[0]; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > large) {
                large = arr[i];
            }
        }
        System.out.println("Largest no in the array is " + large); 
    }

    // 5. Find Smallest
    public void smallest(int[] arr) {
        int small = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < small) {
                small = arr[i];
            }
        }
        System.out.println("Smallest no in the array is " + small); 
    } 

    // 6. Two-Sum Pairs
    public void sumpair(int[] arr) {
        boolean foundAnyPair = false;
        int targetsum = 10;
        
        System.out.println("Matching pairs for sum " + targetsum + ":");
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == targetsum) { 
                    System.out.println(arr[i] + " , " + arr[j]);
                    foundAnyPair = true;
                } 
            } 
        }
        
        // Fix: Only print this if the loop finished without finding anything
        if (!foundAnyPair) {
            System.out.println("None of the pairs matched!");
        }
    } 
} 

public class Arrays {
    public static void main(String[] args) {
        System.out.println("---------------- PUZZLE ---------------- ");
        Puzzle p = new Puzzle();
        
        int[] nums = { 1, 2, 3, 4, 6 };
        int k = 6;
        int[] sortnum = { 5, 9, 8, 3, 2, 4 }; 

        Scanner sc = new Scanner(System.in);
        int choice; 

        do {
            System.out.println("\nEnter choice:");
            System.out.println("1. Missing Number");
            System.out.println("2. Sort Array");
            System.out.println("3. Search");
            System.out.println("4. Largest");
            System.out.println("5. Smallest");
            System.out.println("6. Sum Pair");
            System.out.println("7. Exit");
            
            choice = sc.nextInt();
            
            switch (choice) {
                case 1: p.findnum(nums, k); break;
                case 2: p.sortarr(sortnum); break;
                case 3: p.search(sortnum); break;
                case 4: p.largest(sortnum); break;
                case 5: p.smallest(sortnum); break;
                case 6: p.sumpair(sortnum); break;
                case 7: System.out.println("Exited successfully."); break;
                default: System.out.println("Invalid Choice !!");
            } 
        } while (choice != 7); 

        sc.close();
    } 
}
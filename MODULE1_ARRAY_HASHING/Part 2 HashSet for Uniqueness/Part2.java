import java.util.*;
public class Part2{
  /* ✅ DSA Module 1 – Part 2: HashSet for Uniqueness – Practical Reference
 Using this directly in VS Code as a coding + study companion
! Red (!)
? Blue (?)
* Green (*)
^ Yellow (^)
& Pink (&)
~ Purple (~)
todo Mustard (todo)
Grey (//)  (idk why but its just marking it with )


🎯 Learning Targets
  - Master HashSet to check for duplicates or seen elements
  - Know when Set beats brute force


/* 📌 Core Concepts
  - HashSet stores unique, unordered elements
  - Operations (avg time): add(x), contains(x), remove(x), size() = O(1)
 

 🛠 Java Syntax Reference for HashSet

import java.util.*;

Declare HashSet ---> Set<Integer> set = new HashSet<>();
INITALIZE ONE    Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 5, 6, 7));

                2. Use Set.of() (Java 9+)
                    javaSet<Integer> set = Set.of(1, 2, 3, 5, 6, 7); // Immutable

                3. Use Collections.addAll()
                    javaSet<Integer> set = new HashSet<>();
                    Collections.addAll(set, 1, 2, 3, 5, 6, 7);
 Add elements ---> set.add(10);
 Check existence ---> set.contains(10);
 Remove element ---> set.remove(10);
 Get size ---> set.size();
 Loop through set ---> for (int x : set) { ... }
 Clear all elements ---> set.clear();
 Check if empty ---> set.isEmpty();
 Convert array to set ---> for (int n : nums) unique.add(n);
 Convert set to list ---> new ArrayList<>(unique);
 Check if element was newly added ---> set.add(5);


🔍 Pattern Recognition
Use HashSet when:
 Problem says "duplicate"
 Problem says "unique"
 Problem says "seen before"
 Problem says "intersection"
 Problem needs cycle detection
 Problem requires O(1) lookups

 💻 Key LeetCode Problems
  ^Contains Duplicate – https://leetcode.com/problems/contains-duplicate/
  Problem Statement-->Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.*/
  //APPROACH1 Comparing length of set and array
  public static boolean dupchecker(int[] arr){
    Set<Integer> set = new HashSet<>();
    for(int i : arr)set.add(i);
    if(arr.length == set.size() ) return false;
    else return true;
  }
  //Other Approaches ⚫️Sorting and comparing adjacent(can do this) ⚪️Brute force two loops (can do this) 
  //  !⚫️Streams(can't do this as of now 🟥 ) // ! ⚪️Bit Manipulation(can't do this as of now 🟥)

  /* 
  ^ Intersection of Two Arrays – https://leetcode.com/problems/intersection-of-two-arrays/
  Problem Satement-->Given two integer arrays nums1 and nums2, return an array of their intersection. 
  Each element in the result must be unique and you may return the result in any order.
  Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2]
    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [9,4]
    Explanation: [4,9] is also accepted.*/

  public static Integer[] intersector(int[] arr1, int[ ]arr2){
    Set<Integer> set1 =new HashSet<>();
    Set<Integer> set2 =new HashSet<>();
    Set<Integer> sol =new HashSet<>();
    for(int i : arr1) set1.add(i);
    for(int i: arr2) set2.add(i);
    for(int i: set1){
      if(set2.contains(i))sol.add(i);
    }
    Integer[] arr = new Integer[sol.size()];
    arr=sol.toArray(new Integer[0]);
    return arr;
  }
  //OPTIMAL SOLUTION IS WITH RETAINALL 🟥

//^Happy Number – https://leetcode.com/problems/happy-number/
  /*Write an algorithm to determine if a number n is happy.
    Example 1:
    Input: n = 19
    Output: true
    Explanation:
    1^2 + 9^2 = 82
    8^2 + 2^2 = 68
    6^2 + 8^2 = 100
    1^2 + 0^2 + 0^2 = 1
    Example 2:
    Input: n = 2
    Output: false */

    public static boolean mrhappy(int n){
      Set<Integer> seen = new HashSet<>();
      while(n != 1 && !seen.contains(n)){
          seen.add(n);
          n = mr_sqr_smr(n);
      }
      return n == 1;
    } 

    public static int mr_sqr_smr(int n){  
      int sum = 0;
      while(n > 0){
          int dig = n % 10;
          sum += dig * dig;
          n /= 10;
      }
      return sum;
    } 
/*Other APPROACHES include APPROACH🕑 floyds cycle detection(two pointers one is sum of quraes and the other pointer is (sumofsquares)^2)
idea is both the pointers meet at some point after many iterations,it could be after a long time bruh but we in cycle if come across a number
 thats already there we just know that now its a cycle, syntactial stuff here is using do while beacuse both pointers start as n*/
    public static Boolean mrfloyd(int n){
      int slow=n; int fast = n;
      do{
        slow=mr_sqr_smr(slow);
        fast=mr_sqr_smr(mr_sqr_smr(fast));
      }while(slow!=fast);
      return slow==1;
    }

 /*Apprach🕒 so the idea here is we know that there are cycles which are for sad numbers which start from 4 and is a 8 elemnt series
 4 --> 16 --> 37 --> 58 --> 89 --> 145 --> 42 --> 20 --> 4  */
    public static Boolean cyclic(int n){  // ! Synatactical learning is how to intialize sets
      Set<Integer> cycle= Set.of(4,16,37,58,89,145,42,20);
      while(n!=1 && !cycle.contains(n)){
        n=mr_sqr_smr(n);
      }return n==1;
    }

//^First Repeating Element (GFG) – https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
    /*Input: arr[] = {10, 5, 3, 4, 3, 5, 6}
    Output: 5 
    Explanation: 5 is the first element that repeats

    Input: arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10}
    Output: 6 
    Explanation: 6 is the first element that repeats*/
                                                              /*public static Integer cfg(int[] arr){
                                                                Set<Integer> set = new HashSet<>();
                                                                int num=0;
                                                                for(Integer i : arr){
     /*this code is finding the last repeating elemnt             if(!set.contains(i)){
    /*also other thing is output depends on the order after       set.add(i);
    /*the first repeating elemnts                                 num=i;
                                                                  }
                                                                }return num;
                                                              } */
    public static int CFGer(int[] arr){
      Set<Integer> set= new HashSet<>();
      int index=-1;
      for(int i= arr.length -1;i>0;i--){
        if(!set.contains(arr[i])){
          set.add(arr[i]);
        }
        else{
          index=i;
        }
      }return index;
    }

 /*🧠 Thinking Exercises
  Why is HashSet better than nested loops for duplicate detection? -Hashset is a test of uniqueness and also it checks existence in contant time
  What does add() return if element is already present?
  How would you detect a loop using a Set? simply loose a loop and check if already present
  Can a Set be used to check if two arrays are permutations?convert both o fthem to sets and compare them but the problem is about the duplicates , so hash set could be a problem but this need to be explored more not sure ATM

🧩 Optional Problems
  // ^ Longest Consecutive Sequence – https://leetcode.com/problems/longest-consecutive-sequence/
  Input: nums = [100,4,200,1,3,2]
  Output: 4
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
  Example 2:

  Input: nums = [0,3,7,2,5,8,4,6,0,1]
  Output: 9 */
  public static int consecutive(int[] arr){
    Set<Integer> set =new HashSet<>();
    
    for(int i=0;i<arr.length;i++){
      if(!set.contains(arr[i])){     //~ everything from array added to hashset initially
        set.add(arr[i]);
      }
    }
    int maxcount=0;     //~ scope of this should be global becuase we will returning this
    for(int num:set){
      if(!set.contains(num-1)){
        int current=num;      
        int count =1;
        while(set.contains(current)){
          count++;
          current++;
        }
        maxcount=Math.max(count,maxcount);
      }
    }return maxcount;
  }
  //^ Missing Number – https://leetcode.com/problems/missing-number/   
  // ~ one approach is to use the sum of first n natural numbers
  // ~ other is hashset , we make ahashset and then a for loop and check if set contains i , if not return i 
  public static int finder(int[] arr){
    Set<Integer> set= new HashSet<>();
    for(int i: arr){
      set.add(i);
    }
    for(int i=0;i<arr.length+1;i++){
      if(!set.contains(i)) return i;
    }return -1;

  }
public static void main(String[] args){
    //int[] arr ={1,2,3};
    int[] q= {3,7,2,6,43,9,91,455,92};
    int mo= 19;
    // System.out.println(dupchecker(arr));
    //Integer[] moh = intersector(arr, q);
    //System.out.println(Arrays.toString(moh));
    System.out.println(consecutive(q));

}
} 

import java.util.*;
public class MODULE1 {/*✅ DSA Module 1 – Part 1: Array Basics + Brute Force Thinking – Mastery Checklist
🔹 🧠 THEORY & UNDERSTANDING

📌 Array Concepts
 I understand what an array is: a fixed-size, index-based collection.
 I know arrays store data in contiguous memory.
 I understand the difference between Array, ArrayList, and LinkedList in Java.
 I can explain the time complexities:
 Access → O(1)
 Insertion/Deletion → O(n) (mid-point)
 Traversal → O(n)
 I can explain what happens if I try to access an index out of bounds.

🔍 Visual & Analogies
 I can visualize arrays as a row of boxes in memory.
 Real-life analogy: Arrays are like mailboxes or numbered lockers — fast if you know the index.
 I can explain why arrays are faster than linked lists for access.

🔹 🛠️ SKILLS & SYNTAX
🧾 Traversal & Indexing
 I can traverse arrays with:

 for (int i = 0; i < arr.length; i++)

 For-each loop----->for (int x : arr)

 Reverse loops: for (int i = arr.length - 1; i >= 0; i--)
*/

// I can write a loop that:

 //Finds max or min
    public static int mrmax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

// Sums all elements
    public static int mrsumer(int[] arr){
        int s=0;
        for(int x : arr){
            s+=x;
        } return s;
    }
 //Reverses an array in-place
    public static int[] reverser(int[] arr){
        int temp= 0;
        int i=0;
        int j = arr.length-1;
        while(i<j){
            temp= arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }return arr;
    }
/* 
📎 Basic Java Array Syntax
 Declare array with size: int[] arr = new int[5];

 Declare array with values: int[] arr = {1, 2, 3};

 Access elements via arr[i] safely

🔹 🧪 BRUTE FORCE THINKING
🧠 Concepts
 I know what "brute force" means: trying all possible combinations.

 I can identify problems where brute force is acceptable (small constraints).

 I understand when brute force is inefficient (nested loops = O(n²) or worse).

 I can write nested loops and keep track of multiple indices (i, j).

🧮 Problem Breakdown
 I can break down a problem into:

 Inputs

 Outputs

 Constraints

 Sample dry run

🔹 💻 PRACTICE PROBLEMS (Brute Force Only)
✅ Warm-ups
 Print all elements in an array */
    public static void printer(int[] arr){
        for(int y : arr){
            System.out.println(y);
        }
    }

 //Find maximum and minimum element 
// already covered above 

 //Calculate sum and average of array
    public static int summer(int[] arr){
        int sum =0;
        int avg=0;
        for(int a : arr){
            sum+=a;

        }return sum;
    }
 //Reverse an array covered above

//✅ Brute Force Interview Starters
 //Two Sum (Brute Force) – Try all pairs nums[i] + nums[j] == target 
    public static int[] twosumer(int[] arr,int target){
        //for now we gonna go for brute force
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+ arr[j]==target)return new int[]{i,j};
            }
        }return new int[]{-1,-1};
    }
    

 //Running Sum of 1D Array – Add elements progressively
    public static int[] progsumer(int[] arr){
        for(int i =1; i< arr.length;i++){
            arr[i]=arr[i]+arr[i-1];
        }
        return arr;
    }

 //Count Even Numbers in Array
    public static int evencounter(int[] arr){
        int counter=0;
        for(int a: arr){
            if(a%2==0) counter+=1;

        }return counter;
    }
 //Find the Difference of Two Arrays (compare each element)
    public static int[] mrcomparer(int[] arr1, int[] arr2){
        int l= arr1.length;
        int[] sol= new int[l];
        for(int i=0;i<l;i++){
            sol[i]=Math.abs(arr1[i]-arr2[i]);
        }return sol;
    }

/*🔹 ✏️ THINKING EXERCISES (No Code Needed)
 What is the second-largest element? How would you find it?
 Answer)sort and last second term 

 How would you check if an array is sorted?
Answer)if ascending arr[i]<arr[i+1]  & vice versa for descending 

 Can you remove duplicates without using extra memory?
Answer)no idea intitallly from intution 

 What is the time complexity of reversing an array? Of printing it?

🔹 🧰 DEBUGGING & DRY RUNS
 I can manually simulate a loop on paper or in my head.
i try 
 I can track variables like i, j, sum, or max during a loop.
kinda yes 
 I avoid off-by-one errors in loops (i < arr.length vs i <= arr.length).
shit ton of errrors but i eill debug them mfker
🔹 📦 OPTIONAL CHALLENGES
 Write a brute force function to check if two arrays are permutations of each other. */
//APPROACH 1 we can sort both the arrays and then if compare
     public static boolean permchecker(int[] arr1, int[] arr2){
        if(arr1.length!= arr2.length) return false;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i =0; i<arr1.length;i++){
            if(arr1[i]!=arr2[i]) return false;
        }return true;
     }
    
/*APPROACH 2 what we gonna do is we will have a arr2checker array which will be an array of 
booleans and by default all the elements will be false 
ALSO when we compare certain boolean we can do this !mohit instead of check--> mohit==false
*/
public static boolean brutechecker(int[] arr1,int[] arr2){
    if(arr1.length != arr2.length) return false;
    boolean[] visited =new boolean[arr2.length];
    for(int i=0;i<arr1.length;i++){
        boolean found= false;
        for(int j=0; j<arr2.length;j++){
            if(arr1[i]==arr2[j] && !visited[j]){
                visited[j]=true;
                found = true;
                break;
            } 
        }
        if (!found) return false;
    }
    return true;
 }
// Implement left/right array rotation (brute force style).
public static int[] leftrotater(int[] arr){
    int head= arr[0];
    for(int i =0;i<arr.length-1;i++){
        arr[i]=arr[i+1];
    }
    arr[arr.length-1]=head;
    return arr;
}
// using a helper method 
public static int[] easyleftrotater(int[] arr, int k){
    int n =arr.length;
    k=k%n;
    for(int i =0; i< k; i++ ){
        leftrotater(arr);
    }return arr;
}
//APPROACH2: now we need to do this without a helper method , we will use a 
public static int[] lrotater(int[] arr, int k){
    
    int n = arr.length;
    k=k%n;
    int[] temp= new int[n];
    for(int i =0;i<n-k;i++){
        temp[i]=arr[k+i];
    }
    for(int i=0;i<k;i++){
        temp[n-k+i]=arr[i];
    }
    return temp;
}
//🟥 need to do rrotate and also the third approach revrsal algorithm

//Solve "Find Second Max" without sorting or using a second loop.
public static int secmaxer(int[] arr){
    int max=Integer.MIN_VALUE, secmax= Integer.MIN_VALUE;
    for(int i=0;i<arr.length;i++){
        if(arr[i]>max){
            secmax=max;
            max=arr[i];
        }
        if(arr[i]<max && arr[i]>secmax){
            secmax=arr[i];
        }
    }return secmax;
}

/*🔹 🚨 COMMON MISTAKES TO AVOID
 Forgetting to initialize variables (e.g., int max = Integer.MIN_VALUE)

 Using <= instead of < in loops

 Confusing arr.length with arr[arr.length]

 Modifying the array while traversing it (unless you know how)

🔹 📖 SUMMARY NOTES (Create these yourself)
 Array definition and properties

 Java syntax cheatsheet

 Brute force patterns: what they look like, when to avoid

 Real-world examples of arrays (locker system, bookshelf, CPU registers)

✅ You're Ready to Move On When:
 You can solve basic array problems without copying codes

 You can reason about nested loops and what they do

 You recognize when brute force will be too slow (O(n²))

 You've practiced at least 5–8 brute force problems

 You can teach this part to someone else
x
*/

public static void main(String[] args) {
    int[] arr = {1, 2,3,21,19};
    int[] q={2,1,3};
    System.out.print(secmaxer(arr));
    //when you want to print an array as string
    //int[] result=lrotater(arr,2);
   //System.out.println(Arrays.toString(result)); 
}
}

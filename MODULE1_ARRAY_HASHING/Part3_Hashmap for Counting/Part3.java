/*
===========================
DSA Module 1 – Part 3: HashMap for Counting & Frequency Maps
Enhanced Syntax Snippets + Theory + Curated Problems
===========================

Core Java Imports
import java.util.*;         // HashMap, List, Arrays, PriorityQueue, etc.

1) HashMap Basics
Map<KeyType,ValueType> map       = new HashMap<>();                         // declare
map.put(key, val);                                                         // insert/update
ValueType/Datatype v = map.get(key);                                      // retrieve (null if missing)
ValueType  vDef = map.getOrDefault(key, defaultVal);                     // safe retrieve
map.remove(key);                                                        // delete
map.containsKey(key);                                                  // existence check
for (Map.Entry<K,V> e : map.entrySet()) { … }                         // iterate entries
map.replace(key, oldVal, newVal);                                    // conditional replace

2) computeIfAbsent / computeIfPresent / merge
map.computeIfAbsent(key, k -> new ArrayList<>())                       // lazy init for grouping
   .add(element);
map.computeIfPresent(key, (k,v) -> v + delta);                         // update existing only
map.merge(key, 1, Integer::sum);                                      // add-or-increment count

3) putIfAbsent
map.putIfAbsent(key, initialValue);                                   // set default if missing

4) StringBuilder (heavy string ops)
StringBuilder sb = new StringBuilder();
sb.append(strOrChar).append(other);
String result    = sb.toString();                    // efficient concat

5) Arrays & Collections Helpers
Arrays.sort(arr);                                    // primitive array sort
Arrays.sort(objArr);                                 // object array sort
Collections.addAll(coll, e1, e2, e3);                // bulk add
List<T> list = Arrays.asList(e1, e2, e3);            // fixed-size view

6) List Manipulation
List<Integer> list2 = new ArrayList<>(list);         // mutable copy
Collections.frequency(list, element);                // count occurrences

7) PriorityQueue for Top-K
PriorityQueue<T> pq = new PriorityQueue<>(
    (a,b) -> Integer.compare(freqMap.get(a), freqMap.get(b))
);
pq.offer(elem);  pq.poll();  pq.peek();              // min-heap by freq

8) Character ↔ Numeric
char c = s.charAt(i);
int  d = c - '0';                                     // char to digit
int  dv = Character.getNumericValue(c);

9) Prefix-Sum Pattern
Map<Integer,Integer> prefixCount = new HashMap<>();
int sum = 0; prefixCount.put(0,1);
for (int x: nums) {
  sum += x;
  count += prefixCount.getOrDefault(sum - target,0);
  prefixCount.put(sum, prefixCount.getOrDefault(sum,0)+1);
}

10) Stream to Map (Optional – advanced)
// Map<T,Long> freq = list.stream()
//    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

===========================
Curated Problems (Basic → Advanced)
===========================

1.  Valid Anagram
2.  Ransom Note
3.  Find the Difference
4.  Majority Element
5.  Contains Duplicate
6.  Find All Duplicates in an Array
7.  Top K Frequent Elements
8.  Group Anagrams
9.  Isomorphic Strings
10. Longest Substring with At Most K Distinct
11. Find All Anagrams in a String
12. Subarray Sum Equals K
13. Count Number of Nice Subarrays
14. Minimum Window Substring
15. Longest Consecutive Sequence
16. Split Array into Consecutive Subsequences

===========================
Study Tips:
– Choose the right snippet before coding.
– Practice map.merge for counts, computeIfAbsent for grouping.
– Remember hash collisions are rare but chain via buckets.
– Pre-size large maps: new HashMap<>(initialCapacity).
– Write out small dry runs of count updates on paper.
===========================
*/

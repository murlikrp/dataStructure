package com.practice.ds.lrucache;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Create LRUCache class as given below:
1. LRUCache (int capacity): Initialize the LRU Cache with the positive capacity. No keys should be present in the cache initially.
2. int get(int key): return the value of key, if it exists. Otherwise return -1.
3. void put (int key, int value) : Update value of key if key exists. Otherwise add the key-value pair to the cache. If number of keys exceeds the capacity from this operation, evict the lease recently used key.

Note: Any key that is accessed for a valid get() OR put() operation can be considered as recently used key

Write java program. Implement method or function with name ‘solve’. The method accepts following parameters:
1. N is of type int
2. Ar is of type List<String>
Return List<Integer>*/


public class Main {
	
	public static List<Integer> solve(int N, List<String> ar) {
		List<Integer> result = new ArrayList<>();
		LRUCache cache = new LRUCache(N);
		for(String operation: ar) {
			String[] tokens = operation.split(" ");
			String op = tokens[0];
			int key = Integer.parseInt(tokens[1]);
			
			if(op.equals("get")) {
				result.add(cache.get(key));
			} else if(op.equals("put")) {
				int value = Integer.parseInt(tokens[2]);
				cache.put(key, value);
			}
		}
		return  result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 2; 
		List<String> ar = Arrays.asList(
				"put 1 1",
				"put 2 2",
				"get 1",
				"put 3 3",
				"get 2",
				"put 4 4",
				"get 1",
				"get 3",
				"get 4"
				);
		List<Integer> result = solve(N, ar);
		System.out.println(result);

	}

}

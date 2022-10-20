package com.ikhokha.techcheck;

import java.util.Map;

public class CommentAnalyzer {

	public void occurrences(Map<String, Integer> countMap, String key) {

		countMap.putIfAbsent(key, 0);
		countMap.put(key, countMap.get(key) + 1);
	}

}

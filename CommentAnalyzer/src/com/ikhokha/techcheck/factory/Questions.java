package com.ikhokha.techcheck.factory;

import java.util.Map;

import com.ikhokha.techcheck.CommentAnalyzer;
import com.ikhokha.techcheck.Metrics;

public class Questions extends CommentAnalyzer implements Metrics {
	public static final String GET_QUESTIONS = "Questions";

	@Override
	public void metricsMap(Map<String, Integer> resultsMap, String lineReader) {
		if (lineReader.toLowerCase().contains("?")) {

			occurrences(resultsMap, "QUESTIONS");

		}
	}
}

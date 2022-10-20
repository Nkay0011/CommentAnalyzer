package com.ikhokha.techcheck.factory;

import java.util.Map;

import com.ikhokha.techcheck.CommentAnalyzer;
import com.ikhokha.techcheck.Metrics;

public class Spam extends CommentAnalyzer implements Metrics {
	public static final String GET_SPAM = "Spam";

	@Override
	public void metricsMap(Map<String, Integer> resultsMap, String lineReader) {
		if (lineReader.toLowerCase().contains("https://") || lineReader.toLowerCase().contains("//www")) {

			occurrences(resultsMap, "URL_SPAM");
		}

	}

}

package com.ikhokha.techcheck.factory;

import java.util.Map;

import com.ikhokha.techcheck.CommentAnalyzer;
import com.ikhokha.techcheck.Metrics;

public class ShorterThan15 extends CommentAnalyzer implements Metrics {
	public static final String GET_SHORT_COMMENTS = "ShorterThan15";

	@Override
	public void metricsMap(Map<String, Integer> resultsMap, String lineReader) {
		if (lineReader.length() <15){
			occurrences(resultsMap, "SHORTER_THAN_15");
		}
	}

}

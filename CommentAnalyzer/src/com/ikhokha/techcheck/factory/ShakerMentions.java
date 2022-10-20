package com.ikhokha.techcheck.factory;

import java.util.Map;

import com.ikhokha.techcheck.CommentAnalyzer;
import com.ikhokha.techcheck.Metrics;

public class ShakerMentions extends CommentAnalyzer implements Metrics {
	public static final String GET_SHAKER_MENTIONS = "ShakerMentions";

	@Override
	public void metricsMap(Map<String, Integer> resultsMap, String lineReader) {
		if (lineReader.toLowerCase().contains("shaker")) {

			occurrences(resultsMap, "SHAKER_MENTIONS");
		}

	}

}

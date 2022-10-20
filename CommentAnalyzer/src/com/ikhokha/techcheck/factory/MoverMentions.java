package com.ikhokha.techcheck.factory;

import java.util.Map;

import com.ikhokha.techcheck.CommentAnalyzer;
import com.ikhokha.techcheck.Metrics;

public class MoverMentions extends CommentAnalyzer implements Metrics {
	public static final String GET_MOVER_MENTIONS = "MoverMentions";

	@Override
	public void metricsMap(Map<String, Integer> resultsMap, String lineReader) {
		if (lineReader.toLowerCase().contains("mover")) {

			occurrences(resultsMap, "MOVER_MENTIONS");
		}

	}

}

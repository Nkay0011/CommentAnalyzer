package com.ikhokha.techcheck.factory;

import com.ikhokha.techcheck.Metrics;

public class MetricsFactory {

	public Metrics returnMetrics(String metrics) {
		if (metrics == null || metrics.isEmpty()) {
			return null;
		}
		switch (metrics) {
		case ShorterThan15.GET_SHORT_COMMENTS:
			return new ShorterThan15();

		case MoverMentions.GET_MOVER_MENTIONS:
			return new MoverMentions();

		case ShakerMentions.GET_SHAKER_MENTIONS:
			return new ShakerMentions();

		case Questions.GET_QUESTIONS:
			return new Questions();

		case Spam.GET_SPAM:
			return new Spam();

		default:
			throw new IllegalArgumentException("Unexpected value: " + metrics);
		}

	}
}

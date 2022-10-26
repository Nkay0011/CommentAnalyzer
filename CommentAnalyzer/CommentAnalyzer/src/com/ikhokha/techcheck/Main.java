package com.ikhokha.techcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ikhokha.techcheck.factory.Controller;
import com.ikhokha.techcheck.factory.MetricsFactory;
import com.ikhokha.techcheck.factory.MoverMentions;
import com.ikhokha.techcheck.factory.Questions;
import com.ikhokha.techcheck.factory.ShakerMentions;
import com.ikhokha.techcheck.factory.ShorterThan15;
import com.ikhokha.techcheck.factory.Spam;

public class Main {

	public static void main(String[] args) {

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		MetricsFactory metricsFactory = new MetricsFactory();
		Controller controller = new Controller();
		Map<String, Integer> resultsMap = new HashMap<>();

		File docPath = new File("CommentAnalyzer/docs");
		File[] files = docPath.listFiles((d, n) -> n.endsWith(".txt"));

		for (File file : files) {

			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

				String line = null;
				while ((line = reader.readLine()) != null) {
					executorService.execute(controller);
					Metrics moverMentions = metricsFactory.returnMetrics(MoverMentions.GET_MOVER_MENTIONS);
					moverMentions.metricsMap(resultsMap, line);

					Metrics shakerMentions = metricsFactory.returnMetrics(ShakerMentions.GET_SHAKER_MENTIONS);
					shakerMentions.metricsMap(resultsMap, line);

					Metrics spam = metricsFactory.returnMetrics(Spam.GET_SPAM);
					spam.metricsMap(resultsMap, line);

					Metrics shortComments = metricsFactory.returnMetrics(ShorterThan15.GET_SHORT_COMMENTS);
					shortComments.metricsMap(resultsMap, line);

					Metrics questions = metricsFactory.returnMetrics(Questions.GET_QUESTIONS);
					questions.metricsMap(resultsMap, line);
				}

			} catch (FileNotFoundException e) {
				System.out.println("File not found: " + file.getAbsolutePath());
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("IO Error processing file: " + file.getAbsolutePath());
				e.printStackTrace();
			}
			System.out.println("File Processed : " + file.getName());
		}

		System.out.println("RESULTS\n=======");
		resultsMap.forEach((k, v) -> System.out.println(k + " : " + v));
		executorService.shutdown();
	}

}

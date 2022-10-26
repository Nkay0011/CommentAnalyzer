package com.ikhokha.techcheck;

import com.ikhokha.techcheck.factory.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommentAnalyzer {


	public void occurrences(Map<String, Integer> countMap, String key) {

		countMap.putIfAbsent(key, 0);
		countMap.put(key, countMap.get(key) + 1);
	}

public void analyze() {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    MetricsFactory metricsFactory = new MetricsFactory();
    Controller controller = new Controller();
    Map<String, Integer> resultsMap = new HashMap<>();

    File docPath = new File("CommentAnalyzer/docs");
    File[] files = docPath.listFiles((d, n) -> n.endsWith(".txt"));

    assert files != null;
    for (File file : files) {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
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
}}
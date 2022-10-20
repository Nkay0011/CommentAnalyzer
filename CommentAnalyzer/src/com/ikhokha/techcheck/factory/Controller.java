package com.ikhokha.techcheck.factory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Controller implements Runnable {

	@Override
	public void run() {

		File docPath = new File("CommentAnalyzer/docs");
		File[] files = docPath.listFiles((d, n) -> n.endsWith(".txt"));

		for (File file : files) {
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			} catch (IOException e) {

				e.printStackTrace();
			}

		}

	}
}

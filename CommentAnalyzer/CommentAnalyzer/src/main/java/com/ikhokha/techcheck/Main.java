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

        CommentAnalyzer commentAnalyzer = new CommentAnalyzer();
        commentAnalyzer.analyze();
    }

}

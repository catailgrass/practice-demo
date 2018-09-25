package com;

import org.apache.spark.streaming.kafka.KafkaUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.spark.SparkConf;
import org.apache.spark.streaming.kafka.KafkaUtils;
import org.apache.spark.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}

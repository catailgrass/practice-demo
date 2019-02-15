package com.test;

import org.apache.spark.SparkConf;
import org.apache.spark.streaming.kafka.KafkaUtils;
import org.junit.Test;
import org.apache.spark.*;
import org.apache.spark.api.java.function.*;
import org.apache.spark.streaming.*;
import org.apache.spark.streaming.api.java.*;
import scala.Tuple2;
public class SparkTest {
    @Test
    /**
     * Consumes messages from one or more topics in Kafka and does wordcount.
     *
     * Usage: JavaKafkaWordCount <zkQuorum> <group> <topics> <numThreads>
     *   <zkQuorum> is a list of one or more zookeeper servers that make quorum
     *   <group> is the name of kafka consumer group
     *   <topics> is a list of one or more kafka topics to consume from
     *   <numThreads> is the number of threads the kafka consumer should use
     *
     * To run this example:
     *   `$ bin/run-example org.apache.spark.examples.streaming.JavaKafkaWordCount zoo01,zoo02, \
     *    zoo03 my-consumer-group topic1,topic2 1`
     */
    public void testConn() {
//        https://blog.csdn.net/xiesq5112/article/details/78088543/
        SparkConf sc = new SparkConf();
        sc.setAppName("Name").setMaster("local[2]");
        sc.set("es.nodes", "127.0.0.1");
        sc.set("es.index.auto.create", "true");
        sc.set("es.mapping.id", "id");
        sc.set("es.port", "9200");
// Create a local StreamingContext with two working thread and batch interval of 3 second
//        SparkConf conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount");
//        JavaStreamingContext jssc = new JavaStreamingContext(sc, Durations.seconds(3));

        //设置kafka配置信息，KafkaUtils.createDirectStream(）方法读取信息得到 JavaPairDStream< String,String>对象dStream。
//        JavaPairDStream<String, String> dStream = KafkaUtils.createDirectStream(jssc,Spa);
        //dStream.mapToPair()解析kafka数据并封装成JavaPairDStream< String, 自定义实体> entityDStream对象。
        //
        //entityDStream.transform()将数据转化为JavaDStream dataDStream方便写入ES。
        //
        //接着将数据写入ES，JavaEsSparkStreaming.saveToEs(dataDStream, “索引名”);
        //
        //最后启动和关闭对象JavaStreamingContext jssc

//        try {
//            jssc.start();
//            jssc.awaitTermination();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            jssc.close();
//        }

    }
}

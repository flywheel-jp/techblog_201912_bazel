// src/main/scala/jp/flywheel/WordCount.scala

package jp.flywheel

import org.apache.spark.sql.{Dataset, Row, SparkSession}
import org.apache.spark.sql.functions.{explode, col, count, split}

object WordCount {
  def main(args: Array[String]): Unit = {
    val inputTextFilePattern = args(0)
    val outputPath = args(1)
    val spark = SparkSession.builder.appName("WordCount").getOrCreate
    try {
      val textDF = spark.read.text(inputTextFilePattern)
      val wordCountDF = countWords(textDF)
      wordCountDF
        .repartition(1)
        .sortWithinPartitions("word")
        .write
        .csv(outputPath)
    } finally {
      spark.close
    }
  }

  def countWords(textDF: Dataset[Row]): Dataset[Row] =
    textDF
      .select(explode(split(col("value"), " ")).alias("word"))
      .filter(col("word").isNotNull)
      .filter(col("word").notEqual(""))
      .groupBy(col("word"))
      .agg(count(col("word")).alias("count"))
}

// src/test/scala/jp/flywheel/WordCountTest.scala

package jp.flywheel

import org.apache.spark.sql.Row
import org.apache.spark.sql.test.SharedSparkSession
import org.apache.spark.sql.types.{DataTypes, StructField, StructType}
import org.scalatest.{FunSuite, Matchers}

class WordCountTest extends FunSuite with Matchers with SharedSparkSession {
  test("countWords") {
    val rows = Seq(
      Row("word1 word2 word3"),
      Row("word1 word2"),
      Row("word2 word3"),
      Row("   word3   word4   ")
    )
    val schema = StructType(Seq(StructField("value", DataTypes.StringType)))
    val textDF =
      spark.createDataFrame(spark.sparkContext.parallelize(rows), schema)
    WordCount.countWords(textDF).collect should contain theSameElementsAs Seq(
      Row("word1", 2L),
      Row("word2", 3L),
      Row("word3", 3L),
      Row("word4", 1L)
    )
  }
}

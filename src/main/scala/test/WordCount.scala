package test

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}


/**
  * @author luojun
  * @create 2021-08-26 22:15
  */
object WordCount {
    def main(args: Array[String]): Unit = {
        val env: ExecutionEnvironment = ExecutionEnvironment getExecutionEnvironment
        import org.apache.flink.api.scala._
        val ds: DataSet[String] = env readTextFile "input/words.txt"
        val result: AggregateDataSet[(String, Int)] = ds flatMap (_.split(" ")) map ((_, 1)) groupBy 0 sum 1
        result print
    }
}

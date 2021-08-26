package test


import org.apache.flink.streaming.api.datastream.DataStreamSource
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
  * @author luojun
  * @create 2021-08-26 23:00
  */
object WordCountByStreaming {
    def main(args: Array[String]): Unit = {
        val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment

        import org.apache.flink.streaming.api.scala._

        val ds: DataStream[String] = env.socketTextStream("hadoop102",9999)

        val result: DataStream[(String, Int)] = ds flatMap(_.split(" ")) map((_,1)) keyBy 0 sum 1

        result print

        env execute "wordCount"

    }

}

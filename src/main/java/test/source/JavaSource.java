package test.source;

import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import test.WaterSensor;

import java.util.Arrays;
import java.util.List;

/**
 * @author luojun
 * @create 2021-08-28 0:16
 */
public class JavaSource {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        List<WaterSensor> waterSensors = Arrays.asList(new WaterSensor("ws_001", 1577844001L, 45),
                new WaterSensor("ws_002", 1577844015L, 43),
                new WaterSensor("ws_003", 1577844020L, 42));
        DataStreamSource<WaterSensor> ds = env.fromCollection(waterSensors);

        ds.print();

        env.execute("wordCount");
    }
}

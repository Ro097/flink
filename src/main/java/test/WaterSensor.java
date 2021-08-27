package test;

/**
 * @author luojun
 * @create 2021-08-28 0:17
 */
public class WaterSensor {
    private String id;
    private Long ts;
    private Integer vc;

    public WaterSensor(String id, Long ts, Integer vc) {
        this.id = id;
        this.ts = ts;
        this.vc = vc;
    }
}

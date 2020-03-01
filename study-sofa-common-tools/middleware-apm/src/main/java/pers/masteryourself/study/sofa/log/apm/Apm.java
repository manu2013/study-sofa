package pers.masteryourself.study.sofa.log.apm;

/**
 * <p>description : Apm, APM 工具类
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/10/26 21:46
 */
public class Apm {

    public static ApmMetrics begin(String methodName) {
        ApmMetrics metrics = new ApmMetrics();
        metrics.setBeginTime(System.currentTimeMillis());
        metrics.setMethodName(methodName);
        return metrics;
    }

}

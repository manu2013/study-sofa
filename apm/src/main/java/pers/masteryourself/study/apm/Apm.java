package pers.masteryourself.study.apm;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2019/10/26 21:44
 */
public class Apm {

    public static ApmMetrics begin(String methodName) {
        ApmMetrics metrics = new ApmMetrics();
        metrics.setBeginTime(System.currentTimeMillis());
        metrics.setMethodName(methodName);
        return metrics;
    }

}

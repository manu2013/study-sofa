package pers.masteryourself.study.apm;

import com.alipay.sofa.common.utils.StringUtil;
import lombok.Data;
import org.slf4j.Logger;
import pers.masteryourself.study.apm.log.ApmLoggerFactory;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2019/10/26 21:52
 */
@Data
public class ApmMetrics {

    private static final Logger LOGGER = ApmLoggerFactory.getLogger(ApmMetrics.class);

    private String methodName;

    private String errorMsg;

    private Long beginTime;

    private Long endTime;

    public void error(ApmMetrics metrics, Throwable e) {
        metrics.setErrorMsg(e.getMessage());
    }

    public void end(ApmMetrics metrics) {
        metrics.setEndTime(System.currentTimeMillis());
        this.submitResult(metrics);
    }

    private void submitResult(ApmMetrics metrics) {
        if (StringUtil.isEmpty(metrics.getErrorMsg())) {
            LOGGER.info("{} 执行正常，耗时 {}", metrics.getMethodName(), metrics.getEndTime() - metrics.getBeginTime());
        } else {
            LOGGER.error("{} 执行失败，耗时 {} ms，异常信息 {}", metrics.getMethodName(), metrics.getEndTime() - metrics.getBeginTime(),
                    metrics.getErrorMsg());
        }
    }

}

package pers.masteryourself.study.sofa.log.apm;

import com.alipay.sofa.common.utils.StringUtil;
import lombok.Data;
import org.slf4j.Logger;
import pers.masteryourself.study.sofa.log.apm.log.ApmLoggerFactory;

/**
 * <p>description : ApmMetrics, 模拟调用链埋点
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/10/26 21:46
 */
@Data
public class ApmMetrics {

    private static final Logger LOGGER = ApmLoggerFactory.getLogger(ApmMetrics.class);

    private String methodName;

    private String errorMsg;

    private Long beginTime;

    private Long endTime;

    public void error(Throwable e) {
        this.setErrorMsg(e.getMessage());
    }

    public void end() {
        this.setEndTime(System.currentTimeMillis());
        this.submitResult();
    }

    private void submitResult() {
        long spendTime = this.getEndTime() - this.getBeginTime();
        if (StringUtil.isEmpty(this.getErrorMsg())) {
            LOGGER.info("{} 执行正常，耗时 {} ms", this.getMethodName(), spendTime);
        } else {
            LOGGER.error("{} 执行失败，耗时 {} ms，异常信息 {}", this.getMethodName(),
                    spendTime, this.getErrorMsg());
        }
    }

}

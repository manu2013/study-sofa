package pers.masteryourself.study.apm.log;

import com.alipay.sofa.common.log.MultiAppLoggerSpaceManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : masteryourself
 * @version : 1.0
 * blog : https://blog.csdn.net/masteryourself
 * Tel : 17621208646
 * Description : 描述
 * @date : 2019/10/26 21:46
 */
public class ApmLoggerFactory {

    private static final String RPC_LOG_SPACE = "pers.masteryourself.study.apm";

    static {
        //SpaceId init properties
        if (!MultiAppLoggerSpaceManager.isSpaceInitialized(RPC_LOG_SPACE)) {
            Map spaceIdProperties = new HashMap<String, String>();
            MultiAppLoggerSpaceManager.init(RPC_LOG_SPACE, spaceIdProperties);
        }
    }

    public static org.slf4j.Logger getLogger(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        return getLogger(clazz.getCanonicalName());
    }

    public static org.slf4j.Logger getLogger(String name) {
        //From "pers/masteryourself/study/apm/log" get the xml configuration and init,then get the logger object
        return MultiAppLoggerSpaceManager.getLoggerBySpace(name, RPC_LOG_SPACE);
    }

}

package pers.masteryourself.study.sofa.log.uc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.masteryourself.study.sofa.log.apm.Apm;
import pers.masteryourself.study.sofa.log.apm.ApmMetrics;
import pers.masteryourself.study.sofa.log.uc.user.UserService;

/**
 * <p>description : UserCenterApplicationTest
 *
 * <p>blog : https://Blog.csdn.net/masteryourself
 *
 * @author : masteryourself
 * @version : 1.0.0
 * @date : 2019/10/26 21:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserCenterApplication.class)
public class UserCenterApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testPrintUserInfo() {
        ApmMetrics metrics = Apm.begin("printUserInfo");
        try {
            userService.printUserInfo();
        } catch (Exception e) {
            metrics.error(e);
        } finally {
            metrics.end();
        }
    }

}
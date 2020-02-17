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
 * @author : rrz
 * @version : 1.0
 * QQ : 1571902315
 * Tel : 17621208646
 * Description : 描述
 * @date : 2019/10/26 22:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceTest {

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
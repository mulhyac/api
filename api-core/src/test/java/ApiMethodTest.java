import com.lip.api.core.model.Api;
import com.lip.api.core.model.ApiGroup;
import com.lip.api.core.service.ApiGroupService;
import com.lip.api.core.service.ApiService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * Created by Administrator on 2016/7/6 0006.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class ApiMethodTest {
    @Autowired
    private ApiService apiService;
    @Autowired
    private ApiGroupService groupService;
    @Test
    public void insertTest()
    {
    }
    @Test
    public void testApi()
    {
    }
}

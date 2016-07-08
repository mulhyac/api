import com.lip.api.core.dao.ApiMethodMapper;
import com.lip.api.core.model.ApiMethod;
import com.lip.api.core.service.ApiMethodService;
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
    private ApiMethodService apiService;
    @Test
    public void insertTest()
    {
        ApiMethod method=new ApiMethod();
        method.setMid(6);
        method.setType("PUT");
        //apiService.insertApiMethod(method);
        //apiMethodMapper.insert(method);
        ApiMethod m2=apiService.getMethod(1);
       System.out.println(m2.toString());
    }
}

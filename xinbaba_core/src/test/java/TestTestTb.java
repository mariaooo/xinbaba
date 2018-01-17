import com.hsbc.core.bean.TestTb;
import com.hsbc.core.dao.TestTbDao;
import com.hsbc.core.junit.SpringJunitTest;
import com.hsbc.core.service.TestTbService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by ZhanShen on 2018/1/16.
 */
public class TestTestTb extends SpringJunitTest {

    @Autowired
    private TestTbDao td;

    @Autowired
    private TestTbService ts;

    @Test
    public void testAddTestTb() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TestTb tt = new TestTb(null, "chris", sdf.parse("1992-12-12"));
        ts.addTestTb(tt);
    }
}

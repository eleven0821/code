package pms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.utils.MD5;

@RunWith(SpringJUnit4ClassRunner.class) //使用spring测试框架
@ContextConfiguration("classpath:applicationcontext.xml") //引入配置文件
public class TestMd5 {
	
	@Test
	public void testMd5(){
		MD5 md5=new MD5();
		System.out.println(md5.getMD5ofStr("test1"));
	}
}

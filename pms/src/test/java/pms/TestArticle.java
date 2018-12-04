package pms;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TArticle;
import com.zs.pms.po.TChannel;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TUser;
import com.zs.pms.service.ArticleService;
import com.zs.pms.vo.QueryArticle;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class) // 使用spring测试框架
@ContextConfiguration("classpath:applicationcontext.xml") // 引入配置文件
public class TestArticle {
	@Autowired
	ArticleService as;// 注入

	public void testQuery() {
		// 创建对象
		QueryArticle query = new QueryArticle();
		// 存入用户登录信息
		query.setAuthor("周杰伦");
		as.queryByCon(query);
	}

	// 查询总页数

	public void testPage() {
		QueryArticle query = new QueryArticle();

		System.out.println("总页数：" + as.queryPageCount(query));
		for (TArticle article : as.queryByPage(query, 1)) {
			System.out.println(article.getAuthor());
		}

	}

	// 新增

	public void testAdd() {
		// 创建对象
		TArticle article = new TArticle();
		article.setAuthor("小样");
		article.setContent("这是一个神奇的网站，当当网");
		article.setCreator(1000);
		article.setIshot(1);
		article.setIsremod(1);
		article.setTitle("当当网");

		// 创建栏目对象
		TChannel channel = new TChannel();
		channel.setId(1002);
		article.setChannel(channel);

		try {
			as.insert(article);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 修改
	
	public void testUpdate() {
		// 创建对象
		TArticle article = new TArticle();
		// 修改属性
		article.setId(1003);
		article.setUpdater(1001);
		article.setAuthor("张飞");
		article.setContent("张飞面前耍大刀");
		article.setIshot(-1);

		try {
			as.update(article);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 批量删除
	@Test // 引入junit
	public void testDelete() {
		// 定义数组
		int[] ids = { 1024, 1025 };
		try {
			as.deleteByIds(ids);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//删除一条
	
	public void testDeleteById(){
			
		try {
			as.delete(1026);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

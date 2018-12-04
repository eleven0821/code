package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.ArticleDao;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TArticle;
import com.zs.pms.service.ArticleService;
import com.zs.pms.utils.Constants;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.QueryArticle;

@Service //文章对象实现
@Transactional //文章业务支持事务
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao adao;//注入文章dao对象

	//根据条件查询
	@Override
	public List<TArticle> queryByCon(QueryArticle query) {
		// TODO Auto-generated method stub
		return adao.queryByCon(query);
	}

	//分页查询
	@Override
	public List<TArticle> queryByPage(QueryArticle query,int page) {
		// TODO Auto-generated method stub
		//将当前页设置到条件中
		query.setPage(page);
		return adao.queryByPage(query);
	}

	//根据文章id查询一条
	@Override
	public TArticle queryById(int id) {
		// TODO Auto-generated method stub
		return adao.queryById(id);
	}

	//查询总页数
	@Override
	public int queryPageCount(QueryArticle query) {
		// TODO Auto-generated method stub
		//查询总行数
		int count=adao.queryCount(query);
		//判断总条数/每页条数，是否整除
		if(count%Constants.PAGECOUNT==0){
			//可以整除
			return count/Constants.PAGECOUNT;
		}else{
			//不能整除
			return count/Constants.PAGECOUNT+1;
		}
		
	}

	//新增
	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public int insert(TArticle article) throws AppException {
		// TODO Auto-generated method stub
		
		return adao.insert(article);
	}

	//修改
	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public void update(TArticle article) throws AppException {
		// TODO Auto-generated method stub
		adao.update(article);
	}

	//删除一条
	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public void delete(int id) throws AppException {
		// TODO Auto-generated method stub
		adao.delete(id);
	}

	//批量删除
	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public void deleteByIds(int[] ids) throws AppException {
		// TODO Auto-generated method stub
		
		adao.deleteByIds(ids);
	}
	
}

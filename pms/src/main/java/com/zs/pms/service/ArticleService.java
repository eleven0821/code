package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TArticle;
import com.zs.pms.vo.QueryArticle;

//文章业务层
public interface ArticleService {
	//根据条件查询文章
	public List<TArticle> queryByCon(QueryArticle query);
	//分页查询，当前页传入方法中
	public List<TArticle> queryByPage(QueryArticle query,int page);
	//查询一条
	public TArticle queryById(int id);
	//获得总页数
	public int queryPageCount(QueryArticle query);
	//新增
	public int insert(TArticle article) throws AppException;
	//修改
	public void update(TArticle article) throws AppException;
	//删除一条
	public void delete(int id) throws AppException;
	//批量删除
	public void deleteByIds(int[] ids) throws AppException;
}

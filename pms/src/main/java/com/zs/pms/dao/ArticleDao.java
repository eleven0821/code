package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TArticle;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryArticle;
import com.zs.pms.vo.QueryUser;

/*
 * 文章表接口，操作数据库中文章表数据
 * */
public interface ArticleDao {
	// 通过条件查询文章
	public List<TArticle> queryByCon(QueryArticle query);

	// 分页查询
	public List<TArticle> queryByPage(QueryArticle query);

	// 根据文章id获取用户信息
	public TArticle queryById(int id);

	// 批量删除
	public void deleteByIds(int[] ids);

	// 新增
	public int insert(TArticle article);

	// 修改
	public void update(TArticle article);

	// 删除
	public void delete(int id);

	// 查询总条数，用于分页查询
	public int queryCount(QueryArticle query);
}

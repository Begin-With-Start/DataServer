package com.minifly.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.minifly.bean.MeizhiImageBean;
import com.minifly.bean.PhotoBean;
import com.minifly.db.DBHelper;
import com.minifly.utils.StringUtils;

public class MeizhiDbutils {

	/**
	 * 获取一下数据库中的数据，每个人都获取一些 分页操作。
	 */
	public static List<MeizhiImageBean> getMeizhiImageAlbum(String page) {
		List<MeizhiImageBean> list = new LinkedList<MeizhiImageBean>();
		
		int pageNum = StringUtils.string2Int(page)*20;//每页给20个推荐。
		int pageEndNum = (StringUtils.string2Int(page)+1)*20;
		
		String sql = "SELECT p.description,m.image_url,p.id FROM meizhi_image m,meizhi_pageurl p WHERE m.parent_id = p.id GROUP BY m.parent_id LIMIT "+pageNum+", "+pageEndNum+";";
		System.out.println(""+ sql);
		Connection conn = DBHelper.getConnection();
		try{
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			MeizhiImageBean  meizhiBean = null;
			while (rs.next()) {
				meizhiBean = new MeizhiImageBean();
				meizhiBean.setImageUrl(rs.getString("image_url"));
				meizhiBean.setDescription(rs.getString("description"));
				meizhiBean.setParentId(rs.getString("id"));
				list.add(meizhiBean);
			}
			rs.close();
		}catch(Exception e){
			System.out.println("" + e.getMessage());
		}
		
		return list;
	}
	/**
	 * 通过id获取所有的妹纸图
	 */
	public static List<MeizhiImageBean> getMeizhiById(String userId) {
		List<MeizhiImageBean> list = new LinkedList<MeizhiImageBean>();
		String sql = "SELECT	m.parent_id,m.image_url,p1.description FROM meizhi_image m,( SELECT p.description FROM meizhi_pageurl p WHERE p.id = " +userId+ " ) p1 WHERE m.parent_id = "+userId+";";
		System.out.println("" +sql);
		
		Connection conn = DBHelper.getConnection();
		try{
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			MeizhiImageBean  meizhiBean = null;
			while (rs.next()) {
				meizhiBean = new MeizhiImageBean();
				meizhiBean.setImageUrl(rs.getString("image_url"));
				meizhiBean.setDescription(rs.getString("description"));
				meizhiBean.setParentId(rs.getString("parent_id"));
				list.add(meizhiBean);
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("" + e.getMessage());
		}
		
		return list;
	}
	
	
}

package com.minifly.dbutil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.minifly.bean.PhotoBean;
import com.minifly.db.DBHelper;

public class PhotoDbutils {

	/**
	 * 获取一下数据库中的数据，每个人都获取一些
	 */
	public static List<PhotoBean> getPohoto() {
		List<PhotoBean> list = new LinkedList<PhotoBean>();
		String sql = "select t.image_url,t.user_id   from tb_image t where 1=1 group by t.user_id LIMIT 10,20";

		Connection conn = DBHelper.getConnection();
		try{
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			PhotoBean  photoBean = null;
			while (rs.next()) {
				photoBean = new PhotoBean();
				photoBean.setImage_url(rs.getString("image_url"));
				photoBean.setUser_id(rs.getString("user_id"));
				list.add(photoBean);
			}
			rs.close();
		}catch(Exception e){
			System.out.println("" + e.getMessage());
		}
		
		return list;
	}
	/**
	 * 获取一下数据库中的数据，根据userid来进行
	 */
	public static List<PhotoBean> getPohotoById(String userId) {
		List<PhotoBean> list = new LinkedList<PhotoBean>();
		String sql = "select t.image_url,t.user_id  from tb_image t where t.user_id = "+userId+" LIMIT 10,20";
		System.out.println("" +sql);
		
		Connection conn = DBHelper.getConnection();
		try{
			// statement用来执行SQL语句
			Statement statement = conn.createStatement();
			// 要执行的SQL语句
			// 结果集
			ResultSet rs = statement.executeQuery(sql);
			PhotoBean  photoBean = null;
			while (rs.next()) {
				photoBean = new PhotoBean();
				photoBean.setImage_url(rs.getString("image_url"));
				photoBean.setUser_id(rs.getString("user_id"));
				list.add(photoBean);
			}
			rs.close();
		}catch(Exception e){
			System.out.println("" + e.getMessage());
		}
		
		return list;
	}
}

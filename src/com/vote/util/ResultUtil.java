/**
 * 
 */
package com.vote.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import com.jufeng.database.DBManage;
import com.vote.entity.Result;

/**
 * @author Lenovo
 * 2014-4-23
 */
public class ResultUtil {

	public static List<Result> getResult(){
		List<Result> retList = new ArrayList<Result>();
		WebRowSet rs = DBManage.getWRS("select result,count(result) from votes group by result");
		try {
			if(rs!=null){
				while(rs.next()){
					Result rst = new Result();
					rst.setLabel(rs.getString(1));
					rst.setCount(rs.getInt(2));
					retList.add(rst);
				}
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
}

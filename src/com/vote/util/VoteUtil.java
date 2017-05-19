/**
 * 
 */
package com.vote.util;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import com.jufeng.database.DBManage;
import com.vote.entity.VoteItem;

/**
 * @author Lenovo
 * 2014-5-4
 */
public class VoteUtil {
	
	public static List<VoteItem> getVoteItems(){
		List<VoteItem> retList = new ArrayList<VoteItem>();
		WebRowSet rs = DBManage.getWRS("SELECT * FROM OPTIONS");
		if(rs!=null){
			try {
				while(rs.next()){
					VoteItem voteItem = new VoteItem();
					voteItem.setId(rs.getString("ID"));
					voteItem.setLabel(rs.getString("LABEL"));
					retList.add(voteItem);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return retList;
	}

}

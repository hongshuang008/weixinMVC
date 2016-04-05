package com.lianchuang.service;

import java.util.ArrayList;
import java.util.List;

import com.lianchuang.entity.autoReply.MessageResponse;
import com.lianchuang.entity.message.resp.Article;

/**
 * 
 * 创建人：herosky   
 * 创建时间：2015-3-30 下午5:13:57   
 * 描述：菜单点击事件，处理
 *
 */
public class MenuClickService {

	/**
	 * 
	 * 描述：@param eventKey
	 * 描述：@param fromUserName
	 * 描述：@param toUserName
	 * 描述：@return 接受用户点击事件，通过微信推送给用户消息，跳转页面，发送消息等
	 * 作者：herosky
	 */
	public static String getClickResponse(String eventKey, String fromUserName,
			String toUserName) {
		// TODO 判断evetKey事件处理
		if(eventKey.equals("V1001_GOOD"))
		{
			List<Article> articleList = new ArrayList<Article>();
			Article a = new Article();
			a.setTitle("微信公众平台开发教程");
			a.setPicUrl("http://discuz.comli.com/weixin/weather/icon/cartoon.jpg");
			a.setUrl("http://m.cnblogs.com/?u=txw1958");
			a.setDescription("");
			articleList.add(a);
			return MessageResponse.getNewsMessage(fromUserName, toUserName, articleList);
		}
		return null;
	}

}

package com.example.neihan.bean;

import org.json.JSONException;
import org.json.JSONObject;

public class ImageEntity {
	
	private int type;
	
	private int commentCount;
	
	private Long groupid;
	
	private String content;
	
	private ImageUrlList largeList;
	
	private ImageUrlList middleList;

	public void parseJson(JSONObject item) throws JSONException{
		type = item.getInt("type");
		
		JSONObject group = item.getJSONObject("group");
		
		commentCount = group.getInt("comment_count");
		
		JSONObject largeImage = group.getJSONObject("large_image");
		JSONObject middleImage = group
				.getJSONObject("middle_image");
		
		groupid = group.getLong("group_id");
		
		content = group.getString("content");

		// 大图片的网址全部在这里
		//refact-->第三个提前为一个方法-->然后在方法中改为return List<String> largeImageUrls
		
		largeList = new ImageUrlList();
		largeList.parseJson(largeImage);
							
		middleList = new ImageUrlList();
		middleList.parseJson(middleImage);
	}
}

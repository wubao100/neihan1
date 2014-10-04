package com.example.neihan.bean;

import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImageUrlList {
	
	private List<String> largeImageUrls;
	private String uri;
	private int width;
	private int heith;

	public void parseJson(JSONObject json) throws JSONException{
		largeImageUrls = parseImageUrlList(json);
		uri = json.getString("uri");
		width = json.getInt("width");
		heith = json.getInt("heith");
	}
	
	
	
	public List<String> getLargeImageUrls() {
		return largeImageUrls;
	}



	public String getUri() {
		return uri;
	}



	public int getWidth() {
		return width;
	}



	public int getHeith() {
		return heith;
	}



	private List<String> parseImageUrlList(JSONObject largeImage) throws JSONException {
		JSONArray urls = largeImage.getJSONArray("url_list");

		// 大图片的网址全部在这里
		List<String> largeImageUrls = new LinkedList<String>();

		int ulen = urls.length();
		for (int j = 0; j < ulen; j++) {
			JSONObject uobj = urls.getJSONObject(j);
			String url = uobj.getString("url");
			largeImageUrls.add(url);
		}
		return largeImageUrls;
	}
	
}

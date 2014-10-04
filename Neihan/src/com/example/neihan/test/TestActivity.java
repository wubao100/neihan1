package com.example.neihan.test;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import com.android.volley.RequestQueue;
import com.android.volley.Response;

import com.android.volley.toolbox.Volley;
import com.example.neihan.R;
import com.example.neihan.bean.ImageEntity;
import com.example.neihan.client.ClientAPI;

import android.os.Bundle;
import android.app.Activity;


/**
 * 这个文件就是一个测试入口，所有的测试内容，都可以放在这里
 * 
 * @author fly
 * 
 */
public class TestActivity extends Activity implements Response.Listener<String> {
	/**
	 * 分类ID，1代表文本
	 */
	public static final int CATEGORY_TEXT = 1;
	/**
	 * 分类ID,2代表图片
	 */
	public static final int CATEGORY_IMAGE = 2;
	private RequestQueue queue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_activity);

		int itemCount = 30;

		queue = Volley.newRequestQueue(this);

		ClientAPI.getList(queue, CATEGORY_IMAGE, itemCount, this);// 右键-->refact-->move-->(代码重构)
	}



	@Override
	public void onResponse(String response) {
		// TODO Auto-generated method stub
		try {
			JSONObject json = new JSONObject(response);
			response = json.toString(4);
			System.out.println("List:" + response);
			// 获取根节点下的data 对象
			JSONObject object = json.getJSONObject("data");
			// 从data对象中，获取名称为data的数组，它代表的是段子列表的数据
			JSONArray array = object.getJSONArray("data");
			//
			int len = array.length();

			if (len > 0) {
				// 遍历数组中的每一条图片段子信息
				for (int i = 0; i < len; i++) {
					JSONObject item = array.getJSONObject(i);
					ImageEntity imageEntity=new ImageEntity();
					imageEntity.parseJson(item);				
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

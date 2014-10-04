package com.example.neihan.client;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.neihan.test.TestActivity;

/**
 * 所有和服务器接口对接的方法，全部在这个类里
 * @author aaa
 *
 */
public class ClientAPI {

	/**
	 * 获取内涵段子列表内容
	 * @param categoryType  要获得的参数类型
	 * @param itemCount 服务器一次传回的个数
	 * @param responseListener 用于获取段子列表的回调接口，任何调用getList方法时，此参数用于更新段子列表
	 * @param queue Volley请求的队列
	 * @see TestActivity#CATEGORY_TEXT
	 * @see TestActivity#CATEGORY_IMAGE
	 */
		public static void getList(RequestQueue queue,int categoryType, int itemCount,Response.Listener<String> responseListener) {
	
			String CATEGORE_LIST_API = "http://ic.snssdk.com/2/essay/zone/category/data/";
			// 分类参数
			String categoryPAram = "category_id=" + categoryType;
			//
			String countParam = "count=" + itemCount;
	
			String deviceTyteParam = "device_type=KFTT";
	
			String openUDID = "openudid=b90ca6a3a19a78d6";
	
			String path = CATEGORE_LIST_API
					+ "?"
					+ categoryPAram
					+ "&"
					+ countParam
					+ "&"
					+ deviceTyteParam
					+ "&"
					+ openUDID
					+ "&level=6&iid=2337593504&device_id=2757969807&ac=wifi&channel=wandoujia&aid=7&app_name=joke_essay&version_code=302&device_platform=android&os_api=15&os_version=4.0.3 ";
	
			
	
			queue.add(new StringRequest(Request.Method.GET, path,
					responseListener, new Response.ErrorListener() {
	
						@Override
						public void onErrorResponse(VolleyError arg0) {
							// TODO Auto-generated method stub
	
						}
					}));
		}
	

}

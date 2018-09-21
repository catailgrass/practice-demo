package com.flycat.util;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * JSON处理工具�?.
 *
 * @author <a href="http://www.jiangzezhou.com">jiangzezhou</a>
 * @version 1.0.0.0, 6/16/15 09::55
 */
public final class JsonUtils {

	 /**
     * Logger.
     */
    private static final Logger LOGGER = Logger.getLogger(JsonUtils.class.getName());

    private JsonUtils() {
    }

    public static<T> String list2Json(final List<T> list){
    	return bean2Json(list);
    }
    public static<T> List<T> json2List(String jsonStr,Class<T> clazz){
    	 final Gson gson = new Gson();
    	 List<T> retList = new ArrayList<T>();
         try {
        	 List<JsonElement> list = gson.fromJson(jsonStr,new TypeToken<List<JsonElement>>(){
        		 
        	 }.getType());
        	 for(JsonElement e : list){
        		 retList.add(gson.fromJson(e, clazz));
        	 }
         } catch (JsonSyntaxException e) {
             LOGGER.info("json2Bean error" + e.getMessage());
         }
         return retList;
    }
    public static <T> T json2Bean(final String jsonStr, Class<T> clazz) {
        final Gson gson = new Gson();
        T t = null;
        try {
            t = gson.fromJson(jsonStr, clazz);
        } catch (JsonSyntaxException e) {
            LOGGER.info("json2Bean error" + e.getMessage());
        }
        return t;
    }

    public static <T> String bean2Json(final T t) {
        final Gson gson = new Gson();
        String jsonStr = null;
        try {
            jsonStr = gson.toJson(t);
        } catch (JsonSyntaxException e) {
            LOGGER.info("json2Bean error" + e.getMessage());
        }
        return jsonStr;
    }


	public static JSONArray createJsonArray(JSONObject... objs) {

		JSONArray jsonArray = new JSONArray();
		for (JSONObject o : objs) {
			jsonArray.add(o);
		}
		return jsonArray;
	}
	public static class JSONBuilder {
	    private JSONObject jsonObject = new JSONObject();
	    public JSONBuilder(){

	    }
	    public JSONBuilder(JSONObject jsonObject){
	    	Iterator iterator = jsonObject.keys();                       // joData是JSONObject对象  
	    	while(iterator.hasNext()){  
	    	    String key = iterator.next() + "";  
	    	    try {
					this.jsonObject.put(key,jsonObject.get(key));
				} catch (Exception e) {
				}
	    	} 	
	    }
	    public JSONBuilder(Map<String,?> map){
	        for(String key :map.keySet()){
	            try {
					this.jsonObject.put(key,map.get(key));
				} catch (Exception e) {
				}
	        }
	    }
	    public JSONBuilder put(String key,Object value){
	        try {
				jsonObject.put(key,value);
			} catch (Exception e) {
			}
	        return this;
	    }
	    public JSONObject build(){
	        return jsonObject;
	    }
	}

}

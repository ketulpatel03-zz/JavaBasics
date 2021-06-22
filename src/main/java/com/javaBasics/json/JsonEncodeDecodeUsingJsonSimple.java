package com.javaBasics.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonEncodeDecodeUsingJsonSimple {

	public static void main(String[] args) {

		JSONArray jsonArr = new JSONArray();
		for (int i = 0; i < 3; i++) {
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("control", "part" + i);
			jsonObj.put("referenceId", "MFI_PART" + i);
			jsonArr.add(jsonObj);
		}
		String JSONEncodedStr = jsonArr.toJSONString();
		System.out.println(JSONEncodedStr);

		JSONParser jsonParser = new JSONParser();
		JSONArray arr = new JSONArray();
		try {
			arr = (JSONArray) jsonParser.parse(JSONEncodedStr);
			System.out.println(arr.size());
			JSONObject obj = (JSONObject) arr.get(1);
			System.out.println(obj);
			System.out.println(obj.get("referenceId"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

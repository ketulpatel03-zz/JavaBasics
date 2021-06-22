package com.javaBasics.json;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JsonEncodeDecodeUsingJackson {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode user1 = mapper.createObjectNode();
		user1.put("control", "part");
		user1.put("referenceId", "MFI_PART");
		
		ArrayNode arrayNode = mapper.createArrayNode();

	    // add JSON users to array
	    arrayNode.addAll(Arrays.asList(user1));

	    // convert `ArrayNode` to pretty-print JSON
	    // without pretty-print, use `arrayNode.toString()` method
	    String json;
		json = arrayNode.toString();
		System.out.println(json);

		
		
	}

}

package com.javaBasics.json;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class DeserializeJSON {

	public static void main(String[] args) {
		String text = "[{\"control\":\"tool\",\"referenceId\":\"MFI_TOOL\"},{\"control\":\"part\",\"referenceId\":\"MFI_PART\"}]";
		ObjectMapper objMapper = new ObjectMapper();
		try {
			if (StringUtils.isNotEmpty(text)) {
				JsonNode node = objMapper.readTree(text);
				if (node instanceof ArrayNode) {
					ArrayNode arrayNode = (ArrayNode) node;
					ObjectNode objNode = createObjectNodeForPlanOperStepText("dc", "MFI_DC", objMapper);
					arrayNode.insert(0, objNode);
					arrayNode.remove(2);
					System.out.println(arrayNode.toString());
				}
			} else {
				ObjectNode objNode = createObjectNodeForPlanOperStepText("tool", "MFI_TOOL", objMapper);
				ArrayNode arrayNode = objMapper.createArrayNode();
				arrayNode.addAll(Arrays.asList(objNode));
				System.out.println(arrayNode.toString());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}

	private static ObjectNode createObjectNodeForPlanOperStepText(String control, String referenceId,
			ObjectMapper mapper) {
		ObjectNode objNode = mapper.createObjectNode();
		objNode.put("control", control);
		objNode.put("referenceId", referenceId);
		return objNode;
	}
}

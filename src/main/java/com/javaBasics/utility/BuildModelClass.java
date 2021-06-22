package com.javaBasics.utility;

import org.apache.commons.text.WordUtils;

import com.google.common.base.CaseFormat;

public class BuildModelClass {
	public static void main(String[] arg) {
		String[] params = { "String planId", "Number planVersion", "Number planRevision", "Number planAlterations",
				"String operationNumber", "String stepNumber", "String toolNumber", "String toolChange",
				"String serialFlag", "String expirationFlag", "String lowestNavigationLevel", "String toolNotes",
				"Number quantity", "String ucfPlanToolVch1", "String ucfPlanToolVch2", "String ucfPlanToolVch3",
				"String ucfPlanToolFlag1", "Number ucfPlanToolNum1", "Date ucfPlanToolDate1", "String orientationFlag",
				"String crossOrderFlag", "String optionalFlag", "String ucfPlanToolVch4", "String ucfPlanToolVch5",
				"String ucfPlanToolVch6", "String ucfPlanToolVch7", "String ucfPlanToolVch8", "String ucfPlanToolVch9",
				"String ucfPlanToolVch10", "String ucfPlanToolVch11", "String ucfPlanToolVch12",
				"String ucfPlanToolVch13", "String ucfPlanToolVch14", "String ucfPlanToolVch15",
				"Number ucfPlanToolNum2", "Number ucfPlanToolNum3", "Number ucfPlanToolNum4", "Number ucfPlanToolNum5",
				"Date ucfPlanToolDate2", "Date ucfPlanToolDate3", "Date ucfPlanToolDate4", "Date ucfPlanToolDate5",
				"String ucfPlanToolFlag2", "String ucfPlanToolFlag3", "String ucfPlanToolFlag4",
				"String ucfPlanToolFlag5", "String ucfPlanToolVch2551", "String ucfPlanToolVch2552",
				"String ucfPlanToolVch2553", "String ucfPlanToolVch40001", "String ucfPlanToolVch40002",
				"String blockId", "Number displayLineNo", "String overUsedFlag", "String toolId", "String referenceId",
				"String blockType", "String calledFrom", "Number dropDispLineNo", "String newToolTitle",
				"String dratAtLast", "String externalFlag", "String templateNumber", "String unitType",
				"String effectivityFrom", "String effectivityThru", "Date effectivityFromDate",
				"Date effectivityThruDate" };
		StringBuilder outputText = new StringBuilder();
		StringBuilder buildText = new StringBuilder();
		String modelClass = "operToolsModel";
		for (String param : params) {
			String varType = param.split(" ")[0];
			String varName = param.split(" ")[1];
			if (varType.startsWith("String")) {
				outputText.append("@Size(max=" + CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, varName)
						+ ", message=SIZE_ERROR_MSGID) \n");
			}
			outputText.append("private " + param + ";\n");

			// for builder class
			buildText.append("public Builder " + varName + "(" + varType + " " + varName + ") { \n");
			buildText.append(modelClass + ".set" + WordUtils.capitalize(varName) + "(" + varName + "); \n");
			buildText.append("return this;\n } \n");

		}
		System.out.println(outputText);
		System.out.println(buildText);

	}

}

package org.example.loader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.enums.*;
import org.example.model.VisaRule;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RuleLoader {

    public static List<VisaRule> load(String path) {

        List<VisaRule> rules = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(new File(path));

            for (JsonNode node : root) {

                VisaRule rule = new VisaRule(
                        Country.valueOf(node.get("country").asText()),
                        Country.valueOf(node.get("passportCountry").asText()),
                        TravelPurpose.valueOf(node.get("travelPurpose").asText()),
                        node.get("maxStayDays").asInt(),
                        node.get("visaRequired").asBoolean(),
                        VisaType.valueOf(node.get("visaType").asText()),
                        parseDocuments(node.get("documents")),
                        node.get("processingDays").asInt()
                );

                rules.add(rule);
            }

        } catch (Exception e) {
            throw new RuntimeException("Invalid visa rule config");
        }

        return rules;
    }

    private static List<DocumentType> parseDocuments(JsonNode node) {
        List<DocumentType> list = new ArrayList<>();
        for (JsonNode doc : node) {
            list.add(DocumentType.valueOf(doc.asText()));
        }
        return list;
    }
}

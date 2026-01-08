package org.example.evaluator;

import org.example.enums.*;
import org.example.model.*;
import org.example.repository.RuleRepository;

import java.util.ArrayList;
import java.util.List;

public class VisaRuleEvaluator {

    private final RuleRepository repository;

    public VisaRuleEvaluator(RuleRepository repository) {
        this.repository = repository;
    }

    public VisaDecision evaluate(
            Country destination,
            Country passport,
            TravelPurpose purpose,
            int stayDays
    ) {

        List<VisaRule> matches = new ArrayList<>();

        for (VisaRule rule : repository.getAllRules()) {
            if (rule.getCountry() == destination &&
                    rule.getPassportCountry() == passport &&
                    rule.getTravelPurpose() == purpose &&
                    stayDays <= rule.getMaxStayDays()) {

                matches.add(rule);
            }
        }

        if (matches.isEmpty()) {
            return new VisaDecision(
                    false,
                    VisaType.NONE,
                    List.of(),
                    0,
                    List.of("No matching rule found")
            );
        }

        if (matches.size() > 1) {
            return new VisaDecision(
                    true,
                    matches.get(0).getVisaType(),
                    matches.get(0).getDocuments(),
                    matches.get(0).getProcessingDays(),
                    List.of("Multiple conflicting rules found")
            );
        }

        VisaRule rule = matches.get(0);

        return new VisaDecision(
                rule.isVisaRequired(),
                rule.getVisaType(),
                rule.getDocuments(),
                rule.getProcessingDays(),
                List.of()
        );
    }
}

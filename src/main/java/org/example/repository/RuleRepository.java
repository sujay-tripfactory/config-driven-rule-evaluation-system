package org.example.repository;

import org.example.model.VisaRule;

import java.util.List;

public class RuleRepository {

    private final List<VisaRule> rules;

    public RuleRepository(List<VisaRule> rules) {
        this.rules = List.copyOf(rules);
    }

    public List<VisaRule> getAllRules() {
        return rules;
    }
}

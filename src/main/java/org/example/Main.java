package org.example;

//packages imported

import org.example.enums.*;
import org.example.evaluator.VisaRuleEvaluator;
import org.example.loader.RuleLoader;
import org.example.model.VisaDecision;
import org.example.repository.RuleRepository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RuleRepository repository =
                new RuleRepository(RuleLoader.load("config/visa-rules.json"));

        VisaRuleEvaluator evaluator = new VisaRuleEvaluator(repository);

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Destination Country (USA, UAE, UK, AUSTRALIA): ");
        Country destination = Country.valueOf(sc.next().toUpperCase());

        System.out.println("Enter Passport Country (INDIA, AUSTRALIA, EUROPE): ");
        Country passport = Country.valueOf(sc.next().toUpperCase());

        System.out.println("Enter Travel Purpose (TOURISM, BUSINESS, STUDY): ");
        TravelPurpose purpose = TravelPurpose.valueOf(sc.next().toUpperCase());

        System.out.println("Enter Stay Duration (days): ");
        int stayDays = sc.nextInt();

        VisaDecision decision =
                evaluator.evaluate(destination, passport, purpose, stayDays);

        System.out.println("\n----- VISA DECISION -----");
        System.out.println("Visa Required: " + decision.isVisaRequired());
        System.out.println("Visa Type: " + decision.getVisaType());
        System.out.println("Documents: " + decision.getDocuments());
        System.out.println("Processing Days: " + decision.getProcessingDays());
        System.out.println("Warnings: " + decision.getWarnings());
    }
}

package org.example.model;

import org.example.enums.*;

import java.util.List;

public class VisaDecision {

    private final boolean visaRequired;
    private final VisaType visaType;
    private final List<DocumentType> documents;
    private final int processingDays;
    private final List<String> warnings;

    public VisaDecision(
            boolean visaRequired,
            VisaType visaType,
            List<DocumentType> documents,
            int processingDays,
            List<String> warnings
    ) {
        this.visaRequired = visaRequired;
        this.visaType = visaType;
        this.documents = List.copyOf(documents);
        this.processingDays = processingDays;
        this.warnings = List.copyOf(warnings);
    }

    public boolean isVisaRequired() { return visaRequired; }
    public VisaType getVisaType() { return visaType; }
    public List<DocumentType> getDocuments() { return documents; }
    public int getProcessingDays() { return processingDays; }
    public List<String> getWarnings() { return warnings; }
}

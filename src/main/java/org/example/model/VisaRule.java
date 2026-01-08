package org.example.model;

import org.example.enums.*;

import java.util.List;

public class VisaRule {

    private final Country country;
    private final Country passportCountry;
    private final TravelPurpose travelPurpose;
    private final int maxStayDays;
    private final boolean visaRequired;
    private final VisaType visaType;
    private final List<DocumentType> documents;
    private final int processingDays;

    public VisaRule(
            Country country,
            Country passportCountry,
            TravelPurpose travelPurpose,
            int maxStayDays,
            boolean visaRequired,
            VisaType visaType,
            List<DocumentType> documents,
            int processingDays
    ) {
        this.country = country;
        this.passportCountry = passportCountry;
        this.travelPurpose = travelPurpose;
        this.maxStayDays = maxStayDays;
        this.visaRequired = visaRequired;
        this.visaType = visaType;
        this.documents = List.copyOf(documents);
        this.processingDays = processingDays;
    }

    public Country getCountry() { return country; }
    public Country getPassportCountry() { return passportCountry; }
    public TravelPurpose getTravelPurpose() { return travelPurpose; }
    public int getMaxStayDays() { return maxStayDays; }
    public boolean isVisaRequired() { return visaRequired; }
    public VisaType getVisaType() { return visaType; }
    public List<DocumentType> getDocuments() { return documents; }
    public int getProcessingDays() { return processingDays; }
}

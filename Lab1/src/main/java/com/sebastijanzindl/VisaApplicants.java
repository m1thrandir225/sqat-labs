package com.sebastijanzindl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VisaApplicants {
    public static List<String> applicantsForBothVisas(
            List<String> ukVisaApplicants,
            List<String> usaVisaApplicants
    ) {
        if(ukVisaApplicants == null || usaVisaApplicants == null) {
            throw new NullPointerException("One of the lists is null");
        }

        Set<String> ukApplicaitonSet = new HashSet<String>(ukVisaApplicants);
        Set<String> common = new HashSet<String>();


        for (String applicant: usaVisaApplicants) {
            if(ukApplicaitonSet.contains(applicant)) {
                common.add(applicant);
            }
        }

        if(common.isEmpty()) {
            return  null;
        } else {
            return new ArrayList<String>(common);
        }
    }
}

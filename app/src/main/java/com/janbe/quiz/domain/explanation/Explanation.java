package com.janbe.quiz.domain.explanation;

import java.util.Locale;

public class Explanation {
    private String explanationEn;
    private String explanationNl;

    public Explanation(String explanationEn, String explanationNl) {
        this.explanationEn = explanationEn;
        this.explanationNl = explanationNl;

    }

    public String getExplanation() {

        if (Locale.getDefault().getDisplayLanguage().contentEquals("en")) {
            return explanationEn;

        } else {
            return explanationNl;

        }

    }

}

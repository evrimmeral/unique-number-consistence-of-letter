package com.siemenscase.uniquenumberconsistanceofletter.util;

public class TestCaseEnums {

    public enum CharacterSetTypes {
        UPPER("Upper"),
        NUMERIC("Numeric"),
        SINGLE("Single"),
        VALID("Valid"),
        COMPOSITE_INVALID("CompositeInvalid"),
        COMPOSITE_VALID("CompositeValid");

        private final String value;

        CharacterSetTypes(final String value) {
            this.value = value;
        }
        public String getValue(){return value;}
    }
}

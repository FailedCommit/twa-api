package com.twa.flights.architecture.general;

public class ArchitectureConstants {

    // Suffixes
    public static final String CONTROLLER_SUFFIX = "Controller";
    public static final String RESOURCES_SUFFIX = "Resources";

    // Packages
    public static final String CONTROLLER_PACKAGE = "..controller..";
    public static final String RESOURCES_PACKAGE = "..controller.documentation..";

    // Explanations
    public static final String NAMING_EXPLANATION = "Classes in %s package should be named with %s suffix";

    private ArchitectureConstants() {

    }

    public static String namingExplanation(String packageName, String suffix) {
        return String.format(NAMING_EXPLANATION, packageName, suffix);
    }
}

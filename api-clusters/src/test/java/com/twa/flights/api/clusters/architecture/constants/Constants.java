package com.twa.flights.api.clusters.architecture.constants;

public class Constants {
    public static final String CONTROLLER_SUFFIX = "Controller";
    public static final String RESOURCES_SUFFIX = "Resources";
    public static final String CONTROLLER_PACKAGE = "..controller..";
    public static final String RESOURCES_PACKAGE = "..controller.documentation..";
    public static final String ANNOTATED_EXPLANATION = "Classes in %s package should be annotated with %s";
    public static final String NAMING = "Classes in %s package should be named with %s suffix";
    public static final String DEFAULT_PACKAGE = "com.twa.flights.api";
    public static final String DTO_PACKAGE = "..dto..";

    private Constants() {
    }

    public static String naming(String packageName, String suffix) {
        return String.format(NAMING, packageName, suffix);
    }
}

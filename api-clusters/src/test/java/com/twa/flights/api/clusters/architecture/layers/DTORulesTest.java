package com.twa.flights.api.clusters.architecture.layers;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import com.twa.flights.api.clusters.architecture.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import static com.twa.flights.api.clusters.architecture.rules.AccessFieldsRule.fieldsShouldHaveSettersAndGetters;

@AnalyzeClasses(packages = Constants.DEFAULT_PACKAGE, importOptions = ImportOption.DoNotIncludeTests.class)
public class DTORulesTest {

    @ArchTest
    static final ArchRule fieldsShouldHaveSetterAndGetterRule = fieldsShouldHaveSettersAndGetters(excludedClasses(),
            Constants.DTO_PACKAGE);

    private static Map<String, String> excludedClasses() {
        String classExclusion = "com.twa.flights.api.clusters.dto.ErrorDTO";
        Map<String, String> exclusions = new HashMap<>();
        exclusions.put("code", classExclusion);
        exclusions.put("shortDescription", classExclusion);
        exclusions.put("reasons", classExclusion);
        return exclusions;
    }
}

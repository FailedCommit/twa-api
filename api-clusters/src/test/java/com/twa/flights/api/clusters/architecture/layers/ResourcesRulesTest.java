package com.twa.flights.api.clusters.architecture.layers;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;
import static com.twa.flights.api.clusters.architecture.constants.Constants.RESOURCES_PACKAGE;
import static com.twa.flights.api.clusters.architecture.constants.Constants.naming;

public @AnalyzeClasses(packages = "com.twa.flights.api", importOptions = ImportOption.DoNotIncludeTests.class) class ResourcesRulesTest {
    @ArchTest
    static final ArchRule classesInResourcesShouldBeNamedProperly = classes().that()
            .resideInAPackage("..controller.documentation..").should().haveSimpleNameEndingWith("Resources")
            .because(naming("..controller.documentation..", "Resources"));

    @ArchTest
    static final ArchRule resourcesMethodsShouldBeAnnotated = methods().that().areDeclaredInClassesThat()
            .resideInAPackage(RESOURCES_PACKAGE).should().beAnnotatedWith(Operation.class).orShould()
            .beAnnotatedWith(Parameter.class).orShould().beAnnotatedWith(ApiResponse.class)
            .because("Resource methods should be annotated by Swagger annotations");
}
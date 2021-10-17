package com.twa.flights.api.clusters.architecture.general;

import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import ch.qos.logback.classic.Logger;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

@AnalyzeClasses(packages = "com.twa.flights.api", importOptions = ImportOption.DoNotIncludeTests.class)
public class GeneralCodingRulesTest {
    @ArchTest
    static final ArchRule loggersRule = fields().that().haveRawType(Logger.class).should().bePrivate().andShould()
            .beStatic().andShould().beFinal().andShould().haveName("LOGGER")
            .because("The loggers should be private, static, final, and with the name LOGGER");

    @ArchTest
    static final ArchRule finalStaticVariablesInUppercase = fields().that().areStatic().and().areFinal().and()
            .doNotHaveName("serialVersionUID").and().doNotHaveModifier(JavaModifier.SYNTHETIC).should()
            .haveNameMatching(".*^[A-Z].*").because("Final static fields should be named in uppercase");
}

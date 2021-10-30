package com.twa.flights.architecture.rules;

import com.societegenerale.commons.plugin.rules.ArchRuleTest;
import com.societegenerale.commons.plugin.service.ScopePathProvider;
import com.societegenerale.commons.plugin.utils.ArchUtils;
import com.twa.flights.architecture.general.Constants;

import java.util.Collection;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.twa.flights.architecture.general.Constants.*;

public class ControllerShouldBeNameProperlyRuleTest implements ArchRuleTest {

    @Override
    public void execute(String packagePath, ScopePathProvider scopePathProvider, Collection<String> excludedPaths) {
        classes().that().resideOutsideOfPackage(CONTROLLER_PACKAGE).should()
                .haveSimpleNameNotEndingWith(CONTROLLER_SUFFIX)
                .because(naming(Constants.CONTROLLER_PACKAGE, CONTROLLER_SUFFIX))
                .check(ArchUtils.importAllClassesInPackage(scopePathProvider.getMainClassesPath(), packagePath));

    }
}
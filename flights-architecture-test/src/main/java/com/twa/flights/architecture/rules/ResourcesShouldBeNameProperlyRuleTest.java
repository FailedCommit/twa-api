package com.twa.flights.architecture.rules;

import com.societegenerale.commons.plugin.rules.ArchRuleTest;
import com.societegenerale.commons.plugin.service.ScopePathProvider;
import com.societegenerale.commons.plugin.utils.ArchUtils;
import com.twa.flights.architecture.general.Constants;

import java.util.Collection;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.twa.flights.architecture.general.Constants.*;

public class ResourcesShouldBeNameProperlyRuleTest implements ArchRuleTest {

    @Override
    public void execute(String packagePath, ScopePathProvider scopePathProvider, Collection<String> excludedPaths) {
        classes().that().resideOutsideOfPackage(RESOURCES_PACKAGE).should()
                .haveSimpleNameNotEndingWith(RESOURCES_SUFFIX)
                .because(naming(Constants.RESOURCES_PACKAGE, RESOURCES_SUFFIX))
                .check(ArchUtils.importAllClassesInPackage(scopePathProvider.getMainClassesPath(), packagePath));
    }
}

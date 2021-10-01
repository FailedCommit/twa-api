package com.twa.flights.api.clusters.architecture.layers;

import com.societegenerale.commons.plugin.model.RootClassFolder;
import com.societegenerale.commons.plugin.rules.ArchRuleTest;
import com.societegenerale.commons.plugin.service.ScopePathProvider;
import com.societegenerale.commons.plugin.utils.ArchUtils;
import com.twa.flights.api.clusters.architecture.general.ArchitectureConstants;

import java.util.Collection;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ControllerShouldBeNameProperlyRuleTest implements ArchRuleTest {

    @Override
    public void execute(String packagePath, ScopePathProvider scopePathProvider, Collection<String> excludedPaths) {
        classes().that().resideOutsideOfPackage(ArchitectureConstants.CONTROLLER_PACKAGE).should()
                .haveSimpleNameNotEndingWith(ArchitectureConstants.CONTROLLER_SUFFIX)
                .because(ArchitectureConstants.namingExplanation(ArchitectureConstants.CONTROLLER_PACKAGE,
                        ArchitectureConstants.CONTROLLER_SUFFIX))
                .check(ArchUtils.importAllClassesInPackage(scopePathProvider.getMainClassesPath(), packagePath));
    }
}

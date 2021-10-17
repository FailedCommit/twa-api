package com.twa.flights.api.clusters.architecture.rules;

import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;

public class AccessFieldsRule {
    private AccessFieldsRule() {
    }

    public static ArchRule fieldsShouldHaveSettersAndGetters(Map<String, String> exclusions, String... packageNames) {
        return fields().that().areDeclaredInClassesThat().resideInAnyPackage(packageNames).and()
                .areDeclaredInClassesThat().areNotMemberClasses().and().arePrivate().and().areNotFinal().and()
                .areNotStatic().should(buildFieldHaveGetterAndSetterCondition(exclusions))
                .because("Private fields should have setters and getters in " + Arrays.toString(packageNames));
    }

    private static ArchCondition<JavaField> buildFieldHaveGetterAndSetterCondition(Map<String, String> exclusions) {
        return new ArchCondition<JavaField>("getters and setters") {

            @Override
            public void check(JavaField field, ConditionEvents events) {
                Set<String> publicMethods = field.getOwner().getMethods().stream()
                        .filter(m -> m.getModifiers().contains(JavaModifier.PUBLIC)).map(JavaMember::getName)
                        .collect(Collectors.toSet());
                if (exclusions.containsKey(field.getName())) {
                    String className = exclusions.get(field.getName());
                    if (field.getOwner().getName().equals(className)) {
                        return;
                    }
                }
                String getter = getterPrefix(field.reflect().getType().getName()) + startWithCaps(field.getName());
                if (!publicMethods.contains(getter)) {
                    String message = String.format("Field %s of %s does not have %s", field.getName(),
                            field.getOwner().getName(), "get");
                    events.add(SimpleConditionEvent.violated(field, message));
                }

                String setter = "set" + startWithCaps(field.getName());
                if (!publicMethods.contains(setter)) {
                    String message = String.format("Field %s of %s does not have %s", field.getName(),
                            field.getOwner().getName(), "set");
                    events.add(SimpleConditionEvent.violated(field, message));
                }

            }
        };
    }

    private static String startWithCaps(String value) {
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

    private static String getterPrefix(String type) {
        return !type.equals("boolean") ? "get" : "is";
    }
}
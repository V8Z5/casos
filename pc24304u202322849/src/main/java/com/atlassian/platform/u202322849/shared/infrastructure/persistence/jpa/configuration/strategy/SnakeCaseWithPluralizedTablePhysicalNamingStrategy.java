package com.atlassian.platform.u202322849.shared.infrastructure.persistence.jpa.configuration.strategy;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

/** Converts database identifiers to snake_case and pluralizes table names.
 * @author Marlon Packard Viza Quispe
 */
public class SnakeCaseWithPluralizedTablePhysicalNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {
    @Override
    public Identifier toPhysicalTableName(Identifier logicalName, JdbcEnvironment jdbcEnvironment) {
        Identifier snakeCase = super.toPhysicalTableName(logicalName, jdbcEnvironment);
        if (snakeCase == null) return null;
        String tableName = snakeCase.getText();
        if (!tableName.endsWith("s")) tableName += "s";
        return Identifier.toIdentifier(tableName, snakeCase.isQuoted());
    }
}

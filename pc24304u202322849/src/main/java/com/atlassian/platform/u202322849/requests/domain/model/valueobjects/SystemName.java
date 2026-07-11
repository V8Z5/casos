package com.atlassian.platform.u202322849.requests.domain.model.valueobjects;

/** Systems available for access requests.
 * @author Marlon Packard Viza Quispe
 */
public enum SystemName {
    JIRA, CONFLUENCE, BITBUCKET, TRELLO;

    public static SystemName from(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("requestedSystem is required.");
        try {
            return valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid requestedSystem. Allowed values: JIRA, CONFLUENCE, BITBUCKET, TRELLO.");
        }
    }
}

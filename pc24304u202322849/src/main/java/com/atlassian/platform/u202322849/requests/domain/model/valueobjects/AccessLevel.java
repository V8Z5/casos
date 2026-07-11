package com.atlassian.platform.u202322849.requests.domain.model.valueobjects;

/** Access levels available for a request.
 * @author Marlon Packard Viza Quispe
 */
public enum AccessLevel {
    READ, WRITE, ADMIN;

    public static AccessLevel from(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("accessLevel is required.");
        try {
            return valueOf(value.trim().toUpperCase());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException("Invalid accessLevel. Allowed values: READ, WRITE, ADMIN.");
        }
    }
}

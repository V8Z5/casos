package com.atlassian.platform.u202322849.requests.domain.model.exceptions;

/** Base exception for domain business-rule violations.
 * @author Marlon Packard Viza Quispe
 */
public class BusinessRuleException extends RuntimeException {
    public BusinessRuleException(String message) { super(message); }
}

package com.atlassian.platform.u202322849.requests.domain.model.exceptions;

import com.atlassian.platform.u202322849.requests.domain.model.valueobjects.SystemName;

/** Raised when a pending request already exists for the requested system.
 * @author Marlon Packard Viza Quispe
 */
public class DuplicatePendingAccessRequestException extends BusinessRuleException {
    public DuplicatePendingAccessRequestException(SystemName systemName) {
        super("A PENDING access request already exists for system " + systemName + ".");
    }
}

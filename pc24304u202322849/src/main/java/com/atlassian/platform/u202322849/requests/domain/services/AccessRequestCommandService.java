package com.atlassian.platform.u202322849.requests.domain.services;

import com.atlassian.platform.u202322849.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u202322849.requests.domain.model.commands.CreateAccessRequestCommand;

/** Command service contract for access requests.
 * @author Marlon Packard Viza Quispe
 */
public interface AccessRequestCommandService {
    AccessRequest handle(CreateAccessRequestCommand command);
}

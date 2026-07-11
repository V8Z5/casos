package com.atlassian.platform.u202322849.requests.interfaces.rest.transform;

import com.atlassian.platform.u202322849.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.u202322849.requests.interfaces.rest.resources.CreateAccessRequestResource;

/** Assembles a create command from a REST resource.
 * @author Marlon Packard Viza Quispe
 */
public final class CreateAccessRequestCommandFromResourceAssembler {
    private CreateAccessRequestCommandFromResourceAssembler() {}

    public static CreateAccessRequestCommand toCommandFromResource(Long employeeId, CreateAccessRequestResource resource) {
        return new CreateAccessRequestCommand(employeeId, resource.requestedSystem(), resource.accessLevel(),
                resource.justification(), resource.startDate(), resource.endDate());
    }
}

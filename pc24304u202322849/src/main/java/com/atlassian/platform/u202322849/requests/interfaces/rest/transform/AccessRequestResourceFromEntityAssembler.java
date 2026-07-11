package com.atlassian.platform.u202322849.requests.interfaces.rest.transform;

import com.atlassian.platform.u202322849.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u202322849.requests.interfaces.rest.resources.AccessRequestResource;

/** Assembles an access request REST resource from the aggregate root.
 * @author Marlon Packard Viza Quispe
 */
public final class AccessRequestResourceFromEntityAssembler {
    private AccessRequestResourceFromEntityAssembler() {}

    public static AccessRequestResource toResourceFromEntity(AccessRequest entity) {
        return new AccessRequestResource(
                entity.getId(),
                entity.getEmployeeId().getValue(),
                entity.getRequestedSystem().name(),
                entity.getAccessLevel().name(),
                entity.getJustification().getValue(),
                entity.getAccessPeriod().getStartDate(),
                entity.getAccessPeriod().getEndDate(),
                entity.getStatus().name(),
                entity.getRequestedAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
    }
}

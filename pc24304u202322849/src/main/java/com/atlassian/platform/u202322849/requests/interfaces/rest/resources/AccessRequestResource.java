package com.atlassian.platform.u202322849.requests.interfaces.rest.resources;

import java.time.LocalDateTime;

/** Resource returned by the access requests API.
 * @author Marlon Packard Viza Quispe
 */
public record AccessRequestResource(
        Long id,
        Long employeeId,
        String requestedSystem,
        String accessLevel,
        String justification,
        LocalDateTime startDate,
        LocalDateTime endDate,
        String status,
        LocalDateTime requestedAt,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

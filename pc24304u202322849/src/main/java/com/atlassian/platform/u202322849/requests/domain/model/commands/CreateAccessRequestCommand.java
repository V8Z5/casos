package com.atlassian.platform.u202322849.requests.domain.model.commands;

import java.time.LocalDateTime;

/** Command used to create an access request.
 * @author Marlon Packard Viza Quispe
 */
public record CreateAccessRequestCommand(
        Long employeeId,
        String requestedSystem,
        String accessLevel,
        String justification,
        LocalDateTime startDate,
        LocalDateTime endDate
) {}

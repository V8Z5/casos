package com.atlassian.platform.u202322849.requests.interfaces.rest.resources;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

/** Request body used to create an access request.
 * @author Marlon Packard Viza Quispe
 */
public record CreateAccessRequestResource(
        @NotBlank(message = "requestedSystem is required.") String requestedSystem,
        @NotBlank(message = "accessLevel is required.") String accessLevel,
        @NotBlank(message = "justification is required.")
        @Size(min = 25, max = 500, message = "justification must contain between 25 and 500 characters.")
        String justification,
        @NotNull(message = "startDate is required.") LocalDateTime startDate,
        @NotNull(message = "endDate is required.") LocalDateTime endDate
) {}

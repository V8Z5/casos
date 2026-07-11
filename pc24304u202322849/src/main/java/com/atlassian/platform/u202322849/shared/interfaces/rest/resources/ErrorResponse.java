package com.atlassian.platform.u202322849.shared.interfaces.rest.resources;

import java.time.LocalDateTime;

/** Standard API error response.
 * @author Marlon Packard Viza Quispe
 */
public record ErrorResponse(
        int status,
        String error,
        String message,
        String path,
        LocalDateTime timestamp
) {}

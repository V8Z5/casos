package com.atlassian.platform.u202322849.requests.interfaces.rest;

import com.atlassian.platform.u202322849.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u202322849.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.u202322849.requests.domain.services.AccessRequestCommandService;
import com.atlassian.platform.u202322849.requests.interfaces.rest.resources.AccessRequestResource;
import com.atlassian.platform.u202322849.requests.interfaces.rest.resources.CreateAccessRequestResource;
import com.atlassian.platform.u202322849.requests.interfaces.rest.transform.AccessRequestResourceFromEntityAssembler;
import com.atlassian.platform.u202322849.requests.interfaces.rest.transform.CreateAccessRequestCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/** REST controller for employee access requests.
 * @author Marlon Packard Viza Quispe
 */
@Validated
@RestController
@RequestMapping("/api/v1/employees/{employeeId}/access-requests")
@Tag(name = "Access Requests", description = "Employee access request operations")
public class AccessRequestsController {
    private final AccessRequestCommandService accessRequestCommandService;

    public AccessRequestsController(AccessRequestCommandService accessRequestCommandService) {
        this.accessRequestCommandService = accessRequestCommandService;
    }

    @PostMapping
    @Operation(summary = "Create an access request", description = "Registers a new PENDING access request for an employee.")
    @ApiResponse(responseCode = "201", description = "Access request created")
    @ApiResponse(responseCode = "400", description = "Invalid request data")
    @ApiResponse(responseCode = "409", description = "A pending request already exists for the requested system")
    public ResponseEntity<AccessRequestResource> createAccessRequest(
            @PathVariable @Positive(message = "employeeId must be greater than zero.") Long employeeId,
            @Valid @RequestBody CreateAccessRequestResource resource) {
        CreateAccessRequestCommand command = CreateAccessRequestCommandFromResourceAssembler
                .toCommandFromResource(employeeId, resource);
        AccessRequest accessRequest = accessRequestCommandService.handle(command);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(AccessRequestResourceFromEntityAssembler.toResourceFromEntity(accessRequest));
    }
}

package com.atlassian.platform.u202322849.requests.domain.model.aggregates;

import com.atlassian.platform.u202322849.requests.domain.model.exceptions.BusinessRuleException;
import com.atlassian.platform.u202322849.requests.domain.model.valueobjects.*;
import com.atlassian.platform.u202322849.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import java.time.LocalDateTime;

/** Aggregate root representing an employee access request.
 * @author Marlon Packard Viza Quispe
 */
@Getter
@Entity
@Table(name = "access_requests")
public class AccessRequest extends AuditableAbstractAggregateRoot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private EmployeeId employeeId;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private SystemName requestedSystem;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private AccessLevel accessLevel;

    @Embedded
    private Justification justification;

    @Embedded
    private DateRange accessPeriod;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private RequestStatus status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime requestedAt;

    protected AccessRequest() {}

    public AccessRequest(EmployeeId employeeId, SystemName requestedSystem,
                         AccessLevel accessLevel, Justification justification,
                         DateRange accessPeriod) {
        if (requestedSystem == null) throw new BusinessRuleException("requestedSystem is required.");
        if (accessLevel == null) throw new BusinessRuleException("accessLevel is required.");
        if (requestedSystem == SystemName.BITBUCKET && accessLevel == AccessLevel.ADMIN)
            throw new BusinessRuleException("BITBUCKET does not allow ADMIN access level.");
        this.employeeId = employeeId;
        this.requestedSystem = requestedSystem;
        this.accessLevel = accessLevel;
        this.justification = justification;
        this.accessPeriod = accessPeriod;
        this.status = RequestStatus.PENDING;
        this.requestedAt = LocalDateTime.now();
    }
}

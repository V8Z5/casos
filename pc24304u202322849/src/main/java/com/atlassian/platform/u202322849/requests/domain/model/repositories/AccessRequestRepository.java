package com.atlassian.platform.u202322849.requests.domain.model.repositories;

import com.atlassian.platform.u202322849.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u202322849.requests.domain.model.valueobjects.RequestStatus;
import com.atlassian.platform.u202322849.requests.domain.model.valueobjects.SystemName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repository for access request aggregate roots.
 * @author Marlon Packard Viza Quispe
 */
@Repository
public interface AccessRequestRepository extends JpaRepository<AccessRequest, Long> {
    boolean existsByRequestedSystemAndStatus(SystemName requestedSystem, RequestStatus status);
}

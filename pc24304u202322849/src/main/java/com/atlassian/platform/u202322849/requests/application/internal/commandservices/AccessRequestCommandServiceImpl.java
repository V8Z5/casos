package com.atlassian.platform.u202322849.requests.application.internal.commandservices;

import com.atlassian.platform.u202322849.requests.domain.model.aggregates.AccessRequest;
import com.atlassian.platform.u202322849.requests.domain.model.commands.CreateAccessRequestCommand;
import com.atlassian.platform.u202322849.requests.domain.model.exceptions.DuplicatePendingAccessRequestException;
import com.atlassian.platform.u202322849.requests.domain.model.repositories.AccessRequestRepository;
import com.atlassian.platform.u202322849.requests.domain.model.valueobjects.*;
import com.atlassian.platform.u202322849.requests.domain.services.AccessRequestCommandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Application command handler for access requests.
 * @author Marlon Packard Viza Quispe
 */
@Service
public class AccessRequestCommandServiceImpl implements AccessRequestCommandService {
    private final AccessRequestRepository accessRequestRepository;

    public AccessRequestCommandServiceImpl(AccessRequestRepository accessRequestRepository) {
        this.accessRequestRepository = accessRequestRepository;
    }

    @Override
    @Transactional
    public AccessRequest handle(CreateAccessRequestCommand command) {
        EmployeeId employeeId = new EmployeeId(command.employeeId());
        SystemName systemName = SystemName.from(command.requestedSystem());
        AccessLevel accessLevel = AccessLevel.from(command.accessLevel());
        Justification justification = new Justification(command.justification());
        DateRange accessPeriod = new DateRange(command.startDate(), command.endDate());

        if (accessRequestRepository.existsByRequestedSystemAndStatus(systemName, RequestStatus.PENDING))
            throw new DuplicatePendingAccessRequestException(systemName);

        return accessRequestRepository.save(new AccessRequest(
                employeeId, systemName, accessLevel, justification, accessPeriod));
    }
}

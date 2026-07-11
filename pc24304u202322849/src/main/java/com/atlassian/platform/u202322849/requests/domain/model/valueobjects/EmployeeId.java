package com.atlassian.platform.u202322849.requests.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import java.util.Objects;

/** Identifies an employee from another bounded context.
 * @author Marlon Packard Viza Quispe
 */
@Getter
@Embeddable
public class EmployeeId {
    @Column(name = "employee_id", nullable = false)
    private Long value;

    protected EmployeeId() {}

    public EmployeeId(Long value) {
        if (value == null || value <= 0) throw new IllegalArgumentException("employeeId must be greater than zero.");
        this.value = value;
    }

    @Override public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof EmployeeId that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override public int hashCode() { return Objects.hash(value); }
}

package com.atlassian.platform.u202322849.requests.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import java.util.Objects;

/** Contains the business justification for an access request.
 * @author Marlon Packard Viza Quispe
 */
@Getter
@Embeddable
public class Justification {
    @Column(name = "justification", nullable = false, length = 500)
    private String value;

    protected Justification() {}

    public Justification(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("justification is required.");
        String normalized = value.trim();
        if (normalized.length() < 25 || normalized.length() > 500)
            throw new IllegalArgumentException("justification must contain between 25 and 500 characters.");
        this.value = normalized;
    }

    @Override public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Justification that)) return false;
        return Objects.equals(value, that.value);
    }

    @Override public int hashCode() { return Objects.hash(value); }
}

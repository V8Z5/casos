package com.atlassian.platform.u202322849.requests.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import java.time.LocalDateTime;
import java.util.Objects;

/** Represents an embedded date-time range.
 * @author Marlon Packard Viza Quispe
 */
@Getter
@Embeddable
public class DateRange {
    @Column(name = "start_date", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDateTime endDate;

    protected DateRange() {}

    public DateRange(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) throw new IllegalArgumentException("startDate and endDate are required.");
        if (!startDate.isBefore(endDate)) throw new IllegalArgumentException("startDate must be before endDate.");
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof DateRange that)) return false;
        return Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate);
    }

    @Override public int hashCode() { return Objects.hash(startDate, endDate); }
}

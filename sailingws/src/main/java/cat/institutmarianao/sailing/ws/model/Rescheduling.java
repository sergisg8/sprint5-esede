package cat.institutmarianao.sailing.ws.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(Action.RESCHEDULING)
public class Rescheduling extends Action {
	private static final long serialVersionUID = 1L;

	@Column(name = "reason", nullable = false)
	private String reason;

	@Column(name = "old_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date oldDate;

	@Column(name = "old_departure", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date oldDeparture;

	@Column(name = "new_date", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date newDate;

	@Column(name = "new_departure", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date newDeparture;

	@Override
	public String getInfo() {
		return this.reason;
	}
}

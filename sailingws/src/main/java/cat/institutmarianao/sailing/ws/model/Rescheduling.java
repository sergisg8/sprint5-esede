package cat.institutmarianao.sailing.ws.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/* Lombok */
@Data
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Rescheduling extends Action {
	private static final long serialVersionUID = 1L;

	private String reason;
	
	private Date oldDate;

	private Date oldDeparture;
	
	private Date newDate;

	private Date newDeparture;
	
	@Override
	public String getInfo() {
		return this.reason;
	}
}

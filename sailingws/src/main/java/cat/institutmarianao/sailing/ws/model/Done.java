package cat.institutmarianao.sailing.ws.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
@DiscriminatorValue(Action.DONE)
public class Done extends Action {
	private static final long serialVersionUID = 1L;

	@Column(name = "comments", length = 500)
	private String comments;

	@Override
	public String getInfo() {
		return this.comments;
	}
}

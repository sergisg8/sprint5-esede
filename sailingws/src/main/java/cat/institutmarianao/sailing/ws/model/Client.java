package cat.institutmarianao.sailing.ws.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@DiscriminatorValue(User.CLIENT)
public class Client extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final int MIN_FULL_NAME = 3;
	public static final int MAX_FULL_NAME = 100;

	@Size(min = MIN_FULL_NAME, max = MAX_FULL_NAME)
	@NotNull
	@Column(name = "full_name", nullable = false, length = MAX_FULL_NAME)
	protected String fullName;

	@NotNull
	@Pattern(regexp = "\\d{9}", message = "Phone number must have 9 digits")
	@Column(name = "phone", nullable = false, unique = true)
	protected Integer phone;

	@Override
	public String getInfo() {
		return this.fullName + " (" + this.phone + ")";
	}
}

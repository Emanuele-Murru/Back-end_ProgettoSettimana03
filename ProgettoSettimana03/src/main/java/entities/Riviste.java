package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("Magazine")

public class Riviste extends Prodotto {
	@Enumerated(EnumType.STRING)
	private Periodicita periodicita;

	public Riviste(Long isbnCode, String titolo, int annoPubblicazione, int numPagine,
			Periodicita periodicita) {
		super(isbnCode, titolo, annoPubblicazione, numPagine);
		this.setPeriodicita(periodicita);
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", getIsbnCode()=" + getIsbnCode() + ", getTitolo()=" + getTitolo()
				+ ", getAnnoPubblicazione()=" + getAnnoPubblicazione() + ", getNumPagine()=" + getNumPagine()
				+ "]";
	}
}
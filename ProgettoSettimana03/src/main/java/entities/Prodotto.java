package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Inheritance( strategy = InheritanceType.JOINED)
@Table (name = "Prodotto")
public abstract class Prodotto {
	
	@Id
	private Long isbnCode;
	private String titolo;
	private int annoPubblicazione;
	private int numPagine;

	public Prodotto(Long _isbnCode, String _titolo, int annoPubblicazione, int _numPagine) {
		super();
		this.isbnCode = _isbnCode;
		this.titolo = _titolo;
		this.annoPubblicazione = annoPubblicazione;
		this.numPagine = _numPagine;
	}

	@Override
	public String toString() {
		return "Elemento [isbn=" + isbnCode + ", titolo=" + titolo + ", annoPubblicazione=" + annoPubblicazione
				+ ", numeroPagine=" + numPagine + "]";
	}
}

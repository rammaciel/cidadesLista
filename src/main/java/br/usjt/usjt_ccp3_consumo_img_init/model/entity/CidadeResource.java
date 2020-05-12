package br.usjt.usjt_ccp3_consumo_img_init.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class CidadeResource {
	@Id
	@NotNull 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Size(max=200, message="Tamanho entre 1 e 200 caracteres")
	private String posterPath;
	private String longitude;
	
	private String latitude;
	
	private String nome;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getlatitude() {
		return latitude;
	}
	public void setlatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "CidadeResource [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", nome=" + nome
				+ "]";
	}
	public String getPosterPath() {
		return posterPath;
	}
	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}

}

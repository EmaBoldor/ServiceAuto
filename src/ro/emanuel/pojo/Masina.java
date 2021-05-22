package ro.emanuel.pojo;

public class Masina {

	private int id;
	private String marca;
	private String model;
	private String culoare;
	
	public Masina() {
		super();
	}

	public Masina(int id, String marca, String model, String culoare) {
		super();
		this.id = id;
		this.marca = marca;
		this.model = model;
		this.culoare = culoare;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCuloare() {
		return culoare;
	}

	public void setCuloare(String culoare) {
		this.culoare = culoare;
	}
	
	
}

package ro.emanuel.pojo;

public class Client {

	private int id;
	private String nume;
	private String email;
	private int telefon;
	
	public Client() {
		super();
	}

	public Client(int id, String nume, String email, int telefon) {
		super();
		this.id = id;
		this.nume = nume;
		this.email = email;
		this.telefon = telefon;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefon() {
		return telefon;
	}

	public void setTelefon(int telefon) {
		this.telefon = telefon;
	}
	
	
}

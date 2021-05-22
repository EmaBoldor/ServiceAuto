package ro.emanuel.pojo;

public class Angajat {

	private int id;
	private String nume;
	private int vechime ;
	private String calificare;
	
	public Angajat() {
		super();
	}

	public Angajat(int id, String nume, int vechime, String calificare) {
		super();
		this.id = id;
		this.nume = nume;
		this.vechime = vechime;
		this.calificare = calificare;
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

	public int getVechime() {
		return vechime;
	}

	public void setVechime(int vechime) {
		this.vechime = vechime;
	}

	public String getCalificare() {
		return calificare;
	}

	public void setCalificare(String calificare) {
		this.calificare = calificare;
	}
	
	
}

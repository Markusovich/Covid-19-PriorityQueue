package source;

public class Patient<T> {
	
	String fstnme = null;
	String lstnme = null;
	int age = 0;
	String risklevel = null;
	
	public Patient(String fstnme, String lstnme, int age, String risklevel) {
		super();
		this.fstnme = fstnme;
		this.lstnme = lstnme;
		this.age = age;
		this.risklevel = risklevel;
	}

	public String getFstnme() {
		return fstnme;
	}
	public void setFstnme(String fstnme) {
		this.fstnme = fstnme;
	}
	public String getLstnme() {
		return lstnme;
	}
	public void setLstnme(String lstnme) {
		this.lstnme = lstnme;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRisklevel() {
		return risklevel;
	}
	public void setRisklevel(String risklevel) {
		this.risklevel = risklevel;
	}

}

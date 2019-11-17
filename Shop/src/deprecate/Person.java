/*person nome cognome classe e data
 * di un insegnante stipendio e materie
 * di uno studente voglio sapere la sezione, l'anno(1,2,3,4,5) e average(media)
 */
package deprecate;

public abstract class Person extends Entity {
	
	private int id;
	private String name, surname, dob;
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getDob() {
		return dob;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@Override
	public String toString() {
		return super.toString() + "id: " + id + ",\n" + (name != null ? "name: " + name + ",\n" : "")
				+ (surname != null ? "surname: " + surname + ",\n" : "") + (dob != null ? "dob: " + dob : "")+ "\n";
	}
	
	@Override
	public boolean valid()
	{
		return 
				id>0						&&
				name!=null					&&
				surname!=null				&&
				!name.contentEquals("")		&&
				!surname.contentEquals("")	&&
				dob!=null					&&
				!dob.contentEquals("");

	}

}

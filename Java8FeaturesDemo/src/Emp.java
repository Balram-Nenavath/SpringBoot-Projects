import java.util.List;
import java.util.Objects;

public class Emp {

	private int id;
	private String name;
	private String email;
    private int salary;

	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int id, String name, String email, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.salary = salary;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getsalary() {
		return salary;
	}

	public void setsalarys(int salary) {
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	
	  @Override 
	  public int hashCode()
	  {
		  return Objects.hash(id, name); 
		  }
	 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	public void setName(String name) {
		this.name = name;
	}

}

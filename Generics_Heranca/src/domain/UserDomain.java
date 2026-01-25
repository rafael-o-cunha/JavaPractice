package domain;

public class UserDomain extends GenericDomain<Integer> {
    
    private String name;
    private Integer age;

    public UserDomain(Integer id, String name, Integer age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public UserDomain() {

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((age == null) ? 0 : age.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDomain other = (UserDomain) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (age == null) {
            if (other.age != null)
                return false;
        } else if (!age.equals(other.age))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserDomain [name=" + name + ", age=" + age + ", id=" + getId() + "]";
    }
    
}

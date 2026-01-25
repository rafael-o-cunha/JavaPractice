package domain;

public class ClientDomain extends GenericDomain<String> {
    private String name;
    private String age;
    
    public ClientDomain(String id, String name, String age) {
        super(id);
        this.name = name;
        this.age = age;
    }

    public ClientDomain() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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
        ClientDomain other = (ClientDomain) obj;
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
        return "ClientDomain [name=" + name + ", age=" + age + ", id=" + getId() + "]";
    }
    
}

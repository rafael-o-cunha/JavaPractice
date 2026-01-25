import dao.GenericDao;
import dao.UserDao;
import domain.UserDomain;

public class Main {
	
	private static GenericDao<Integer, UserDomain> dao = new UserDao();
	public static void main(String[] args) {

		UserDomain u = new UserDomain(1, "José", 42);
		UserDomain u2 = new UserDomain(2, "Marcos", 40);
		UserDomain u3 = new UserDomain(3, "João", 32);
		UserDomain u4 = new UserDomain(4, "Lucas", 37);
 		
		System.out.println(dao.count());

		System.out.println(dao.save(u));
		
		System.out.println(dao.count());

		System.out.println(dao.save(u2));
		System.out.println(dao.save(u3));
		System.out.println(dao.save(u4));

		System.out.println(dao.findAll());

		System.out.println(dao.delete(u2));

		System.out.println(dao.count());
		System.out.println(dao.findAll());

		System.out.println(dao.find(e -> e.getAge() < 40));

		System.out.println(dao.find(e -> e.getId() == 2));
		System.out.println(dao.find(e -> e.getId() == 3));
	}
}

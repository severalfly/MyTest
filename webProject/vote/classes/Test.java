import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.List;
public class Test
{
	public static void main(String[] args) {
		try
		{
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			List result = session.createQuery( "from tb_vote" ).list();
			System.out.println(result.size());
			session.getTransaction().commit();
			session.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
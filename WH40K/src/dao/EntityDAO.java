package dao;
import java.util.List;

public interface EntityDAO<E extends entities.Entity>
{
	E load(int id) throws Exception;

	List<E> list() throws Exception;
	
	boolean delete(int id) throws Exception;
	
	boolean save(E e) throws Exception;
	
	public List<E> list(String condition) throws Exception;
	
}
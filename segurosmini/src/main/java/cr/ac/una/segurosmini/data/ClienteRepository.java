package cr.ac.una.segurosmini.data;


import cr.ac.una.segurosmini.logic.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends  CrudRepository<Cliente, String>{
}

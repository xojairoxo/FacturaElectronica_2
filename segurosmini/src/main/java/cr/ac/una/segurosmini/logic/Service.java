package cr.ac.una.segurosmini.logic;

import cr.ac.una.segurosmini.data.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service("service")
public class Service {
    @Autowired
    private ClienteRepository clienteRepository;

    public Iterable<Cliente> clienteFindAll() {
        return clienteRepository.findAll();

    }

}

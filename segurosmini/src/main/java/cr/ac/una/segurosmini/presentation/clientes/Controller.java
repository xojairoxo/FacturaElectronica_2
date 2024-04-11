package cr.ac.una.segurosmini.presentation.clientes;

import cr.ac.una.segurosmini.logic.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller("clientes")
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/presentation/clientes/show")
    public String show(Model model){
        model.addAttribute("clientes",service.clienteFindAll());
        return "presentation/clientes/View";
    }
}

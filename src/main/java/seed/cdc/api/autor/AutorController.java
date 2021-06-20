package seed.cdc.api.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("autor")
public class AutorController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void novo(@RequestBody @Valid NovoAutorRequest novoAutor) {
        Autor autor = novoAutor.toModel();
        entityManager.persist(autor);
    }

}

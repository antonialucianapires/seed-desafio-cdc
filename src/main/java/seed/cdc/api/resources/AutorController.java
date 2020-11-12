package seed.cdc.api.resources;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import seed.cdc.api.domain.Autor;
import seed.cdc.api.form.FormNovoAutor;

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
    public void novo(@RequestBody @Valid FormNovoAutor novoAutor) {
        Autor autor = novoAutor.toModel();
        entityManager.persist(autor);
    }

}

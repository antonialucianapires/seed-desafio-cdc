package seed.cdc.api.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class ProibeEmailDuplicadoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override //qual é o tipo de parametro que deveremos aplicar essa validação
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }
        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<Autor> possivelAutor = autorRepository.findByEmail(request.getEmail());
        if(possivelAutor.isPresent()) {
            errors.rejectValue("email", "400", "Já existe um(a) outro(a) autor(a) com o mesmo e-mail: " + request.getEmail());
        }
    }
}

package seed.cdc.api.compartilhado;

import javax.persistence.EntityManager;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Long> {

    private EntityManager manager;

    private Class<?> klass;

    private boolean isOptional;

    public ExistsIdValidator(EntityManager manager) {
        this.manager = manager;
    }

    public void initialize(ExistsId constraint) {
        this.klass = constraint.domainClass();
        this.isOptional = constraint.isOptional();
    }

    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(isOptional) {
            return value == null || manager.find(klass, value) != null;
        }
        return value != null && manager.find(klass, value) != null;
    }

}

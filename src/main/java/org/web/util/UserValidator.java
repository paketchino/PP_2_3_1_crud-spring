package org.web.util;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.web.dao.UserDaoRepository;
import org.web.model.User;

@Component
public class UserValidator implements Validator {

    private final UserDaoRepository userDaoRepository;

    public UserValidator(UserDaoRepository userDaoRepository) {
        this.userDaoRepository = userDaoRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        if (userDaoRepository.findUserByLogin(user.getLogin()).isPresent()) {
            errors.rejectValue("login", "", "This login already taken");
        }
    }
}

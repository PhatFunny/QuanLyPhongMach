/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ntp.validator;

import com.ntp.pojos.User;
import java.util.Set;
import javax.validation.ConstraintViolation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author Phat Nguyen
 */
@Component
public class WebAppValidator implements Validator{
    @Autowired
    private javax.validation.Validator beanValidators; 
    
    private Set<Validator> springValidators;

    @Override
    public boolean supports(Class<?> type) {
        return User.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        //Bean Validator
        Set<ConstraintViolation<Object>> beans = beanValidators.validate(o);
        for(ConstraintViolation<Object> b: beans)
            errors.rejectValue(b.getPropertyPath().toString(), 
                    b.getMessageTemplate(), b.getMessage());
        
        //Spring Validator
        for(Validator v: this.springValidators)
            v.validate(o, errors);
    }
    
    public void setSpringValidators(Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }
    
}

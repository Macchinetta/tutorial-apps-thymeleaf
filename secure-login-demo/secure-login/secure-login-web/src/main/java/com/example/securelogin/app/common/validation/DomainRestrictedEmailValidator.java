/*
 * Copyright(c) 2013 NTT Corporation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package com.example.securelogin.app.common.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DomainRestrictedEmailValidator
        implements ConstraintValidator<DomainRestrictedEmail, CharSequence> {

    private Set<String> allowedDomains;

    private boolean allowSubDomain;

    @Override
    public void initialize(DomainRestrictedEmail constraintAnnotation) {
        allowedDomains = new HashSet<String>(Arrays.asList(constraintAnnotation.allowedDomains()));
        allowSubDomain = constraintAnnotation.allowSubDomain();
    }

    @Override
    public boolean isValid(CharSequence value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        for (String domain : allowedDomains) {
            if (value.toString().endsWith("@" + domain)
                    || (allowSubDomain && value.toString().endsWith("." + domain))) {
                return true;
            }
        }
        return false;
    }

}

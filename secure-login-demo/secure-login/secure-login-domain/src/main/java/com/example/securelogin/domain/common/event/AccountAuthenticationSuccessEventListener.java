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
package com.example.securelogin.domain.common.event;

import javax.inject.Inject;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;
import com.example.securelogin.domain.service.authenticationevent.AuthenticationEventSharedService;
import com.example.securelogin.domain.service.userdetails.LoggedInUser;

@Component
public class AccountAuthenticationSuccessEventListener {

    @Inject
    AuthenticationEventSharedService authenticationEventSharedService;

    @EventListener(AuthenticationSuccessEvent.class)
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        LoggedInUser details = (LoggedInUser) event.getAuthentication().getPrincipal();

        authenticationEventSharedService.authenticationSuccess(details.getUsername());
    }

}

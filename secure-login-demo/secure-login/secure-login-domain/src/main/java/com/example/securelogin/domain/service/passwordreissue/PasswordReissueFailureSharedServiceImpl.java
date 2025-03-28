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
package com.example.securelogin.domain.service.passwordreissue;

import javax.inject.Inject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.date.ClassicDateFactory;
import com.example.securelogin.domain.model.FailedPasswordReissue;
import com.example.securelogin.domain.repository.passwordreissue.FailedPasswordReissueRepository;

@Service
@Transactional
public class PasswordReissueFailureSharedServiceImpl
        implements PasswordReissueFailureSharedService {

    @Inject
    ClassicDateFactory dateFactory;

    @Inject
    FailedPasswordReissueRepository failedPasswordReissueRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void resetFailure(String username, String token) {
        FailedPasswordReissue event = new FailedPasswordReissue();
        event.setToken(token);
        event.setAttemptDate(dateFactory.newTimestamp().toLocalDateTime());
        failedPasswordReissueRepository.create(event);
    }

}

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
package com.example.session.domain.service.goods;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.example.session.domain.model.Goods;

public interface GoodsService {

    public Page<Goods> findByCategoryId(Integer categoryId, Pageable pageable);

    public Goods findOne(String goodsId);
}

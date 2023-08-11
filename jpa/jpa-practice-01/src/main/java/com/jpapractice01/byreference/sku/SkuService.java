package com.jpapractice01.byreference.sku;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SkuService {
    private final SkuRepository skuRepository;

    @Transactional
    public void create(Sku sku) {
        skuRepository.save(sku);
    }

    public Sku findById(long id) {
        return skuRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}

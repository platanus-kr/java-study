package com.jpapractice01.byidentifier.sku;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SkuServiceIdf {
    private final SkuRepositoryIdf skuRepositoryIdf;

    public void create(SkuIdf skuIdf) {
        // more validation and dto convert...
        skuRepositoryIdf.save(skuIdf);
    }

    public SkuIdf findById(long id) {
        return skuRepositoryIdf.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public SkuIdf retrieve(long skuNo){
        return skuRepositoryIdf.findById(skuNo).orElseThrow(IllegalAccessError::new);
    }
}

package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.export.Export;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ItemExports {
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<Export> exports = new ArrayList<>();
}

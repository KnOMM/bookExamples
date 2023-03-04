package org.example;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldNameConstants;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Product {

    @NonNull
    private String name;
    @NonNull
    private String description;
    private List<String> tags;

    public Product addTagsOfOtherProduct (Product product){
        this.tags.addAll(product.getTags());
        return this;
    }
}

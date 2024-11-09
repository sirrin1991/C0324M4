package com.example.spring_boot.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductDTO implements Validator {
    private Long id;
    @NotBlank(message = "Bắt buộc nhập")
    @Pattern(regexp = "^[a-z A-Z]*$", message = "sai định dạng")
    private String name;
    private Long price;
    private Category category;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, Long price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return ProductDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDTO productDTO = (ProductDTO) target;
        String name = productDTO.getName();
        if(name.length() < 5) {
            errors.rejectValue("name", "name.short");
        }
//        }else if(name.length() > 50){
//            errors.rejectValue("name","","Tên phải ít hơn 50 ký tự");
//        }
    }
}

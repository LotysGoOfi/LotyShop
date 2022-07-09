package by.itacademy.lotys.web.shop.lotyshop.dtos.categoryProduct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryProductResponse {

    @NotBlank
    private UUID id;

    @NotBlank
    private String name;

}

package com.sample.dto;

import com.sample.model.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookPostMethodDTO extends BookDTO {

    @ApiModelProperty(value = "Book id", example = "1", hidden = true)
    private Long id;

    public Book toEntity() {
        return Book.builder()
                .title(this.getTitle())
                .numberOfPages(this.getNumberOfPages())
                .build();
    }

}

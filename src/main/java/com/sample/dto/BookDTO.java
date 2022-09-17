package com.sample.dto;

import com.sample.model.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    @ApiModelProperty(value = "Book id", example = "1")
    private Long id;

    @ApiModelProperty(value = "Book Title", example = "Lorem Ipsum")
    private String title;

    @ApiModelProperty(value = "Number of pages", example = "123")
    private Long numberOfPages;

    public static BookDTO ofEntity(final Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .numberOfPages(book.getNumberOfPages())
                .build();
    }
}

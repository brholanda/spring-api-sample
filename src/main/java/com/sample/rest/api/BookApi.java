package com.sample.rest.api;

import com.sample.dto.BookDTO;
import com.sample.dto.BookPostMethodDTO;
import com.sample.http.BasicResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "Book API", tags = "Book API")
public interface BookApi {

    @ApiOperation(value = "Search a book by it's title", nickname = "getBookByTitle", response = BasicResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BookDTO.class),
            @ApiResponse(code = 204, message = "No result found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    BasicResponse<BookDTO> getBookByTitle(@ApiParam(value = "Book Title", example = "Loren Ipsum", required = true)
                                          @RequestParam final String title);

    @ApiOperation(value = "Save a new book", nickname = "postBook", response = BasicResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BookDTO.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PostMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    BasicResponse<BookDTO> postBook(@ApiParam(value = "The Book", required = true)
                                    @RequestBody final BookPostMethodDTO book);

    @ApiOperation(value = "Update an existing book", nickname = "putBook", response = BasicResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BookDTO.class),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @PutMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    BasicResponse<BookDTO> putBook(@ApiParam(value = "The Book", required = true)
                                    @RequestBody final BookDTO book);

}

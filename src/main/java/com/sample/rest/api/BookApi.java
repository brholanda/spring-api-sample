package com.sample.rest.api;

import com.sample.dto.BookDTO;
import com.sample.http.BasicResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Api(value = "Book API", tags = "Book API")
public interface BookApi {

    @ApiOperation(value = "Posição Atual do Cliente", nickname = "findPosicaoAtual", response = BasicResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = BookDTO.class),
            @ApiResponse(code = 204, message = "No result found"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 500, message = "Server error")
    })
    @GetMapping(value = "/book", produces = MediaType.APPLICATION_JSON_VALUE)
    BasicResponse<BookDTO> getBookByTitle(@ApiParam(value = "Book Title", example = "Loren Ipsum", required = true)
                                          @RequestParam final String title);

}

package com.sample.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BasicResponse<T> {

    private T data;
    @Builder.Default
    private int status = HttpStatus.SC_OK;
    @Builder.Default
    private String message = "Ok";

    public static <T> BasicResponse<T> success(final T data) {
        return BasicResponse.<T>builder()
                .data(data)
                .build();
    }

    public static <T> BasicResponse<T> fail(final int httpStatusCode, final String message) {
        return BasicResponse.<T>builder()
                .status(httpStatusCode)
                .message(message)
                .build();
    }

    public static <T> BasicResponse<T> ok() {
        return BasicResponse.<T>builder()
                .build();
    }

}

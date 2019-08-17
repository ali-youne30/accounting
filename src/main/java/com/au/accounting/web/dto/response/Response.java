package com.au.accounting.web.dto.response;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private Integer code;

    private String desc;

    public Response(ReturnType returnType) {
        this.code = returnType.code;
        this.desc = returnType.desc;
    }
}

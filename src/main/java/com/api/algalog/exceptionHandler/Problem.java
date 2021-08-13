package com.api.algalog.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Problem {

    private Integer status;
    private LocalDateTime dateTime;
    private String titulo;
    private List<Field> fields;

    @AllArgsConstructor
    @Getter
    public static class Field {

        private String Nome;
        private String mensagem;
    }
}

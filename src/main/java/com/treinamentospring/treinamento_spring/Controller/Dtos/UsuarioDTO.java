package com.treinamentospring.treinamento_spring.Controller.Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {

    private String senha;
    private String email;
}

package com.demo.poc.dto;

import lombok.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class PokemonDTO implements Serializable {

    private String type;
    private String name;
    private int code;

}

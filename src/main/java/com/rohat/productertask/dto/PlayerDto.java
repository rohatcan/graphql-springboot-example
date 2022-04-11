package com.rohat.productertask.dto;

import com.rohat.productertask.model.EPosition;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class PlayerDto {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private EPosition position;

}

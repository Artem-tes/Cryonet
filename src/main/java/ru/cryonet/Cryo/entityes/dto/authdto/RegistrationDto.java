package ru.cryonet.Cryo.entityes.dto.authdto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegistrationDto {
    @NotNull
    @Size(min = 3,max = 12)
    private String username;
    @NotNull
    @Size(min = 3,max = 12)
    private String password;
}

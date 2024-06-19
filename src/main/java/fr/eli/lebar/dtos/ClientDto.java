package fr.eli.lebar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;

}

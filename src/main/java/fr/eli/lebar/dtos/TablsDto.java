package fr.eli.lebar.dtos;


import fr.eli.lebar.enums.Disponible;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TablsDto {
    private long id;
    private int numero;
    private int places;
    private Disponible disponible;
    private long reservationId;
    private int reservationNumero;


}

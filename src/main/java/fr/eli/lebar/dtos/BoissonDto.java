package fr.eli.lebar.dtos;

import fr.eli.lebar.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoissonDto {

    private long id;
    private String name;
    private String compagnie;
    private BigDecimal prix;
    private LocalDate date;
    private String picture;
    private Type type;
    private int quantite;

}
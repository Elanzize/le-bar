package fr.eli.lebar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeDto {
    private long id;
    private int numero;
    private Date dateCommande;
    private double total;
    private long employeId;
    private String employeNom;
    private String employePrenom;
    private List<BoissonDto> boissons;
    private long tablsId;



}

package fr.eli.lebar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private long id;
    private int numero;
    private String nom;
    private String prenom;
    private String telephone;
    private Date dateReservation;
    private long employeId;
    private String employeNom;
    private String employePrenom;
    private long tablsId;


}

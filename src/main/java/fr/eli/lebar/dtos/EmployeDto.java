package fr.eli.lebar.dtos;

import fr.eli.lebar.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeDto {
    private long id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String email;
    private String telephone;
    private Statut statut;
    private List<Long> commandeIds;
    private List<Integer> commandeNumeros;
    private List<Double> commandeTotals;
    private List<Long> reservationIds;
    private List<Integer> reservationNumeros;
    private List<Date> reservationDates;
    private List<String> reservationNoms;
    private List<String> reservationPrenoms;


}

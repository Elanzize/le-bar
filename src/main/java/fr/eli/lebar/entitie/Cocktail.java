package fr.eli.lebar.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cocktail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    private String name;
    private String origine;
    private double prix;
    private Date date;
    private String ingredients;
    private String preparation;
    private String picture;

}

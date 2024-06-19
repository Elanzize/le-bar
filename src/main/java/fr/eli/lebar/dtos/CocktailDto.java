package fr.eli.lebar.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CocktailDto {
    private long id;
    private String name;
    private String origine;
    private double prix;
    private Date date;
    private String ingredients;
    private String preparation;
    private String picture;


}

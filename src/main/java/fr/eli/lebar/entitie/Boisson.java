package fr.eli.lebar.entitie;

import fr.eli.lebar.enums.Type;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Boisson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String compagnie;

    @Column(nullable = false)
    private BigDecimal prix;

    @Column(nullable = false)
    private LocalDate date;

    @Column
    private String image;

    @Enumerated(EnumType.STRING)
    private Type type;

    private int quantite;

    @ManyToMany(mappedBy = "boissons")
    private Set<Commande> commandes = new HashSet<>();

    public Boisson(){

    }

    public Boisson(long id, String name, String compagnie, BigDecimal prix, LocalDate date, String image, int quantite) {
        this.id = id;
        this.name = name;
        this.compagnie = compagnie;
        this.prix = prix;
        this.date = date;
        this.image = image;
        this.quantite=quantite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompagnie() {
        return compagnie;
    }

    public void setCompagnie(String compagnie) {
        this.compagnie = compagnie;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Boisson boisson = (Boisson) o;

        return id == boisson.id;
    }

    @Override
    public int hashCode() {
        return (int) id;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }
}

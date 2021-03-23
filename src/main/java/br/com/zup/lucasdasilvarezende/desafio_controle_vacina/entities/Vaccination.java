package br.com.zup.lucasdasilvarezende.desafio_controle_vacina.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VACCINATIONS")
public class Vaccination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VACCINATION", nullable = false, unique = true)
    private Long id;

    @Column(name = "VACCINE_NAME", nullable = false)
    private String vaccineName;

    @ManyToOne
    @JoinColumn(
            name = "USER_EMAIL", referencedColumnName = "EMAIL", nullable = false,
            foreignKey = @ForeignKey(name = "FK_VACCINATIONS_USER_EMAIL"))
    private User user;

    public Vaccination() {
    }

    public Vaccination(Long id, String vaccineName, User user) {
        this.id = id;
        this.vaccineName = vaccineName;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String name) {
        this.vaccineName = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

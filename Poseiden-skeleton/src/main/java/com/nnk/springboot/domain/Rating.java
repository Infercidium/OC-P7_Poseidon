package com.nnk.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rating")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "MoodysRating is mandatory")
    private String moodysRating;

    @NotBlank(message = "SandPRating is mandatory")
    private String sandPRating;

    @NotBlank(message = "FitchRating is mandatory")
    private String fitchRating;

    private Integer orderNumber;

    public Rating(final String moodysRatingC, final String sandPRatingC, final String fitchRatingC, final Integer orderNumberC) {
        this.moodysRating = moodysRatingC;
        this.sandPRating = sandPRatingC;
        this.fitchRating = fitchRatingC;
        this.orderNumber = orderNumberC;
    }

    @Override
    public String toString() {
        return "Rating{"
                + "id = " + id
                + ", moodysRating = '" + moodysRating + '\''
                + ", sandPRating = '" + sandPRating + '\''
                + ", fitchRating = '" + fitchRating + '\''
                + ", orderNumber = " + orderNumber
                + '}';
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rating)) {
            return false;
        }
        Rating rating = (Rating) o;
        return getId().equals(rating.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

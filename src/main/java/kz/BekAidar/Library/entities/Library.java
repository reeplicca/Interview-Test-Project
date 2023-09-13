package kz.BekAidar.Library.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "libraries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "district")
    private String district;
}

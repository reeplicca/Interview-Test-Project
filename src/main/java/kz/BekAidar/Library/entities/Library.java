package kz.BekAidar.Library.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "libraries")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "district")
    private String district;
}

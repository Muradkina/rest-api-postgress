package com.mkdb.postgressrestapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "kişi")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Kisi {
    @Id
    @SequenceGenerator(name = "seq_kişi", allocationSize = 1)
    @GeneratedValue(generator = "seq_kişi", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "adı", length = 50)
    private String adi;

    @Column(name = "soyadı", length = 50)
    private String soyAdi;
    @OneToMany
    @JoinColumn(name = "kişi_adres_id")
    List<Adres> adresleri;


}

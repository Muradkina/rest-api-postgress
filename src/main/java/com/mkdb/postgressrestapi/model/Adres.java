package com.mkdb.postgressrestapi.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "kişi_adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kişi_adres", allocationSize = 1)
    @GeneratedValue(generator = "seq_kişi_adres", strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "adres", length = 500)
    private String adres;
    @Enumerated
    private AdresTip adresTip;
    @Column(name = "aktif")
    private Boolean aktif;
    //fetch  veritabanındn adres kaydı her  seçildiğinde seçilgili kişinin tüm adreslerini getirir
    //fetc.EAGER dersek sadece get kişi dersek onun adresini getirirr
    @ManyToMany
    @JoinColumn(name = "kişi_adres_id")
    private Kisi kisi;


}

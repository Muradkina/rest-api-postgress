package com.mkdb.postgressrestapi.dto;

import com.mkdb.postgressrestapi.model.Adres;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data

public class KisiDto {
    private Long id;
    private  String ad;
    private  String soyAd;
    private List<String> adresleri;
}

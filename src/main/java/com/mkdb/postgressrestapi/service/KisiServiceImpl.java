package com.mkdb.postgressrestapi.service;

import com.mkdb.postgressrestapi.dto.KisiDto;
import com.mkdb.postgressrestapi.model.Adres;
import com.mkdb.postgressrestapi.model.AdresTip;
import com.mkdb.postgressrestapi.model.Kisi;
import com.mkdb.postgressrestapi.repository.AdresRepository;
import com.mkdb.postgressrestapi.repository.KisiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KisiServiceImpl implements KisiService {
    private final KisiRepository kisiRepository;
    private final AdresRepository adresRepository;


    @Override
    @Transactional
    public KisiDto save(KisiDto kisiDto) {
        Assert.notNull(kisiDto.getAd(), "Adi alani zorunludur!");

        Kisi kisi = new Kisi();
        kisi.setAdi(kisiDto.getAd());
        kisi.setSoyAdi(kisiDto.getSoyAd());
        final  Kisi kisiDb = kisiRepository.save(kisi);

        List<Adres> liste = new ArrayList<>();
        kisiDto.getAdresleri().forEach(item -> {
            Adres adres = new Adres();
            adres.setAdres(item);
            adres.setAdresTip(AdresTip.DIGER);
            adres.setAktif(true);
            adres.setKisi(kisiDb);
            liste.add(adres);
        });
        adresRepository.saveAll(liste);
        kisiDto.setId(kisiDb.getId());
        return kisiDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<KisiDto> getAll() {
        List<Kisi> kisiler = kisiRepository.findAll();
        List<KisiDto>kisiDtos=new ArrayList<>();
        kisiler.forEach(it ->{
            KisiDto kisiDto= new KisiDto();
            kisiDto.setId(it.getId());
            kisiDto.setAd(it.getAdi());
            kisiDto.setSoyAd(it.getSoyAdi());
           kisiDto.setAdresleri(it.getAdresleri().stream()
                   .map(Adres::getAdres).collect(Collectors.toList()));
           kisiDtos.add(kisiDto);
        });

        return kisiDtos;
    }

    @Override
    public Page<KisiDto> getAll(Pageable pageable) {
        return null;
    }
}

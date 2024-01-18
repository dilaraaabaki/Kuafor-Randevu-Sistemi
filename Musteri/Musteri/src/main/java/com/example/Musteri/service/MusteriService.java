package com.example.Musteri.service;

import com.example.Musteri.dto.MusteriDto;

import java.util.List;

public interface MusteriService {

    MusteriDto musteriOlustur(MusteriDto musteriDto);

    MusteriDto idileGetir(Long musteriId);

    List<MusteriDto> tumMusterileriGetir();

    MusteriDto musteriGuncelle(Long musteriId, MusteriDto guncellenenMusteri);

    void musteriSil(Long musteriId);

}

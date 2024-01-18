package com.example.Musteri.service;

import com.example.Musteri.dto.KuaforDto;

import java.util.List;

public interface KuaforService {

    KuaforDto kuaforOlustur(KuaforDto kuaforDto);

    KuaforDto idIleGetir(Long kuaforId);

    List<KuaforDto> tumKuaforleriGetir();

    KuaforDto kuaforGuncelle(Long kuaforId, KuaforDto guncellenenKuafor);

    void kuaforSil(Long kuaforId);

}

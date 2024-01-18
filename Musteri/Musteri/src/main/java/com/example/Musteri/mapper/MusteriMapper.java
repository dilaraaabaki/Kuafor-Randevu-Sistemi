package com.example.Musteri.mapper;

import com.example.Musteri.dto.MusteriDto;
import com.example.Musteri.entity.Musteri;

public class MusteriMapper {
    public static MusteriDto mapToMusteriDto(Musteri Musteri){
        return new MusteriDto(
                Musteri.getId(),
                Musteri.getIsim(),
                Musteri.getSoyisim(),
                Musteri.getKullaniciadi()
        );
    }

    public static Musteri mapToMusteri(MusteriDto MusteriDto){
        return new Musteri(
                MusteriDto.getId(),
                MusteriDto.getIsim(),
                MusteriDto.getSoyisim(),
                MusteriDto.getKullaniciadi()
        );
    }}

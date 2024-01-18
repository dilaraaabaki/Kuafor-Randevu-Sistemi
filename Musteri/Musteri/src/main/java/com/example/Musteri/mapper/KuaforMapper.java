package com.example.Musteri.mapper;

import com.example.Musteri.dto.KuaforDto;
import com.example.Musteri.entity.Kuafor;

public class KuaforMapper {
    public static KuaforDto mapToKuaforDto(Kuafor kuafor) {
        return new KuaforDto(
                kuafor.getId(),
                kuafor.getIsim(),
                kuafor.getSoyisim(),
                kuafor.getKullaniciadi()
        );
    }

    public static Kuafor mapToKuafor(KuaforDto kuaforDto) {
        return new Kuafor(
                kuaforDto.getId(),
                kuaforDto.getIsim(),
                kuaforDto.getSoyisim(),
                kuaforDto.getKullaniciadi()
        );
    }
}

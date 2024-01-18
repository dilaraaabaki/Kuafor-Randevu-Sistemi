package com.example.Musteri.service.impl;

import com.example.Musteri.dto.KuaforDto;
import com.example.Musteri.entity.Kuafor;
import com.example.Musteri.mapper.KuaforMapper;
import com.example.Musteri.repository.KuaforRepository;
import com.example.Musteri.service.KuaforService;
import lombok.AllArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KuaforServiceImpl implements KuaforService {

    private final KuaforRepository kuaforRepository;

    @Override
    public KuaforDto kuaforOlustur(KuaforDto kuaforDto) {
        Kuafor kuafor = KuaforMapper.mapToKuafor(kuaforDto);
        Kuafor kaydedilmisKuafor = kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(kaydedilmisKuafor);
    }

    @Override
    public KuaforDto idIleGetir(Long kuaforId) {
        Kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(() -> new ExpressionException("Bu id ile kayıtlı bir kuaför bulunamadı. Id: " + kuaforId));
        return KuaforMapper.mapToKuaforDto(kuafor);
    }

    @Override
    public List<KuaforDto> tumKuaforleriGetir() {
        List<Kuafor> kuaforler = kuaforRepository.findAll();
        return kuaforler.stream().map(KuaforMapper::mapToKuaforDto).collect(Collectors.toList());
    }

    @Override
    public KuaforDto kuaforGuncelle(Long kuaforId, KuaforDto guncellenenKuafor) {
        Kuafor kuafor = kuaforRepository.findById(kuaforId)
                .orElseThrow(() -> new ExpressionException("Bu id ile kayıtlı bir kuaför bulunamadı. Id: " + kuaforId));

        kuafor.setIsim(guncellenenKuafor.getIsim());
        kuafor.setSoyisim(guncellenenKuafor.getSoyisim());
        kuafor.setKullaniciadi(guncellenenKuafor.getKullaniciadi());

        Kuafor veritabanindaGuncellenmisKuafor = kuaforRepository.save(kuafor);
        return KuaforMapper.mapToKuaforDto(veritabanindaGuncellenmisKuafor);
    }

    @Override
    public void kuaforSil(Long kuaforId) {
        kuaforRepository.deleteById(kuaforId);
    }
}

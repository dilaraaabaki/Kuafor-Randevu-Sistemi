package com.example.Musteri.service.impl;

import com.example.Musteri.dto.MusteriDto;
import com.example.Musteri.entity.Musteri;
import com.example.Musteri.mapper.MusteriMapper;
import com.example.Musteri.repository.MusteriRepository;
import com.example.Musteri.service.MusteriService;
import org.springframework.expression.ExpressionException;

import java.util.List;
import java.util.stream.Collectors;

public class MusteriServiceImpl implements MusteriService {

    private final MusteriRepository musteriRepository;

    public MusteriServiceImpl(MusteriRepository musteriRepository) {
        this.musteriRepository = musteriRepository;
    }

    @Override
    public MusteriDto musteriOlustur(MusteriDto musteriDto) {
        Musteri musteri = MusteriMapper.mapToMusteri(musteriDto);
        Musteri kaydedilmisMusteri = musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(kaydedilmisMusteri);
    }

    @Override
    public MusteriDto idileGetir(Long musteriId) {
        Musteri musteri = musteriRepository.findById(musteriId)
                .orElseThrow(() -> new ExpressionException("Bu id ile kayıtlı bir müşteri bulunamadı. Id: " + musteriId));
        return MusteriMapper.mapToMusteriDto(musteri);
    }

    @Override
    public List<MusteriDto> tumMusterileriGetir() {
        List<Musteri> musteriler = musteriRepository.findAll();
        return musteriler.stream().map(MusteriMapper::mapToMusteriDto).collect(Collectors.toList());
    }

    @Override
    public MusteriDto musteriGuncelle(Long musteriId, MusteriDto guncellenenMusteri) {
        Musteri musteri = musteriRepository.findById(musteriId)
                .orElseThrow(() -> new ExpressionException("Bu id ile kayıtlı bir müşteri bulunamadı. Id: " + musteriId));
        musteri.setIsim(guncellenenMusteri.getIsim());
        musteri.setSoyisim(guncellenenMusteri.getSoyisim());
        musteri.setKullaniciadi(guncellenenMusteri.getKullaniciadi());
        Musteri veritabanindaGuncellenmisMusteri = musteriRepository.save(musteri);
        return MusteriMapper.mapToMusteriDto(veritabanindaGuncellenmisMusteri);
    }


    @Override
    public void musteriSil(Long musteriId) {
        Musteri musteri = musteriRepository.findById(musteriId)
                .orElseThrow(() -> new ExpressionException("Bu id ile kayıtlı bir müşteri bulunamadı. Id: " + musteriId));
        musteriRepository.deleteById(musteriId);
    }

}

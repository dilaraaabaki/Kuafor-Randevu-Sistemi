package com.example.Musteri.controller;

import com.example.Musteri.dto.MusteriDto;
import com.example.Musteri.service.MusteriService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/musteriler")
public class MusteriController {

    private final MusteriService musteriService;

    @PostMapping
    public ResponseEntity<MusteriDto> musteriOlustur(@RequestBody MusteriDto musteriDto) {
        MusteriDto kayitEdilmisMusteri = musteriService.musteriOlustur(musteriDto);
        return new ResponseEntity<>(kayitEdilmisMusteri, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<MusteriDto> idIleGetir(@PathVariable("id") Long musteriId) {
        MusteriDto musteriDto = musteriService.idileGetir(musteriId);
        return ResponseEntity.ok(musteriDto);
    }

    @GetMapping
    public ResponseEntity<List<MusteriDto>> tumMusterileriGetir() {
        List<MusteriDto> musteriDtoList = musteriService.tumMusterileriGetir();
        return ResponseEntity.ok(musteriDtoList);
    }

    @PutMapping("{id}")
    public ResponseEntity<MusteriDto> musteriGuncelle(@PathVariable("id") Long musteriId,
                                                      @RequestBody MusteriDto guncellenenMusteriDto) {
        MusteriDto musteriDto = musteriService.musteriGuncelle(musteriId, guncellenenMusteriDto);
        return ResponseEntity.ok(musteriDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> musteriSil(@PathVariable("id") Long musteriId) {
        musteriService.musteriSil(musteriId);
        return ResponseEntity.ok("Müşteri başarıyla silindi.");
    }
}

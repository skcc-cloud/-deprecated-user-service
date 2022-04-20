package com.skcc.tes.settlement.controller;

import com.skcc.tes.settlement.domain.Settlement;
import com.skcc.tes.settlement.domain.SettlementRepository;
import com.skcc.tes.settlement.dto.SettlementDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class SettlementController {

    private final SettlementRepository repository;

    // 생성
    @PostMapping("/settlement")
    public SettlementDto saveNewSettlement(@RequestBody Settlement src) {
        src.setId(null);
        Settlement saved = repository.save(src);
        return saved.toDto();
    }

    // 전체 조회
    @GetMapping("/settlements")
    public List<SettlementDto> getAllSettlements() {
        List<Settlement> allSettlements = repository.findAll();
        return allSettlements.stream().map(Settlement::toDto).collect(Collectors.toList());
    }

    // item 하나 조회
    @GetMapping("/settlement/{id}")
    public SettlementDto getSettlementById(@PathVariable Long id) {
        Optional<Settlement> byId = repository.findById(id);
        return byId.map(Settlement::toDto).orElse(null);
    }
}

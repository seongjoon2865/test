package com.example.test.controller;

import com.example.test.dto.MemoRequestDto;
import com.example.test.dto.MemoResponseDto;
import com.example.test.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    // Create API
    @PostMapping("/memos")
    public ResponseEntity<MemoResponseDto> saveMemo(@RequestBody MemoRequestDto dto) {
        return ResponseEntity.ok(memoService.saveMemo(dto));
    }

    // Read ALL API
    @GetMapping("/memos")
    public ResponseEntity<List<MemoResponseDto>> findById() {
        return ResponseEntity.ok(memoService.findAll());
    }

    // Read One API
    @GetMapping("/memos/{id}")
    public ResponseEntity<MemoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(memoService.findById(id));
    }

    @PutMapping("/memos/{id}")
    public ResponseEntity<MemoResponseDto> updateContent(@PathVariable Long id, @RequestBody MemoRequestDto dto) {
        return ResponseEntity.ok(memoService.updateContent(id, dto));
    }

    @DeleteMapping("/memos/{id}")
    public void delete(@PathVariable Long id) {
        memoService.delete(id);
    }
}

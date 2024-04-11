package com.master.backend.size;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sizes")
@RequiredArgsConstructor
public class SizeController {
    private final SizeService sizeService;

    @GetMapping
    public ResponseEntity<List<Size>> getAllSizes() {
        List<Size> sizes = sizeService.getAllSizes();
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Size> getSizeById(@PathVariable int id) {
        Size size = sizeService.getSizeById(id);
        if (size != null) {
            return new ResponseEntity<>(size, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Size> createSize(@Valid @RequestBody SizeRequest size) {
        Size newSize = new Size();
        newSize.setName(size.getName());
        newSize.setValue(size.getValue());
        Size createdSize = sizeService.createSize(newSize);
        return new ResponseEntity<>(createdSize, HttpStatus.CREATED);
    }
}

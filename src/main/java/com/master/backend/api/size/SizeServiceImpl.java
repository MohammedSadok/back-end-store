package com.master.backend.api.size;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SizeServiceImpl implements SizeService {
    private final SizeRepository sizeRepository;

    @Override
    public List<Size> getAllSizes() {
        return sizeRepository.findAll();
    }

    @Override
    public Size getSizeById(int id) {
        return sizeRepository.findById(id).orElse(null);
    }

    @Override
    public Size createSize(Size size) {
        return sizeRepository.save(size);
    }
}
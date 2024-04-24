package com.master.backend.api.color;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColorServiceImpl implements ColorService {
    private final ColorRepository colorRepository;

    @Override
    public List<Color> getAllColors() {
        return colorRepository.findAll();
    }

    @Override
    public Color getColorById(int id) {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public Color createColor(Color color) {
        return colorRepository.save(color);
    }
}

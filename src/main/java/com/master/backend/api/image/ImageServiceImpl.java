package com.master.backend.api.image;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    @Override
    public Image getImageById(int id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image createImage(Image image) {
        return imageRepository.save(image);
    }

}

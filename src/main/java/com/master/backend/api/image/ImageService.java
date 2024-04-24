package com.master.backend.api.image;

import java.util.List;

public interface ImageService {
    List<Image> getAllImages();
    Image getImageById(int id);
    Image createImage(Image image);
}

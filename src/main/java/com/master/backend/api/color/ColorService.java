package com.master.backend.api.color;

import java.util.List;

public interface ColorService {
    List<Color> getAllColors();
    Color getColorById(int id);
    Color createColor(Color color);
}

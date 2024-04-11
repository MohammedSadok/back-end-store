package com.master.backend.size;

import java.util.List;

public interface SizeService {
    List<Size> getAllSizes();
    Size getSizeById(int id);
    Size createSize(Size size);

}

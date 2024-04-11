package com.master.backend.color;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("colors")
@RequiredArgsConstructor
public class ColorController {
    private final ColorService colorService;

    @GetMapping
    public ResponseEntity<List<Color>> getAllColors() {
        List<Color> colors = colorService.getAllColors();
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Color> getColorById(@PathVariable int id) {
        Color color = colorService.getColorById(id);
        if (color != null) {
            return new ResponseEntity<>(color, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Color> createColor(@Valid @RequestBody ColorRequest color) {
        Color newColor = new Color();
        newColor.setName(color.getName());
        newColor.setHexValue(color.getHexValue());
        Color createdColor = colorService.createColor(newColor);
        return new ResponseEntity<>(createdColor, HttpStatus.CREATED);
    }
}
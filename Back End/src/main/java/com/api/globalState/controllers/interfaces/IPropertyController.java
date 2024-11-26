package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/properties")
public interface IPropertyController {

    @GetMapping
    PropertyEntity getAllProperties(@RequestParam SearchParamsDto params);

    @GetMapping("/{idProperty}")
    PropertyEntity getProperty(@PathVariable String idProperty);

    @PutMapping("/{idProperty}")
    PropertyEntity updateProperty(@PathVariable String idProperty, @RequestBody PropertyEntity property);

    @PostMapping
    PropertyEntity createProperty(@PathVariable String idProperty, @RequestBody PropertyEntity property);

    @DeleteMapping("/{idProperty}")
    PropertyEntity deleteProperty(@PathVariable String idProperty);
}

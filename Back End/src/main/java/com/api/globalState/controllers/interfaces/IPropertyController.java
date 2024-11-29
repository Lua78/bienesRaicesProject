package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/properties")
public interface IPropertyController {

    @GetMapping
    List<PropertyEntity> getAllProperties(@RequestParam SearchParamsDto params);

    @GetMapping("/{idProperty}")
    PropertyEntity getProperty(@PathVariable Integer idProperty) throws ResponseException;

    @PutMapping("/{idProperty}")
    PropertyEntity updateProperty(@PathVariable Integer idProperty, @RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    PropertyEntity createProperty(@RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{idProperty}")
    PropertyEntity deleteProperty(@PathVariable Integer idProperty, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}

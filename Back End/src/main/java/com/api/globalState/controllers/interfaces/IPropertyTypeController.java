package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyTypeEntity;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/property_types")
public interface IPropertyTypeController {

    @GetMapping
    ResponseEntity<GenericResponse<List<PropertyTypeEntity>>> getAllProperties(@RequestParam SearchParamsDto params);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyTypeEntity>> getProperty(@PathVariable Integer id) throws ResponseException;

    @PutMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyTypeEntity>>  updateProperty(@PathVariable Integer id, @RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyTypeEntity>> createProperty(@RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyTypeEntity>> deleteProperty(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}

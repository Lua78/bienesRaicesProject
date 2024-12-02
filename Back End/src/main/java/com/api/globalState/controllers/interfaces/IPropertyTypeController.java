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
    ResponseEntity<GenericResponse<List<PropertyTypeEntity>>> getAll(@RequestParam SearchParamsDto params);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyTypeEntity>> getOne(@PathVariable Integer id) throws ResponseException;

    @PutMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyTypeEntity>>  update(@PathVariable Integer id, @RequestBody PropertyTypeEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyTypeEntity>> create(@RequestBody PropertyTypeEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyTypeEntity>> delete(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}

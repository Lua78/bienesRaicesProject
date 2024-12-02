package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyStateEntity;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/property_states")
public interface IPropertyStateController {

    @GetMapping
    ResponseEntity<GenericResponse<List<PropertyStateEntity>>> getAll(@RequestParam SearchParamsDto params);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyStateEntity>> getOne(@PathVariable Integer id) throws ResponseException;

    @PutMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyStateEntity>>  update(@PathVariable Integer id, @RequestBody PropertyStateEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyStateEntity>> create(@RequestBody PropertyStateEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyStateEntity>> delete(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}

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
    ResponseEntity<GenericResponse<List<PropertyStateEntity>>> getAllProperties(@RequestParam SearchParamsDto params);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyStateEntity>> getProperty(@PathVariable Integer id) throws ResponseException;

    @PutMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyStateEntity>>  updateProperty(@PathVariable Integer id, @RequestBody PropertyStateEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyStateEntity>> createProperty(@RequestBody PropertyStateEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{id}")
    ResponseEntity<GenericResponse<PropertyStateEntity>> deleteProperty(@PathVariable Integer id, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}

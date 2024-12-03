package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.PropertyDto;
import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.dtos.response.PropertyResponseDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins = "*")
@RequestMapping("/properties")
public interface IPropertyController {

    @GetMapping
    ResponseEntity<GenericResponse<List<PropertyResponseDto>>> getAllProperties(@RequestParam HashMap<String,String> params);

    @GetMapping("/{idProperty}")
    ResponseEntity<GenericResponse<PropertyResponseDto>> getProperty(@PathVariable Integer idProperty) throws ResponseException;

    @PutMapping("/{idProperty}")
    ResponseEntity<GenericResponse<PropertyEntity>>  updateProperty(@PathVariable Integer idProperty, @RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyEntity>> createProperty(@RequestBody PropertyDto property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{idProperty}")
    ResponseEntity<GenericResponse<PropertyEntity>> deleteProperty(@PathVariable Integer idProperty, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}

package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/owner")
public interface IPropertyOwnerController {

    @GetMapping
    ResponseEntity<GenericResponse<List<PropertyEntity>>> getAllOwners(@RequestParam SearchParamsDto params);

    @GetMapping("/{idOwner}")
    ResponseEntity<GenericResponse<PropertyEntity>> getOwner(@PathVariable Integer idOwner) throws ResponseException;

    @PutMapping("/{idOwner}")
    ResponseEntity<GenericResponse<PropertyEntity>> updateOwner(@PathVariable Integer idOwner, @RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyEntity>> createOwner(@RequestBody PropertyEntity property, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{idOwner}")
    ResponseEntity<GenericResponse<PropertyEntity>> deleteOwner(@PathVariable Integer idOwner, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}



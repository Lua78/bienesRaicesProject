package com.api.globalState.controllers.interfaces;

import com.api.globalState.dtos.request.SearchParamsDto;
import com.api.globalState.entities.properties.PropertyEntity;
import com.api.globalState.entities.properties.PropertyOwnerEntity;
import com.api.globalState.utils.GenericResponse;
import com.api.globalState.utils.exceptions.ResponseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/owner")
public interface IPropertyOwnerController {

    @GetMapping
    ResponseEntity<GenericResponse<List<PropertyOwnerEntity>>> getAllOwners(@RequestParam HashMap<String,String> params);

    @GetMapping("/{idOwner}")
    ResponseEntity<GenericResponse<PropertyOwnerEntity>> getOwner(@PathVariable Integer idOwner) throws ResponseException;

    @PutMapping("/{idOwner}")
    ResponseEntity<GenericResponse<PropertyOwnerEntity>> updateOwner(@PathVariable Integer idOwner, @RequestBody PropertyOwnerEntity entity, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @PostMapping
    ResponseEntity<GenericResponse<PropertyOwnerEntity>> createOwner(@RequestBody PropertyOwnerEntity entity, @RequestHeader(name = "Authorization") String token) throws ResponseException;

    @DeleteMapping("/{idOwner}")
    ResponseEntity<GenericResponse<PropertyOwnerEntity>> deleteOwner(@PathVariable Integer idOwner, @RequestHeader(name = "Authorization") String token) throws ResponseException;
}



package com.said.gwmon.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.said.gwmon.core.APIResponse;
import com.said.gwmon.core.SwaggerResponse;
import com.said.gwmon.dto.UserMeasurementRequestDTO;
import com.said.gwmon.dto.UserMeasurementsPageDTO;
import com.said.gwmon.service.UserMeasurementsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.UUID;


@Api(value = "Measurements", tags = {"User Measurements"})
@RestController
@RequestMapping("/api/v1/measurements")
public class UserMeasurementsController {

    private static final String SORTING_DESCRIPTION =
            "Sorting criteria in the format: property(,asc|desc). " +
                    "Default sort order is ascending. " +
                    "Multiple sort criteria are supported. " +
                    "E.g. sorting by value than by timestamp: &sort=value,asc&sort=timestamp,desc";

    UserMeasurementsService userMeasurementsService;

    @Autowired
    public UserMeasurementsController(UserMeasurementsService userMeasurementsService) {
        this.userMeasurementsService = userMeasurementsService;
    }

    @ApiOperation("Returns list of all user measurements. Supports pagination and sorting.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SwaggerResponseMeasurements.class),
            @ApiResponse(code = 400, message = "Bad request", response = APIResponse.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = SORTING_DESCRIPTION)
    })
    @GetMapping("/list/{userId}")
    public APIResponse<UserMeasurementsPageDTO> getUserMeasurements(
            @PathVariable(value = "userId") UUID userId,
            Pageable pageable,
            HttpServletRequest request
    ) {
        try {
            return APIResponse.apiOk(userMeasurementsService.getMeasurements(userId, pageable))
                    .setPath(request.getRequestURI());
        } catch (Exception ex) {
            return APIResponse.<UserMeasurementsPageDTO>apiError()
                    .setErrorMessage(ex.getMessage())
                    .setPath(request.getRequestURI());
        }
    }

    @ApiOperation("Add new user measurement.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = APIResponse.class),
            @ApiResponse(code = 400, message = "Bad request", response = APIResponse.class)
    })
    @PostMapping("/{userId}")
    public APIResponse addUserMeasurement(
            @PathVariable(value = "userId") UUID userId,
            @Valid @RequestBody UserMeasurementRequestDTO measurement,
            HttpServletRequest request) {
        try {
            userMeasurementsService.setMeasurement(userId, measurement);
        } catch (Exception ex) {
            return APIResponse.apiError()
                    .setErrorMessage(ex.getMessage())
                    .setPath(request.getRequestURI());
        }
        return APIResponse.apiOk();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
    public APIResponse handleJsonMappingException(JsonMappingException ex) {
        return APIResponse.apiError().setError("Bad Request").setErrorMessage(ex.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder str = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            str.append(String.format("%s: %s; ", ((FieldError) error).getField(), error.getDefaultMessage()));
        });
        return APIResponse.apiError().setError("Bad Request").setErrorMessage(str.toString());
    }


    /**
     * Just to generate proper api-docs. Swagger can't dive into generics too deep.
     */
    public static class SwaggerResponseMeasurements extends SwaggerResponse {
        public UserMeasurementsPageDTO result;
    }
}

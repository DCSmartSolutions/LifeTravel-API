package com.nexusnova.lifetravelapi.app.core.tours.api.REST;

import com.nexusnova.lifetravelapi.app.core.tours.api.transformation.RegisterTourPackageCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.ModifyImgPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.ModifyPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackageByIdQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.queries.GetTourPackagesByRegionQuery;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.TourPackageCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.TourPackageQueryService;
import com.nexusnova.lifetravelapi.app.core.tours.mapper.ToursMapper;
import com.nexusnova.lifetravelapi.app.core.tours.resources.details.TourPackageDetailDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.summaries.TourPackageSummaryDto;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.TOUR_PACKAGE_CREATED;
import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.TOUR_PACKAGE_MODIFIED;

@RestController
@RequestMapping("/api/v1/tour-packages")
@Tag(name="Tour Packages Controller")
@CrossOrigin
public class TourPackageController {

    private final TourPackageQueryService tourPackageQueryService;
    private final TourPackageCommandService tourPackageCommandService;
    private final ToursMapper toursMapper;

    public TourPackageController(TourPackageQueryService tourPackageQueryService,
                                 TourPackageCommandService tourPackageCommandService,
                                 ToursMapper toursMapper) {
        this.tourPackageQueryService = tourPackageQueryService;
        this.tourPackageCommandService = tourPackageCommandService;
        this.toursMapper = toursMapper;
    }


    @GetMapping
    @Operation(summary = "Listado", description = "Listado de Actividades.")
    public List<TourPackageSummaryDto> getTours() {
        List<TourPackage> tourPackages = tourPackageQueryService.handle();
        return toursMapper.tourPackageToSummaryDtos(tourPackages);
    }

    @GetMapping("/region/{regionId}")
    @Operation(summary = "Listado Por Region", description = "Listado de Paquetes Por Region Id.")
    public List<TourPackageSummaryDto> getToursByRegion(@Parameter @PathVariable("regionId") Long regionId) {
        List<TourPackage> tourPackages = tourPackageQueryService.handle(new GetTourPackagesByRegionQuery(regionId));
        return toursMapper.tourPackageToSummaryDtos(tourPackages);
    }

    @GetMapping("/{packageId}")
    @Operation(summary = "Obtener Por Id", description = "Obtener Por Id.")
    public TourPackageDetailDto getToursById(@Parameter @PathVariable("packageId") Long packageId) {
        TourPackage tourPackage = tourPackageQueryService.handle(new GetTourPackageByIdQuery(packageId));
        return toursMapper.tourPackageToDetailDto(tourPackage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Registrar Paquete", description = "Permite registrar un paquete.")
    public TourPackageSummaryDto save(@RequestBody @Valid TourPackageRequestDto tourPackageRequestDto,
                               HttpServletResponse response) {
        TourPackage tourPackage =
                tourPackageCommandService.handle(RegisterTourPackageCommandFromRequestDtoAssembler.toCommandFromDto(tourPackageRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, TOUR_PACKAGE_CREATED);
        return toursMapper.tourPackageToSummaryDto(tourPackage);
    }

    @PutMapping("/{packageId}")
    @Operation(summary = "Modificar Imagen", description = "Permite cambiar la url de la imagen.")
    public TourPackageDetailDto updatePackage(@Parameter @PathVariable("packageId") Long packageId,
                                              @RequestBody @Valid TourPackageRequestDto tourPackageRequestDto,
                                              HttpServletResponse response) {
        TourPackage tourPackage =
                tourPackageCommandService.handle(new ModifyPackageCommand(packageId, tourPackageRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, TOUR_PACKAGE_MODIFIED);
        return toursMapper.tourPackageToDetailDto(tourPackage);
    }

    @PutMapping("/img/{packageId}")
    @Operation(summary = "Modificar Imagen", description = "Permite cambiar la url de la imagen.")
    public TourPackageDetailDto updateImage(@Parameter @PathVariable("packageId") Long packageId,
                                            @RequestBody Map<String, String> requestBody,
                                            HttpServletResponse response) {
        TourPackage tourPackage =
                tourPackageCommandService.handle(new ModifyImgPackageCommand(packageId, requestBody.get("imgUrl")));
        response.setHeader(HeaderConstants.MESSAGES, TOUR_PACKAGE_MODIFIED);
        return toursMapper.tourPackageToDetailDto(tourPackage);
    }


}

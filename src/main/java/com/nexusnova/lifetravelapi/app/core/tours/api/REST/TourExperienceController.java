package com.nexusnova.lifetravelapi.app.core.tours.api.REST;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tour-experiences")
@Api(tags = "Api de Experiencias de Tour", consumes = "application/json")
@CrossOrigin
public class TourExperienceController {
}

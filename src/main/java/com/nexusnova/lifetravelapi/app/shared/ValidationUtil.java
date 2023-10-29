package com.nexusnova.lifetravelapi.app.shared;

import com.nexusnova.lifetravelapi.app.core.tours.domain.model.*;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.*;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.*;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.repositories.*;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.*;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.repositories.*;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    private final UserRepository userRepository;
    private final AgencyRepository agencyRepository;
    private final TouristRepository touristRepository;
    private final ActivityRepository activityRepository;
    private final DepartmentRepository departmentRepository;
    private final DestinationRepository destinationRepository;
    private final RegionRepository regionRepository;
    private final TourExperienceRepository tourExperienceRepository;
    private final TourPackageRepository tourPackageRepository;

    public ValidationUtil(UserRepository userRepository,
                          AgencyRepository agencyRepository,
                          TouristRepository touristRepository,
                          ActivityRepository activityRepository,
                          DepartmentRepository departmentRepository,
                          DestinationRepository destinationRepository,
                          RegionRepository regionRepository,
                          TourExperienceRepository tourExperienceRepository,
                          TourPackageRepository tourPackageRepository) {
        this.userRepository = userRepository;
        this.agencyRepository = agencyRepository;
        this.touristRepository = touristRepository;
        this.activityRepository = activityRepository;
        this.departmentRepository = departmentRepository;
        this.destinationRepository = destinationRepository;
        this.regionRepository = regionRepository;
        this.tourExperienceRepository = tourExperienceRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    public Agency findAgencyById(Long id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with id: " + id));
    }
    public Tourist findTouristById(Long id) {
        return touristRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id: " + id));
    }

    public Agency findAgencyByUserId(String id) {
        return agencyRepository.findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with user id: " + id));
    }
    public Tourist findTouristByUserId(String id) {
        return touristRepository.findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with user id: " + id));
    }

    public Activity findActivityById(Long id) {
        return activityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Activity not found with id: " + id));
    }

    public Department findDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
    }

    public Department findDepartmentByName(String name) {
        return departmentRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with name: " + name));
    }

    public Destination findDestinationById(Long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + id));
    }

    public Region findRegionById(Long id) {
        return regionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Region not found with id: " + id));
    }

    public TourExperience findTourExperienceById(Long id) {
        return tourExperienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourExperience not found with id: " + id));
    }

    public TourPackage findTourPackageById(Long id) {
        return tourPackageRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TourPackage not found with id: " + id));
    }

}

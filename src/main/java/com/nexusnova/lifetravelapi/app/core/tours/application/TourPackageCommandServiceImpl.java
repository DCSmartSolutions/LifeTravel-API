package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterTourPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Activity;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Department;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Destination;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.TourPackageCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ActivityRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.MeetingPointRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourPackageCommandServiceImpl implements TourPackageCommandService {

    private final TourPackageRepository tourPackageRepository;
    private final ValidationUtil validationUtil;

    public TourPackageCommandServiceImpl(TourPackageRepository tourPackageRepository,
                                         ValidationUtil validationUtil) {
        this.tourPackageRepository = tourPackageRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public TourPackage handle(RegisterTourPackageCommand registerUserCommand) {
        TourPackage tourPackage = new TourPackage();
        TourPackageRequestDto requestDto = registerUserCommand.tourPackageRequestDto();
        Agency agency = validationUtil.findAgencyByUserId(requestDto.getAgencyId());
        Department department = validationUtil.findDepartmentByName(requestDto.getDepartmentName());

        tourPackage.setTitle(requestDto.getTitle());
        tourPackage.setDescription(requestDto.getDescription());
        tourPackage.setImgUrl(requestDto.getImgUrl());
        tourPackage.setPrice(requestDto.getPrice());
        tourPackage.setLatitude(requestDto.getMeetintPoint().getLatitude());
        tourPackage.setLongitude(requestDto.getMeetintPoint().getLongitude());
        tourPackage.setDepartment(department);
        tourPackage.setRegion(department.getRegion());
        tourPackage.setAgency(agency);


        List<Activity> activityList = new ArrayList<>();
        for(ActivityRequestDto activities : requestDto.getActivities()) {

            Activity activity = validationUtil.findActivityById(activities.getId());
            activityList.add(activity);
        }

        tourPackage.setActivities(activityList);
        tourPackageRepository.save(tourPackage);

        List<Destination> destinationList = new ArrayList<>();
        for(MeetingPointRequestDto destination : requestDto.getActivitiesMeetingPoints()) {

            Destination _destination = new Destination();
            _destination.setLatitude(destination.getLatitude());
            _destination.setLongitude(destination.getLongitude());
            _destination.setTourPackage(tourPackage);
            destinationList.add(_destination);
        }
        tourPackage.setDestinations(destinationList);
        tourPackageRepository.save(tourPackage);

        return tourPackage;
    }
}

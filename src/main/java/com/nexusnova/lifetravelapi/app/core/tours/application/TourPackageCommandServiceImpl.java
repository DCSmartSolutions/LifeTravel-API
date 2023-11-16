package com.nexusnova.lifetravelapi.app.core.tours.application;

import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.ModifyImgPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.ModifyPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.RegisterPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Activity;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Department;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Destination;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.TourPackageRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.TourPackageCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ActivityRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.LocationNameDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.MeetingPointRequestDto;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.TourPackageRequestDto;
import com.nexusnova.lifetravelapi.app.IAM.profile.domain.model.Agency;
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
    public TourPackage handle(RegisterPackageCommand command) {
        TourPackage tourPackage = new TourPackage();
        return setTourPackage(tourPackage, command.tourPackageRequestDto());
    }

    @Override
    public TourPackage handle(ModifyImgPackageCommand command) {
        TourPackage tourPackage = validationUtil.findTourPackageById(command.packageId());

        tourPackage.setImgUrl(command.imgUrl());
        tourPackageRepository.save(tourPackage);
        return tourPackage;
    }

    @Override
    public TourPackage handle(ModifyPackageCommand command) {
        TourPackage tourPackage = validationUtil.findTourPackageById(command.packageId());
        return setTourPackage(tourPackage, command.tourPackageRequestDto());
    }

    private TourPackage setTourPackage(TourPackage tourPackage, TourPackageRequestDto requestDto) {
        Agency agency = validationUtil.findAgencyByUserId(requestDto.getAgencyId());
        Department department = validationUtil.findDepartmentByName(requestDto.getDestiny());

        tourPackage.setTitle(requestDto.getTitle());
        tourPackage.setDescription(requestDto.getDescription());
        tourPackage.setImgUrl(requestDto.getImgUrl());
        tourPackage.setPrice(requestDto.getPrice());
        tourPackage.setLatitude(requestDto.getMeetingPointLatitude());
        tourPackage.setLongitude(requestDto.getMeetingPointLongitude());
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

        for(LocationNameDto destination : requestDto.getDestinations()) {
            Destination _destination = new Destination();
            _destination.setLatitude(destination.getLatitude());
            _destination.setLongitude(destination.getLongitude());
            _destination.setName(destination.getName());
            _destination.setTourPackage(tourPackage);
            destinationList.add(_destination);
        }
        System.out.println("destinations: " + destinationList.toString());
        tourPackage.setDestinations(destinationList);
        tourPackageRepository.save(tourPackage);

        return tourPackage;
    }
}

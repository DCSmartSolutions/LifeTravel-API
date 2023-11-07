package com.nexusnova.lifetravelapi.app.IOT.application;

import com.nexusnova.lifetravelapi.app.IOT.domain.commands.UpdateLocationCommand;
import com.nexusnova.lifetravelapi.app.IOT.domain.model.TrackingWereable;
import com.nexusnova.lifetravelapi.app.IOT.domain.repositories.TrackingWereableRepository;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.TrackingWereableCommandService;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrackingWereableCommandServiceImpl implements TrackingWereableCommandService {

    private final TrackingWereableRepository trackingWereableRepository;

    public TrackingWereableCommandServiceImpl(TrackingWereableRepository trackingWereableRepository) {
        this.trackingWereableRepository = trackingWereableRepository;
    }

    @Override
    public void handle(UpdateLocationCommand command) {
        TrackingWereable trackingWereable = trackingWereableRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("TrackingWereable not found with id: " + command.id()));

        trackingWereable.setLatitude(command.requestDto().getLatitude());
        trackingWereable.setLongitude(command.requestDto().getLongitude());

        trackingWereableRepository.save(trackingWereable);
    }
}



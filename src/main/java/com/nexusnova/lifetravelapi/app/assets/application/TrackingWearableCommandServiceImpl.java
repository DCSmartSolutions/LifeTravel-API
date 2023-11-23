package com.nexusnova.lifetravelapi.app.assets.application;

import com.nexusnova.lifetravelapi.app.assets.domain.commands.UpdateLocationCommand;
import com.nexusnova.lifetravelapi.app.assets.domain.model.TrackingWearable;
import com.nexusnova.lifetravelapi.app.assets.domain.repositories.TrackingWereableRepository;
import com.nexusnova.lifetravelapi.app.assets.domain.services.TrackingWearableCommandService;
import com.nexusnova.lifetravelapi.app.shared.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TrackingWearableCommandServiceImpl implements TrackingWearableCommandService {

    private final TrackingWereableRepository trackingWereableRepository;

    public TrackingWearableCommandServiceImpl(TrackingWereableRepository trackingWereableRepository) {
        this.trackingWereableRepository = trackingWereableRepository;
    }

    @Override
    public void handle(UpdateLocationCommand command) {
        TrackingWearable trackingWereable = trackingWereableRepository.findById(command.id())
                .orElseThrow(() -> new ResourceNotFoundException("TrackingWereable not found with id: " + command.id()));

        trackingWereable.setLatitude(command.requestDto().getLatitude());
        trackingWereable.setLongitude(command.requestDto().getLongitude());

        trackingWereableRepository.save(trackingWereable);
    }
}



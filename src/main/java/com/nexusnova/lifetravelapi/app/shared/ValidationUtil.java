package com.nexusnova.lifetravelapi.app.shared;

import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.repositories.UserRepository;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Agency;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.model.Tourist;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.repositories.AgencyRepository;
import com.nexusnova.lifetravelapi.app.logging.profile.domain.repositories.TouristRepository;
import com.nexusnova.lifetravelapi.configuration.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ValidationUtil {

    private final UserRepository userRepository;
    private final AgencyRepository agencyRepository;
    private final TouristRepository touristRepository;

    public ValidationUtil(UserRepository userRepository,
                          AgencyRepository agencyRepository,
                          TouristRepository touristRepository) {
        this.userRepository = userRepository;
        this.agencyRepository = agencyRepository;
        this.touristRepository = touristRepository;
    }

    public User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
    }
    public Agency findAgencyById(String id) {
        return agencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agency not found with id: " + id));
    }
    public Tourist findTouristById(String id) {
        return touristRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tourist not found with id: " + id));
    }
}

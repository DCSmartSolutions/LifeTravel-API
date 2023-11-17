package com.nexusnova.lifetravelapi.app.core.tours.application;


import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.CreateScheduleCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.DeleteExistingSchedulesOfPackageCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.ScheduleRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.ScheduleCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleCommandServiceImpl implements  ScheduleCommandService{

    private final ScheduleRepository scheduleRepository;
    private final ValidationUtil validationUtil;

    public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository,
                                      ValidationUtil validationUtil) {
        this.scheduleRepository = scheduleRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    @Transactional
    public List<Schedule> handle(CreateScheduleCommand command) {
        scheduleRepository.deleteAllByTourPackageId(command.packageId());

        TourPackage tourPackage = validationUtil.findTourPackageById(command.packageId());
        List<Schedule> schedules = new ArrayList<>();
        for (ScheduleDto dto : command.scheduleDto()) {
            Schedule schedule = getSchedule(dto, tourPackage);
            scheduleRepository.save(schedule);
            schedules.add(schedule);
        }
        return schedules;
    }

    private static Schedule getSchedule(ScheduleDto dto, TourPackage tourPackage) {
        Schedule schedule = new Schedule();
        schedule.setTourPackage(tourPackage);
        schedule.setDay(dto.getDay());
        schedule.setStartHour(dto.getHourRange().getStart().getHour());
        schedule.setStartMinute(dto.getHourRange().getStart().getMinute());
        schedule.setStartDayTime(dto.getHourRange().getStart().getDayTime());

        schedule.setEndHour(dto.getHourRange().getEnd().getHour());
        schedule.setEndMinute(dto.getHourRange().getEnd().getMinute());
        schedule.setEndDayTime(dto.getHourRange().getEnd().getDayTime());
        return schedule;
    }
}

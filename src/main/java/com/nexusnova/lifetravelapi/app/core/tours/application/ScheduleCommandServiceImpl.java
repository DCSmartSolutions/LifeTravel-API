package com.nexusnova.lifetravelapi.app.core.tours.application;


import com.nexusnova.lifetravelapi.app.core.tours.domain.commands.CreateScheduleCommand;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.Schedule;
import com.nexusnova.lifetravelapi.app.core.tours.domain.model.TourPackage;
import com.nexusnova.lifetravelapi.app.core.tours.domain.repositories.ScheduleRepository;
import com.nexusnova.lifetravelapi.app.core.tours.domain.services.ScheduleCommandService;
import com.nexusnova.lifetravelapi.app.core.tours.resources.requests.ScheduleDto;
import com.nexusnova.lifetravelapi.app.shared.ValidationUtil;
import org.springframework.stereotype.Service;

@Service
public class ScheduleCommandServiceImpl implements ScheduleCommandService {

    private final ScheduleRepository scheduleRepository;
    private final ValidationUtil validationUtil;

    public ScheduleCommandServiceImpl(ScheduleRepository scheduleRepository,
                                      ValidationUtil validationUtil) {
        this.scheduleRepository = scheduleRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public Schedule handle(CreateScheduleCommand command) {
        Schedule schedule = new Schedule();
        TourPackage tourPackage = validationUtil.findTourPackageById(command.packageId());
        ScheduleDto dto = command.scheduleDto();

        schedule.setTourPackage(tourPackage);
        schedule.setDay(dto.getDay());

        schedule.setStartHour(dto.getHourRange().getStart().getHour());
        schedule.setStartMinute(dto.getHourRange().getStart().getMinute());
        schedule.setStartDayTime(dto.getHourRange().getStart().getDayTime());

        schedule.setEndHour(dto.getHourRange().getEnd().getHour());
        schedule.setEndMinute(dto.getHourRange().getEnd().getMinute());
        schedule.setEndDayTime(dto.getHourRange().getEnd().getDayTime());

        scheduleRepository.save(schedule);
        return schedule;
    }
}

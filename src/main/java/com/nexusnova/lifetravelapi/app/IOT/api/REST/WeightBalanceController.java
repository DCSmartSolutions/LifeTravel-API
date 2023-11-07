package com.nexusnova.lifetravelapi.app.IOT.api.REST;

import com.nexusnova.lifetravelapi.app.IOT.api.transformation.UpdateWeightBalanceCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.IOT.domain.services.WeightBalanceCommandService;
import com.nexusnova.lifetravelapi.app.IOT.resources.requests.WeightBalanceRequestDto;
import com.nexusnova.lifetravelapi.app.shared.util.MessageUtil;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.WEIGHT_BALANCE_UPDATED;

@RestController
@RequestMapping("/api/v1/weight-balances")
@Tag(name="Weather Sensors Controller")
@CrossOrigin
public class WeightBalanceController {

    private final WeightBalanceCommandService weightBalanceCommandService;
    private final MessageUtil messageUtil;

    @Autowired
    public WeightBalanceController(WeightBalanceCommandService weightBalanceCommandService,
                                   MessageUtil messageUtil) {
        this.weightBalanceCommandService = weightBalanceCommandService;
        this.messageUtil = messageUtil;
    }

    @PutMapping("/update-weight/{balanceId}")
    @Operation(summary = "Actualizar Peso", description = "Permite actualizar el peso de la balanza.")
    public void updateWeight(@Parameter @PathVariable("balanceId") Long balanceId,
                               @RequestBody @Valid WeightBalanceRequestDto requestDto,
                               HttpServletResponse response) {
        weightBalanceCommandService.handle(UpdateWeightBalanceCommandFromRequestDtoAssembler.toCommandFromDto(balanceId, requestDto));
        response.setHeader(HeaderConstants.MESSAGES, messageUtil.getMessageByCode(WEIGHT_BALANCE_UPDATED));
    }
}

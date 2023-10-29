package com.nexusnova.lifetravelapi.app.logging.identity.api.REST;

import com.nexusnova.lifetravelapi.app.logging.identity.api.transformation.RegisterUserCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.logging.identity.mapper.IdentityMapper;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.logging.identity.service.UserCommandService;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.summaries.UserSummaryDto;
import com.nexusnova.lifetravelapi.configuration.constants.HeaderConstants;
import com.nexusnova.lifetravelapi.app.shared.util.MessageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.nexusnova.lifetravelapi.configuration.messages.ConfigurationMessages.USER_CREATED;

@RestController
@RequestMapping("/api/v1/users")
@Api(tags = "Api de Usuarios", consumes = "application/json")
@CrossOrigin
public class UserController {
    private final UserCommandService userCommandService;
    private final MessageUtil messageUtil;
    private final IdentityMapper identityMapper;

    public UserController(UserCommandService userCommandService,
                          MessageUtil messageUtil,
                          IdentityMapper identityMapper) {
        this.userCommandService = userCommandService;
        this.messageUtil = messageUtil;
        this.identityMapper = identityMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registrar usuario", notes = "Permite registrar un usuario.")
    public UserSummaryDto save(@RequestBody @Valid UserRequestDto userRequestDto,
                               HttpServletResponse response) {
        User user = userCommandService.handle(RegisterUserCommandFromRequestDtoAssembler.toCommandFromDto(userRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, messageUtil.getMessageByCode(USER_CREATED));
        return identityMapper.userToSummaryDto(user);
    }

}

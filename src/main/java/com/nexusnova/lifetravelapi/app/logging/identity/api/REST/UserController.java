package com.nexusnova.lifetravelapi.app.logging.identity.api.REST;

import com.nexusnova.lifetravelapi.app.logging.identity.api.transformation.RegisterUserAgencyCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.logging.identity.api.transformation.RegisterUserTouristCommandFromRequestDtoAssembler;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.model.User;
import com.nexusnova.lifetravelapi.app.logging.identity.domain.queries.GetUserByIdQuery;
import com.nexusnova.lifetravelapi.app.logging.identity.mapper.IdentityMapper;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.requests.UserRequestDto;
import com.nexusnova.lifetravelapi.app.logging.identity.service.UserCommandService;
import com.nexusnova.lifetravelapi.app.logging.identity.resources.summaries.UserSummaryDto;
import com.nexusnova.lifetravelapi.app.logging.identity.service.UserQueryService;
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
    private final UserQueryService userQueryService;
    private final MessageUtil messageUtil;
    private final IdentityMapper identityMapper;

    public UserController(UserCommandService userCommandService,
                          UserQueryService userQueryService,
                          MessageUtil messageUtil,
                          IdentityMapper identityMapper) {
        this.userCommandService = userCommandService;
        this.userQueryService = userQueryService;
        this.messageUtil = messageUtil;
        this.identityMapper = identityMapper;
    }

    @GetMapping("/login/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Obtener usuario", notes = "Permite obtener un usuario.")
    public UserSummaryDto getUser(@RequestParam String id) {
        User user = userQueryService.handle(new GetUserByIdQuery(id));
        return identityMapper.userToSummaryDto(user);
    }

    @PostMapping("/register/tourist")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registrar usuario", notes = "Permite registrar un usuario.")
    public UserSummaryDto registerTourist(@RequestBody @Valid UserRequestDto userRequestDto,
                               HttpServletResponse response) {
        User user = userCommandService.handle(RegisterUserTouristCommandFromRequestDtoAssembler.toCommandFromDto(userRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, messageUtil.getMessageByCode(USER_CREATED));
        return identityMapper.userToSummaryDto(user);
    }

    @PostMapping("/register/agency")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Registrar usuario", notes = "Permite registrar un usuario.")
    public UserSummaryDto registerAgency(@RequestBody @Valid UserRequestDto userRequestDto,
                               HttpServletResponse response) {
        User user = userCommandService.handle(RegisterUserAgencyCommandFromRequestDtoAssembler.toCommandFromDto(userRequestDto));
        response.setHeader(HeaderConstants.MESSAGES, messageUtil.getMessageByCode(USER_CREATED));
        return identityMapper.userToSummaryDto(user);
    }

}

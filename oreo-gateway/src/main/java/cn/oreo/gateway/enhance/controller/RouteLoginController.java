package cn.oreo.gateway.enhance.controller;

import cn.oreo.common.core.entity.OreoResponse;
import cn.oreo.gateway.enhance.auth.JwtTokenHelper;
import cn.oreo.gateway.enhance.service.RouteUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author GuanMingJian
 * @since 2020/10/6
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("route")
public class RouteLoginController {

    private final JwtTokenHelper tokenHelper;
    private final PasswordEncoder passwordEncoder;
    private final RouteUserService routeUserService;

    @GetMapping("login")
    public Mono<ResponseEntity<OreoResponse>> login(String username, String password) {
        String error = "认证失败，用户名或密码错误";
        return routeUserService.findByUsername(username)
                .map(u -> passwordEncoder.matches(password, u.getPassword()) ?
                        ResponseEntity.ok(new OreoResponse().data(tokenHelper.generateToken(u))) :
                        new ResponseEntity<>(new OreoResponse().message(error), HttpStatus.INTERNAL_SERVER_ERROR))
                .defaultIfEmpty(new ResponseEntity<>(new OreoResponse().message(error), HttpStatus.INTERNAL_SERVER_ERROR));
    }
}

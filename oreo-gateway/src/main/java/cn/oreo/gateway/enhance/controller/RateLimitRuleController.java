package cn.oreo.gateway.enhance.controller;

import cn.oreo.common.core.entity.QueryRequest;
import cn.oreo.gateway.enhance.entity.RateLimitRule;
import cn.oreo.gateway.enhance.service.RateLimitRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author GuanMingJian
 * @since 2020/10/6
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("route/auth/rateLimitRule")
public class RateLimitRuleController {

    private final RateLimitRuleService rateLimitRuleService;

    @GetMapping("data")
    public Flux<RateLimitRule> findUserPages(QueryRequest request, RateLimitRule rateLimitRule) {
        return rateLimitRuleService.findPages(request, rateLimitRule);
    }

    @GetMapping("count")
    public Mono<Long> findUserCount(RateLimitRule rateLimitRule) {
        return rateLimitRuleService.findCount(rateLimitRule);
    }

    @GetMapping("exist")
    public Flux<RateLimitRule> findByRequestUriAndRequestMethod(String requestUri, String requestMethod) {
        return rateLimitRuleService.findByRequestUriAndRequestMethod(requestUri, requestMethod);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin')")
    public Mono<RateLimitRule> createRateLimitRule(RateLimitRule rateLimitRule) {
        return rateLimitRuleService.create(rateLimitRule);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('admin')")
    public Mono<RateLimitRule> updateRateLimitRule(RateLimitRule rateLimitRule) {
        return rateLimitRuleService.update(rateLimitRule);
    }

    @DeleteMapping
    @PreAuthorize("hasAuthority('admin')")
    public Flux<RateLimitRule> deleteRateLimitRule(String ids) {
        return rateLimitRuleService.delete(ids);
    }
}

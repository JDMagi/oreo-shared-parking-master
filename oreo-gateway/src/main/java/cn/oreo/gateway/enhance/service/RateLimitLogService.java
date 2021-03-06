package cn.oreo.gateway.enhance.service;

import cn.oreo.common.core.entity.QueryRequest;
import cn.oreo.gateway.enhance.entity.RateLimitLog;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author GuanMingJian
 * @since 2020/10/6
 */
public interface RateLimitLogService {

    /**
     * 创建限流日志
     *
     * @param rateLimitLog 限流日志
     * @return 限流日志
     */
    Mono<RateLimitLog> create(RateLimitLog rateLimitLog);

    /**
     * 删除限流日志
     *
     * @param ids 限流日志id
     * @return 被删除的限流日志
     */
    Flux<RateLimitLog> delete(String ids);

    /**
     * 查找限流日志分页数据
     *
     * @param request      request
     * @param rateLimitLog rateLimitLog
     * @return 限流日志分页数据
     */
    Flux<RateLimitLog> findPages(QueryRequest request, RateLimitLog rateLimitLog);

    /**
     * 查找限流日志分页数据count
     *
     * @param rateLimitLog rateLimitLog
     * @return 限流日志分页数据count
     */
    Mono<Long> findCount(RateLimitLog rateLimitLog);
}

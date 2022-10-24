package com.example.oxy.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author konakona
 * @date 2021/11/25 13:19
 * @功能：
 * 不要定义太多线程池呀，控制一下，合并一下
 */
@Configuration
public class ThreadPoolConf {

    @Value("${cloud.object.engine.thread-pool.data-select.core:50}") private Integer dataSelectThreadPoolCore;
    @Value("${cloud.object.engine.thread-pool.data-select.max:200}") private Integer dataSelectThreadPoolMax;

    @Bean("dataSelectTaskExecutor")
    public Executor dataSelectTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(dataSelectThreadPoolCore);
        executor.setMaxPoolSize(dataSelectThreadPoolMax);
        // 不使用队列，避免线程队列等待增加时间
        executor.setQueueCapacity(-1);
        executor.setThreadNamePrefix("data-select-");

        // 对拒绝task的处理策略
        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        // 等待所有任务结束后再关闭线程池
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return TtlExecutors.getTtlExecutor(executor);
    }

}

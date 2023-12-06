package com.aisino.service.impl;

import com.aisino.service.JxptCyrzNewService;
import com.aisino.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;


import java.util.concurrent.ScheduledFuture;

/**
 * @author lw
 * @date 2023/6/28 14:12
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    
    private ScheduledFuture<?> future;
    private final ThreadPoolTaskScheduler threadPoolTaskscheduler;
    private final JxptCyrzNewService jxptCyrzNewService;
    /**
     * 定时器启动
     *
     * @author lw
     * @date 2023/6/28 14:11
     */
    @Override
    public Boolean startCorn(String cron) {
        if (future != null) {
            future.cancel(true);
            log.info("定时任务已停止");
        }
        //每10秒执行一次
        //String cornConfig = "0/20 * * * * *";
        future = threadPoolTaskscheduler.schedule(() -> {
            jxptCyrzNewService.check();
        }, new CronTrigger(cron));
        log.info("定时任务开启");
        return false;
    }
    
    /**
     * 定时器停止
     *
     * @author lw
     * @date 2023/6/28 14:11
     */
    @Override
    public Boolean stopCorn() {
        if (future != null) {
            future.cancel(true);
            log.info("定时任务已停止");
        }
        return false;
    }
    /*static class scheduledTaskRunnable implements Runnable {
        @Override
        public void run() {
            //需要执行的业务逻辑
            log.info("执行业务逻辑 {}", LocalDateTime.now());
        }
    }*/
}

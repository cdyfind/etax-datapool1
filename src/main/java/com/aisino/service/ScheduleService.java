package com.aisino.service;

/**
 * @author lw
 * @date 2023/6/28 14:06
 */
public interface ScheduleService {
    /**
     * 定时器启动
     *
     * @author lw
     * @date 2023/6/28 14:11
     */
    Boolean startCorn(String cron);
    
    /**
     * 定时器停止
     *
     * @author lw
     * @date 2023/6/28 14:11
     */
    Boolean stopCorn();
}

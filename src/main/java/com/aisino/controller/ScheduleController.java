package com.aisino.controller;

import com.aisino.base.R;
import com.aisino.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 手动控制定时任务
 *
 * @author lw
 * @date 2023/6/28 14:05
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/setSchedule")
public class ScheduleController {
    
    private final ScheduleService scheduleService;
    
    /**
     * 开启任务
     * corn = "0/10 * * * * *"
     * @param cron 表达式
     * @author lw
     * @date 2023/6/28 14:20
     */
    @PostMapping("/start")
    public R startSchedule(@RequestParam("cron") String cron) {
        scheduleService.startCorn(cron);
        return R.success("定时器任务开始执行");
    }
    
    @PostMapping("/stop")
    public R stopCron() {
        scheduleService.stopCorn();
        return R.success("定时任务关闭成功！");
    }
}

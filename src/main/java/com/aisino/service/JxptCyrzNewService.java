package com.aisino.service;


import com.aisino.entity.JxptCyrzNew;
import com.baomidou.mybatisplus.extension.service.IService;


public interface JxptCyrzNewService  extends IService<JxptCyrzNew> {
    /**
     *
     * @param entity
     * @return
     */
    public JxptCyrzNew saveJxptCyrzNew(JxptCyrzNew entity);

    void check();
}

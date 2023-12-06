package com.aisino.controller;

import com.aisino.base.R;
import com.aisino.entity.JxptCyrzNew;
import com.aisino.service.JxptCyrzNewService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static com.aisino.base.R.success;
/**
 * (JxptCyrzNew)表控制层
 *
 * @author cdy
 * @since 2023-06-18 11:07:46
 */
@Api(tags = "查询历史查验数据")
@RestController
@RequestMapping("jxptcyrznew")
public class JxptCyrzNewController {
    /**
     * 服务对象
     */
    @Resource
    private JxptCyrzNewService jxptCyrzNewService;


    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param jxptCyrzNew 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = " 分页查询所有数据")
    @GetMapping
    public R selectAll(Page<JxptCyrzNew> page, JxptCyrzNew jxptCyrzNew) {
        return success(this.jxptCyrzNewService.page(page, new QueryWrapper<>(jxptCyrzNew)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "  通过id查询单条数据")
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.jxptCyrzNewService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param jxptCyrzNew 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "  新增数据")
    @PostMapping
    public R insert(@RequestBody JxptCyrzNew jxptCyrzNew) {
        return success(this.jxptCyrzNewService.saveJxptCyrzNew(jxptCyrzNew));
    }

    /**
     * 修改数据
     *
     * @param jxptCyrzNew 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "  修改数据")
    @PutMapping
    public R update(@RequestBody JxptCyrzNew jxptCyrzNew) {
        return success(this.jxptCyrzNewService.updateById(jxptCyrzNew));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = " 删除数据")
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.jxptCyrzNewService.removeByIds(idList));
    }

}

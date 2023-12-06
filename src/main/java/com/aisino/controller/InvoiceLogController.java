package com.aisino.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.aisino.base.R;
import static com.aisino.base.R.success;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.aisino.entity.InvoiceLog;
import com.aisino.service.InvoiceLogService;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 调用记录日志表(InvoiceLog)表控制层
 *
 * @author cdy
 * @since 2023-06-14 13:48:16
 */
@Api(tags = "调用记录日志表(InvoiceLog)")
@RestController
@RequestMapping("invoiceLog")
public class InvoiceLogController {
    /**
     * 服务对象
     */
    @Resource
    private InvoiceLogService invoiceLogService;
    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param invoiceLog 查询实体
     * @return 所有数据
     */
    @ApiOperation(value = "查询带分页 调用记录日志表")
    @GetMapping
    public R selectAll(Page<InvoiceLog> page, InvoiceLog invoiceLog) {
        return success(this.invoiceLogService.page(page, new QueryWrapper<>(invoiceLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "根据id查询 调用记录日志表") 
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.invoiceLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param invoiceLog 实体对象
     * @return 新增结果
     */
    @ApiOperation(value = "保存 调用记录日志表")
    @PostMapping
    public R insert(@RequestBody InvoiceLog invoiceLog) {
        return success(this.invoiceLogService.saveInvoiceLogService(invoiceLog));
    }

    /**
     * 修改数据
     *
     * @param invoiceLog 实体对象
     * @return 修改结果
     */
    @ApiOperation(value = "编辑 调用记录日志表") 
    @PutMapping
    public R update(@RequestBody InvoiceLog invoiceLog) {
        return success(this.invoiceLogService.updateById(invoiceLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @ApiOperation(value = "根据id删除 调用记录日志表") 
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.invoiceLogService.removeByIds(idList));
    }
}


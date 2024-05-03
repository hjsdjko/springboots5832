package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.YouxifahuoEntity;
import com.entity.view.YouxifahuoView;

import com.service.YouxifahuoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 游戏发货
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
@RestController
@RequestMapping("/youxifahuo")
public class YouxifahuoController {
    @Autowired
    private YouxifahuoService youxifahuoService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YouxifahuoEntity youxifahuo,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			youxifahuo.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YouxifahuoEntity> ew = new EntityWrapper<YouxifahuoEntity>();

		PageUtils page = youxifahuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxifahuo), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YouxifahuoEntity youxifahuo, 
		HttpServletRequest request){
        EntityWrapper<YouxifahuoEntity> ew = new EntityWrapper<YouxifahuoEntity>();

		PageUtils page = youxifahuoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youxifahuo), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YouxifahuoEntity youxifahuo){
       	EntityWrapper<YouxifahuoEntity> ew = new EntityWrapper<YouxifahuoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youxifahuo, "youxifahuo")); 
        return R.ok().put("data", youxifahuoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YouxifahuoEntity youxifahuo){
        EntityWrapper< YouxifahuoEntity> ew = new EntityWrapper< YouxifahuoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youxifahuo, "youxifahuo")); 
		YouxifahuoView youxifahuoView =  youxifahuoService.selectView(ew);
		return R.ok("查询游戏发货成功").put("data", youxifahuoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YouxifahuoEntity youxifahuo = youxifahuoService.selectById(id);
        return R.ok().put("data", youxifahuo);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YouxifahuoEntity youxifahuo = youxifahuoService.selectById(id);
        return R.ok().put("data", youxifahuo);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YouxifahuoEntity youxifahuo, HttpServletRequest request){
    	youxifahuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxifahuo);
        youxifahuoService.insert(youxifahuo);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YouxifahuoEntity youxifahuo, HttpServletRequest request){
    	youxifahuo.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youxifahuo);
        youxifahuoService.insert(youxifahuo);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YouxifahuoEntity youxifahuo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youxifahuo);
        youxifahuoService.updateById(youxifahuo);//全部更新
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youxifahuoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}

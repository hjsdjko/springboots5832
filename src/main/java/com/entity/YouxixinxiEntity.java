package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 游戏信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
@TableName("youxixinxi")
public class YouxixinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public YouxixinxiEntity() {
		
	}
	
	public YouxixinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 游戏编号
	 */
					
	private String youxibianhao;
	
	/**
	 * 游戏名称
	 */
					
	private String youximingcheng;
	
	/**
	 * 游戏类型
	 */
					
	private String youxileixing;
	
	/**
	 * 游戏封面
	 */
					
	private String youxifengmian;
	
	/**
	 * 视频介绍
	 */
					
	private String shipinjieshao;
	
	/**
	 * 单价
	 */
					
	private Integer danjia;
	
	/**
	 * 游戏厂商
	 */
					
	private String youxichangshang;
	
	/**
	 * 游戏热度
	 */
					
	private String youxiredu;
	
	/**
	 * 游戏详情
	 */
					
	private String youxixiangqing;
	
	/**
	 * 更新时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date gengxinshijian;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 点击次数
	 */
					
	private Integer clicknum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：游戏编号
	 */
	public void setYouxibianhao(String youxibianhao) {
		this.youxibianhao = youxibianhao;
	}
	/**
	 * 获取：游戏编号
	 */
	public String getYouxibianhao() {
		return youxibianhao;
	}
	/**
	 * 设置：游戏名称
	 */
	public void setYouximingcheng(String youximingcheng) {
		this.youximingcheng = youximingcheng;
	}
	/**
	 * 获取：游戏名称
	 */
	public String getYouximingcheng() {
		return youximingcheng;
	}
	/**
	 * 设置：游戏类型
	 */
	public void setYouxileixing(String youxileixing) {
		this.youxileixing = youxileixing;
	}
	/**
	 * 获取：游戏类型
	 */
	public String getYouxileixing() {
		return youxileixing;
	}
	/**
	 * 设置：游戏封面
	 */
	public void setYouxifengmian(String youxifengmian) {
		this.youxifengmian = youxifengmian;
	}
	/**
	 * 获取：游戏封面
	 */
	public String getYouxifengmian() {
		return youxifengmian;
	}
	/**
	 * 设置：视频介绍
	 */
	public void setShipinjieshao(String shipinjieshao) {
		this.shipinjieshao = shipinjieshao;
	}
	/**
	 * 获取：视频介绍
	 */
	public String getShipinjieshao() {
		return shipinjieshao;
	}
	/**
	 * 设置：单价
	 */
	public void setDanjia(Integer danjia) {
		this.danjia = danjia;
	}
	/**
	 * 获取：单价
	 */
	public Integer getDanjia() {
		return danjia;
	}
	/**
	 * 设置：游戏厂商
	 */
	public void setYouxichangshang(String youxichangshang) {
		this.youxichangshang = youxichangshang;
	}
	/**
	 * 获取：游戏厂商
	 */
	public String getYouxichangshang() {
		return youxichangshang;
	}
	/**
	 * 设置：游戏热度
	 */
	public void setYouxiredu(String youxiredu) {
		this.youxiredu = youxiredu;
	}
	/**
	 * 获取：游戏热度
	 */
	public String getYouxiredu() {
		return youxiredu;
	}
	/**
	 * 设置：游戏详情
	 */
	public void setYouxixiangqing(String youxixiangqing) {
		this.youxixiangqing = youxixiangqing;
	}
	/**
	 * 获取：游戏详情
	 */
	public String getYouxixiangqing() {
		return youxixiangqing;
	}
	/**
	 * 设置：更新时间
	 */
	public void setGengxinshijian(Date gengxinshijian) {
		this.gengxinshijian = gengxinshijian;
	}
	/**
	 * 获取：更新时间
	 */
	public Date getGengxinshijian() {
		return gengxinshijian;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
	}
	/**
	 * 设置：点击次数
	 */
	public void setClicknum(Integer clicknum) {
		this.clicknum = clicknum;
	}
	/**
	 * 获取：点击次数
	 */
	public Integer getClicknum() {
		return clicknum;
	}

}

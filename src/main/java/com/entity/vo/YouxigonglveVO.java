package com.entity.vo;

import com.entity.YouxigonglveEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 游戏攻略
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
public class YouxigonglveVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 游戏类型
	 */
	
	private String youxileixing;
		
	/**
	 * 游戏厂商
	 */
	
	private String youxichangshang;
		
	/**
	 * 攻略关卡
	 */
	
	private String gonglveguanka;
		
	/**
	 * 攻略视频
	 */
	
	private String gonglveshipin;
		
	/**
	 * 游戏封面
	 */
	
	private String youxifengmian;
		
	/**
	 * 游戏攻略
	 */
	
	private String youxigonglve;
		
	/**
	 * 发布时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date fabushijian;
				
	
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
	 * 设置：攻略关卡
	 */
	 
	public void setGonglveguanka(String gonglveguanka) {
		this.gonglveguanka = gonglveguanka;
	}
	
	/**
	 * 获取：攻略关卡
	 */
	public String getGonglveguanka() {
		return gonglveguanka;
	}
				
	
	/**
	 * 设置：攻略视频
	 */
	 
	public void setGonglveshipin(String gonglveshipin) {
		this.gonglveshipin = gonglveshipin;
	}
	
	/**
	 * 获取：攻略视频
	 */
	public String getGonglveshipin() {
		return gonglveshipin;
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
	 * 设置：游戏攻略
	 */
	 
	public void setYouxigonglve(String youxigonglve) {
		this.youxigonglve = youxigonglve;
	}
	
	/**
	 * 获取：游戏攻略
	 */
	public String getYouxigonglve() {
		return youxigonglve;
	}
				
	
	/**
	 * 设置：发布时间
	 */
	 
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
			
}

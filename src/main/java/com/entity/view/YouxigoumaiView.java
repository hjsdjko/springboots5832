package com.entity.view;

import com.entity.YouxigoumaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 游戏购买
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
@TableName("youxigoumai")
public class YouxigoumaiView  extends YouxigoumaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YouxigoumaiView(){
	}
 
 	public YouxigoumaiView(YouxigoumaiEntity youxigoumaiEntity){
 	try {
			BeanUtils.copyProperties(this, youxigoumaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

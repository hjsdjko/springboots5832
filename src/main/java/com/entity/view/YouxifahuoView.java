package com.entity.view;

import com.entity.YouxifahuoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 游戏发货
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
@TableName("youxifahuo")
public class YouxifahuoView  extends YouxifahuoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YouxifahuoView(){
	}
 
 	public YouxifahuoView(YouxifahuoEntity youxifahuoEntity){
 	try {
			BeanUtils.copyProperties(this, youxifahuoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

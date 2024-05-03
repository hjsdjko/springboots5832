package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxifahuoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxifahuoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxifahuoView;


/**
 * 游戏发货
 *
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
public interface YouxifahuoService extends IService<YouxifahuoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxifahuoVO> selectListVO(Wrapper<YouxifahuoEntity> wrapper);
   	
   	YouxifahuoVO selectVO(@Param("ew") Wrapper<YouxifahuoEntity> wrapper);
   	
   	List<YouxifahuoView> selectListView(Wrapper<YouxifahuoEntity> wrapper);
   	
   	YouxifahuoView selectView(@Param("ew") Wrapper<YouxifahuoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxifahuoEntity> wrapper);
   	

}


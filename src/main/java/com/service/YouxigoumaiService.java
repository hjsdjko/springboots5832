package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YouxigoumaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YouxigoumaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YouxigoumaiView;


/**
 * 游戏购买
 *
 * @author 
 * @email 
 * @date 2023-04-23 10:19:25
 */
public interface YouxigoumaiService extends IService<YouxigoumaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YouxigoumaiVO> selectListVO(Wrapper<YouxigoumaiEntity> wrapper);
   	
   	YouxigoumaiVO selectVO(@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);
   	
   	List<YouxigoumaiView> selectListView(Wrapper<YouxigoumaiEntity> wrapper);
   	
   	YouxigoumaiView selectView(@Param("ew") Wrapper<YouxigoumaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YouxigoumaiEntity> wrapper);
   	

}


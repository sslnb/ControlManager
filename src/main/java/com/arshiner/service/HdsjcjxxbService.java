package com.arshiner.service;

import com.arshiner.model.Hdsjcjxxb;
import java.util.List;

public interface HdsjcjxxbService {
    int countByExample(Hdsjcjxxb record);

    int deleteByExample(Hdsjcjxxb record);

    int insert(Hdsjcjxxb record);

    int insertSelective(Hdsjcjxxb record);

    List<Hdsjcjxxb> selectByExample(Hdsjcjxxb record);
    List<Hdsjcjxxb> selectByAllByCjBj(Hdsjcjxxb record);

    int updateByExampleSelective(Hdsjcjxxb record);

    int updateByExample(Hdsjcjxxb record);
    
    /**
     * 如果有就更新根据核对批号
     * @param record
     */
    public void saveOrupdate(Hdsjcjxxb record);

	List<Hdsjcjxxb> selectBySbzt(Hdsjcjxxb record);
}
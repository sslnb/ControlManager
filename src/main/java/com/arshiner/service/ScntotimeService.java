package com.arshiner.service;

import java.util.List;


import com.arshiner.model.Scntotime;

public interface ScntotimeService {
	 int countByExample(Scntotime record);

	    int deleteByExample(Scntotime record);

	    int insert(Scntotime record);

	    int insertSelective(Scntotime record);

	    List<Scntotime> selectByExample(Scntotime record);

	    int updateByExampleSelective(Scntotime record);

	    int updateByExample(Scntotime record);
	    
	    void saveOrupdate(Scntotime record);
}

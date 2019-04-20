package com.arshiner.service;

import com.arshiner.model.Babh;
import java.util.List;


/**
 * @author mdk
 * @Date: 15:30 2018/12/21
 * @Description: (类描述)
 */
public interface BaBhService {
	  int countByExample(Babh record);

	    int deleteByExample();

	    int insert(Babh record);

	    int insertSelective(Babh record);

	    List<Babh> selectByExample(Babh record);

	    int updateByExampleSelective(Babh record);

	    int updateByExample( Babh record);

	    List<Babh> selAllBaBh(int before,  int after);

	    int countBaBh();

		int insBaBhInfo(Babh babh);
		void saveOrupdate(Babh babh);
}

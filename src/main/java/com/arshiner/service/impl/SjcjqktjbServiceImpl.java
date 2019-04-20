package com.arshiner.service.impl;

import com.arshiner.dao.SjcjqktjbMapper;
import com.arshiner.model.Sjcjqktjb;
import com.arshiner.model.SjcjqktjbExample;
import com.arshiner.service.SjcjqktjbService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据采集情况统计表
 * @author 士林
 *
 */
@Service("sjcjqktjbService")
public class SjcjqktjbServiceImpl implements SjcjqktjbService {

    @Resource
    private SjcjqktjbMapper sjcjqktjbMapper;

    @Override
    public int countByExample() {
    	SjcjqktjbExample  example = new SjcjqktjbExample();
    	example.createCriteria();
        return sjcjqktjbMapper.countByExample(example);
    }

    @Override
    public int deleteByExample(Sjcjqktjb record) {
    	SjcjqktjbExample  example = new SjcjqktjbExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh())
    	.andJgxtlbEqualTo(record.getJgxtlb());
        return sjcjqktjbMapper.deleteByExample(example);
    }

    @Override
    public int insert(Sjcjqktjb record) {
        return sjcjqktjbMapper.insert(record);
    }

    @Override
    public int insertSelective(Sjcjqktjb record) {
        return sjcjqktjbMapper.insertSelective(record);
    }

    @Override
    public List<Sjcjqktjb> selectByExample(Sjcjqktjb record) {
    	SjcjqktjbExample  example = new SjcjqktjbExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh())
    	.andJgxtlbEqualTo(record.getJgxtlb());
        return sjcjqktjbMapper.selectByExample(example);
    }

    @Override
    public int updateByExampleSelective(Sjcjqktjb record) {
    	SjcjqktjbExample  example = new SjcjqktjbExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh())
    	.andJgxtlbEqualTo(record.getJgxtlb());
        return sjcjqktjbMapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExample(Sjcjqktjb record) {
    	SjcjqktjbExample  example = new SjcjqktjbExample();
    	example.createCriteria().andBabhEqualTo(record.getBabh())
    	.andJgxtlbEqualTo(record.getJgxtlb());
        return sjcjqktjbMapper.updateByExample(record, example);
    }

	@Override
	public void saveOrupdate(Sjcjqktjb sjcjqk) {
		// TODO Auto-generated method stub
		if (selectByExample(sjcjqk).isEmpty()) {
			insertSelective(sjcjqk);
		}else{
			updateByExampleSelective(sjcjqk);
		}
		
	}
}

package com.arshiner.service;

import com.arshiner.model.Asession;

public interface AsessionService {

	Asession selsession(String jgxtlb,String sid,String serial,String t);
	   void delsession(String jgxtlb,String t);
}

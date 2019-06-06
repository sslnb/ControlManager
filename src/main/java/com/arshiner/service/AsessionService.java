package com.arshiner.service;

import com.arshiner.model.Asession;

public interface AsessionService {

	Asession selsession1(String jgxtlb,String sid,String serial,String t);
	Asession selsession2(String jgxtlb,String sid,String t);
	Asession selsession3(String jgxtlb,String t);
	   void delsession(String jgxtlb,String t);
}

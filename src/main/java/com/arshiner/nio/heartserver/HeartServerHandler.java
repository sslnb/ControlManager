package com.arshiner.nio.heartserver;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.arshiner.common.Heart;
import com.arshiner.model.Agent;
import com.arshiner.service.AgentService;
import com.arshiner.util.SpringUtil;

/**
 * 心跳存储
 * @author 士林
 *
 */
@Component
public class HeartServerHandler extends ChannelInboundHandlerAdapter {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-ss");
	public static HashMap<String, String> heartmap =new HashMap<>();
	public static HashMap<String, String> agentstatus = new HashMap<>();
	String xtxlh="";//心跳序列号
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (msg instanceof List) {
			AgentService agentService =(AgentService) SpringUtil.getBean("agentService");
			List<?> list = (List<?>) msg;
			if (!list.isEmpty()) {
				for (Iterator<?> iterator = list.iterator(); iterator.hasNext();) {
					Heart heart = (Heart) iterator.next();
					Agent agent = new Agent();
					agent.setCp(new BigDecimal(heart.getCp()));
					agent.setCpu(new BigDecimal(heart.getCpu()));
					agent.setKip(heart.getLogo());
					agent.setJgxtlb(heart.getJgxtlb());
					agent.setNc(new BigDecimal(heart.getNc()));
					agent.setTime(getTime());
					agent.setStaius("1");
					agentService.saveOrupdate(agent);
				}
				ctx.close();
				
			}else{
				ctx.close();
			}
		}
	}
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
		cause.printStackTrace();
		ctx.close();
	}
	
	public Timestamp getTime() {
		Date utilDate = new Date();// util.Date
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}
	
}

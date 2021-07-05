package org.apache.dubbo.demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HvacGatewayInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer gwAddr;
	private Integer gwType;
	private Integer outAddr;//新风或者地暖的情况下需要设置一下，方便第一次连接上来时主动获取数据
	private Integer innerAddr;//新风或者地暖的情况下需要设置一下，方便第一次连接上来时主动获取数据
	
	private Long id;
	private Long openUserId;
	private Integer addr;
	private Integer type;
	private String code;//网关编号
	private Integer networkType;//网关网络类型
	private Integer status;//0下线，1上线
	private String ip;//设备ip
	private String address;//设备地址
	private String username;//用户名
	
}

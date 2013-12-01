package com.aa.smslocator.backend.api;

import java.util.List;

import com.aa.smslocator.backend.persistence.SmsDataStore;
import com.aa.smslocator.backend.resource.SmsResource;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;

@Api(
	name = "smsLocator",
	version = "v1",
	defaultVersion = AnnotationBoolean.TRUE,
	clientIds = {com.google.api.server.spi.Constant.API_EXPLORER_CLIENT_ID}
)
public class SmsProcessor {
	
	@ApiMethod(name = "sms.save", httpMethod = HttpMethod.POST)
	public ApiResponse saveSms(SmsResource smsResource) {
		if(SmsDataStore.save(smsResource)) return ApiResponse.ok();
		else return ApiResponse.failed();
	}
	
	@ApiMethod(name = "sms.delete", httpMethod = HttpMethod.DELETE)
	public ApiResponse deleteSms(@Named("id") long id) {
		if(SmsDataStore.delete(id)) return ApiResponse.ok();
		else return ApiResponse.failed();
	}
	
	@ApiMethod(name = "sms.listForReceiver")
	public List<SmsResource> listSmsForReceiver(@Named("receiver") String receiver) {
		return SmsDataStore.listReceiverSms(receiver);		
	}
}

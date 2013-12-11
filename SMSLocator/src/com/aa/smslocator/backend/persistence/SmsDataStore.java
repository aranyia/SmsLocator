package com.aa.smslocator.backend.persistence;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.List;

import com.aa.smslocator.backend.persistence.entity.SmsEntity;
import com.aa.smslocator.backend.resource.SmsResource;
import com.googlecode.objectify.cmd.LoadType;

public class SmsDataStore {
	private static final String SMS_FIELD_RECEIVER = "receiver";

	public static boolean save(SmsResource smsResource) {
		if(smsResource == null) return false;
		
		final SmsEntity smsEntity = SmsEntity.wrap(smsResource);
		if(smsEntity == null) return false;
		
		ofy().save().entity(smsEntity);
		return true;
	}

	public static boolean delete(final long id) {
		if(id <= 0) return false;
		try {
			ofy().delete().type(SmsEntity.class).id(id);
			return true;
		} catch(Exception e) { return false; }
	}

	public static List<SmsResource> listReceiverSms(String receiver) {
		final LoadType<SmsEntity> loadSms = ofy().load().type(SmsEntity.class);
		
		final List<SmsEntity> smsEntities = loadSms.filter(SMS_FIELD_RECEIVER, receiver)
												   .order("-time").list();
		final List<SmsResource> smsList = new ArrayList<SmsResource>(smsEntities.size());
		
		for(SmsEntity smsEntity : smsEntities) {
			final SmsResource sms = smsEntity.getResource();
			if(sms != null) smsList.add(sms);
		}
		return smsList;
	}
}

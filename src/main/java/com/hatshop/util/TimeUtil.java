package com.hatshop.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeUtil {
	public static Instant getInstantNow() {
		ZoneId zone = ZoneId.of("UTC+7");
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(Instant.now(), zone);

		Instant instant = zonedDateTime.toInstant();
		return instant;
	}
	
}

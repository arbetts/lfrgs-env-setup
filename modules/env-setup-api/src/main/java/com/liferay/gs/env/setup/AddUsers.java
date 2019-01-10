package com.liferay.gs.env.setup;

import com.liferay.gs.env.setup.config.UserConfig;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * @author Andrew Betts
 */
public interface AddUsers {

	enum Find {
		BY_CONTACT_ID,
		BY_EMAIL_ADDRESS,
		BY_FACEBOOK_ID,
		BY_GOOGLE_USER_ID,
		BY_OPEN_ID,
		BY_SCREEN_NAME,
		BY_USER_ID
	}

	void addUsers(long companyId, UserConfig[] userConfigs)
		throws PortalException;

}

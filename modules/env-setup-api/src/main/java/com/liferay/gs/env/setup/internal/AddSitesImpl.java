package com.liferay.gs.env.setup.internal;

import com.liferay.gs.env.setup.AddSites;
import com.liferay.gs.env.setup.config.SiteConfig;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Andrew Betts
 */
@Component
public class AddSitesImpl implements AddSites {

	@Override
	public Group[] addSites(
			long companyId, SiteConfig[] siteContexts)
		throws PortalException {

		Group companyGroup = _groupLocalService.getCompanyGroup(companyId);

		Group[] groups = new Group[siteContexts.length];

		for (int i = 0; i < siteContexts.length; i++) {
			SiteConfig siteContext = siteContexts[i];

			String groupFriendlyURL = siteContext.getGroupFriendlyURL();

			Group group = _groupLocalService.fetchFriendlyURLGroup(
				companyId, groupFriendlyURL);

			if (group == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(
						"creating group with {groupFriendlyURL:" +
							groupFriendlyURL + "}");
				}

				group = _groupLocalService.addGroup(
					companyGroup.getCreatorUserId(), 0, null, 0, 0,
					siteContext.getNameMap(), siteContext.getDescriptionMap(),
					siteContext.getGroupType(),
					siteContext.getManualMembership(),
					siteContext.getMembershipRestriction(),
					groupFriendlyURL, true, true,
					new ServiceContext());
			}
			else if (_log.isDebugEnabled()) {
				_log.debug(
					"group already exists: {groupFriendlyURL:" +
						groupFriendlyURL + "}");
			}

			groups[i] = group;
		}

		if (_log.isInfoEnabled()) {
			_log.info(groups.length + " groups added");
		}

		return groups;
	}

	private static final Log _log = LogFactoryUtil.getLog(AddSitesImpl.class);

	@Reference
	private GroupLocalService _groupLocalService;

}
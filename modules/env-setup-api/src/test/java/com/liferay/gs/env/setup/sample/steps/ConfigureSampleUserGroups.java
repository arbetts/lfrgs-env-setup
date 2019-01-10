package com.liferay.gs.env.setup.sample.steps;

import com.liferay.gs.env.setup.AssignUserGroupGroupRoles;
import com.liferay.gs.env.setup.sample.SampleData;
import com.liferay.gs.env.setup.EnvSetupStep;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class ConfigureSampleUserGroups implements EnvSetupStep {

	@Override
	public void doStep(long companyId) throws PortalException {
		Group group = groupLocalService.getGroup(
			companyId, SampleData.SAMPLE_SITE_NAME);

		String[] roleNames = new String[
			SampleData.SAMPLE_ROLE_CONFIGURATION.length];

		for (int i = 0; i < SampleData.SAMPLE_ROLE_CONFIGURATION.length; i++) {
			roleNames[i] =
				SampleData.SAMPLE_ROLE_CONFIGURATION[i].getRoleName();
		}

		assignUserGroupGroupRoles.assignUserGroupGroupRoles(
			companyId, group, SampleData.SAMPLE_USER_GROUP, roleNames);
	}

	@Reference
	private AssignUserGroupGroupRoles assignUserGroupGroupRoles;

	@Reference
	private GroupLocalService groupLocalService;

}
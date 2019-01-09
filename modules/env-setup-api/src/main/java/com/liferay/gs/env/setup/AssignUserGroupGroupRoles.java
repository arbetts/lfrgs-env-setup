package com.liferay.gs.env.setup;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.UserGroup;

/**
 * @author Andrew Betts
 */
public interface AssignUserGroupGroupRoles {

	void addUserGroupGroupRoles(
			long companyId, Group group, String[] userGroupNames,
			String roleName)
		throws PortalException;

	void addUserGroupGroupRoles(
			long companyId, Group group, String userGroupName,
			String[] roleNames)
		throws PortalException;

	void addUserGroupGroupRole(
		long companyId, Group group, UserGroup userGroup, Role role);

}
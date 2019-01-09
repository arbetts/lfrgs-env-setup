package com.liferay.gs.env.setup.sample;

import com.liferay.gs.env.setup.config.LayoutConfig;
import com.liferay.gs.env.setup.config.RoleConfig;
import com.liferay.gs.env.setup.config.SiteConfig;
import com.liferay.gs.env.setup.config.UserGroupConfig;
import com.liferay.portal.kernel.model.LayoutConstants;

public class SampleData {

	public static final String SAMPLE_SITE_NAME = "gs";

	public static final String SAMPLE_USER_GROUP = "dc";

	public static final SiteConfig[] SAMPLE_SITE_CONFIGURATION =
		new SiteConfig[] {
			new SiteConfig("/gs")
		};

	public static final LayoutConfig[] SAMPLE_LAYOUT_CONFIGURATION = {
		new LayoutConfig(
			"/home",
			new LayoutConfig[] {
				new LayoutConfig("/welcome", null)
					.setName("Welcome")
					.setTitle("Welcome")
			})
			.setName("Home")
			.setTitle("Home"),

		new LayoutConfig(
			"/resources",
			new LayoutConfig[] {
				new LayoutConfig("/info", null)
					.setName("Info")
					.setTitle("Info"),
				new LayoutConfig("/documents", null)
					.setName("Documents")
					.setTitle("Documents")
			})
			.setName("Resources")
			.setTitle("resources"),

		new LayoutConfig("/help", null)
			.setName("Help")
			.setTitle("Help")
			.setLayoutType(LayoutConstants.TYPE_URL)
	};

	public static final RoleConfig[] SAMPLE_ROLE_CONFIGURATION =
		new RoleConfig[] {
			new RoleConfig("Superman"),
			new RoleConfig("Batman"),
			new RoleConfig("Wonder Woman"),
			new RoleConfig("Green Lantern"),
			new RoleConfig("The Flash"),
			new RoleConfig("Aquaman"),
			new RoleConfig("Cyborg")
		};

	public static final UserGroupConfig[] SAMPLE_USER_GROUP_CONFIGURATION =
		new UserGroupConfig[] {
			new UserGroupConfig(SAMPLE_USER_GROUP)
		};

}
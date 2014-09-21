package ru.ulmc.extender.config;

/**
 * Created by 45 on 24.01.14.
 */
public class BaseModuleConfig {

	public static final String FIELD_ENABLED = "isEnabled";

	protected boolean isEnabled;
	protected String moduleName = "change this value";

	public BaseModuleConfig(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public BaseModuleConfig() {
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public String getModuleName() {
		return moduleName;
	}
}

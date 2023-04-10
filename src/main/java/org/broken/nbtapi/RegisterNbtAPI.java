package org.broken.nbtapi;

import de.tr7zw.changeme.nbtapi.metodes.CompMetadata;
import org.broken.nbtapi.utillity.ServerVersion;
import org.bukkit.plugin.Plugin;

import static de.tr7zw.changeme.nbtapi.utils.MinecraftVersion.getVersion;

public class RegisterNbtAPI {

	private static Plugin PLUGIN;
	private final de.tr7zw.changeme.nbtapi.metodes.CompMetadata compMetadata;

	public RegisterNbtAPI(Plugin plugin, boolean turnOffLogger) {
		PLUGIN = plugin;
		getVersion(turnOffLogger);
		compMetadata = new CompMetadata();
		ServerVersion.setServerVersion(plugin);
	}

	/**
	 * work in progress. Will later fix this so you can save data (is optional
	 * method to tr7zw file saving)
	 */
	public void yamlLoad() {
		// work in progress.
	}

	/**
	 * Get methods to easy set metadata. If you want to set up self you can start
	 * with this classes {@link de.tr7zw.changeme.nbtapi.NBTItem} and
	 * {@link de.tr7zw.changeme.nbtapi.NBTEntity}
	 *
	 * @return CompMetadata class.
	 */
	public CompMetadata getCompMetadata() {
		return compMetadata;
	}

	public static Plugin getPlugin() {
		return PLUGIN;
	}

}

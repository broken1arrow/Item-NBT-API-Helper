package org.broken.nbtapi.utillity;

import org.bukkit.entity.Entity;
import org.bukkit.plugin.Plugin;

public enum ServerVersion {
	v1_19(19.0F),
	v1_18_2(18.2F),
	v1_18_1(18.1F),
	v1_18_0(18.0F),
	v1_17(17),
	v1_16(16),
	v1_15(15),
	v1_14(14),
	v1_13(13),
	v1_12(12),
	v1_11(11),
	v1_10(10),
	v1_9(9),
	v1_8(8),
	v1_7(7),
	v1_6(6),
	v1_5(5),
	v1_4(4),
	v1_3_AND_BELOW(3);

	private final double version;
	private static double currentServerVersion;
	private static String serverName;
	private static boolean hasScoreboardTags = true;

	public double getVersion() {
		return version;
	}

	public static double getCurrentServerVersion() {
		return currentServerVersion;
	}

	public static boolean isHasScoreboardTags() {
		return hasScoreboardTags;
	}

	public static boolean equals(final ServerVersion version) {
		return serverVersion(version) == 0;
	}

	public static boolean atLeast(final ServerVersion version) {
		return equals(version) || newerThan(version);
	}

	public static boolean newerThan(final ServerVersion version) {
		return serverVersion(version) > 0;
	}

	public static boolean olderThan(final ServerVersion version) {
		return serverVersion(version) < 0;
	}

	public static double serverVersion(final ServerVersion version) {
		return currentServerVersion - version.getVersion();
	}

	public static void setServerVersion(final Plugin plugin) {
		final String[] version = plugin.getServer().getBukkitVersion().split("\\.");
		if (version[1].startsWith("18"))
			currentServerVersion = Float.parseFloat(version[1] + "." + version[2].substring(0, version[2].lastIndexOf("-")));
		else
			currentServerVersion = Float.parseFloat(version[1]);

		serverName = plugin.getServer().getName();
		checkClassesExist();
	}

	public static boolean isPaper() {
		return serverName.equals("Paper") || serverName.startsWith("Paper");
	}

	public static void checkClassesExist() {
		try {
			Entity.class.getMethod("getScoreboardTags");
		} catch (Throwable ignore) {
			hasScoreboardTags = false;
		}
	}

	ServerVersion(final float version) {
		this.version = version;

	}

}
package com.astar.rgblighting.util;

import java.util.UUID;

public class UUIDUtil {

    public static final String BASE_UUID_STRING = "00001101-0000-1000-8000";

    public static UUID getUUIDFromMacAddress(String macAddress) {
        return UUID.fromString(BASE_UUID_STRING + "-" + macAddress.replace(":", ""));
    }

}

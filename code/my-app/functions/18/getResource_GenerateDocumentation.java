public static String getResource(String key) {
    final String[] options = { null, null, "icon", "flavor", "tileitem" };
    String ourKey = key;
    final String[] splitKey = key.split("\\.");
    String found = resources.get(ourKey);
    if (found == null && splitKey.length > 2 && splitKey[0].equals("model")) {
        String suffix = (splitKey[1].equals("tile")) ? ".center.r0" : "";
        options[0] = splitKey[1];
        options[1] = splitKey[1] + "icon";
        for (String x : options) {
            ourKey = "image." + x + "." + key + suffix;
            found = resources.get(ourKey);
            if (found != null)
                break;
        }
    }
    return found;
}
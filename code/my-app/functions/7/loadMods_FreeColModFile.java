public static void loadMods() {
    if (allMods.isEmpty()) {
        for (FreeColModFile fcmf : FreeColModFile.getModsList()) {
            allMods.put(fcmf.getId(), fcmf);
        }
    }
}
public static void loadTCs() {
    if (allTCs.isEmpty()) {
        for (FreeColTcFile fctf : FreeColTcFile.getRulesList()) {
            allTCs.put(fctf.getId(), fctf);
        }
    }
}
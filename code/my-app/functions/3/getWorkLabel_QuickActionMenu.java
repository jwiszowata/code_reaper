private static String getWorkLabel(WorkLocation wl) {
    return "WORK_" + lastPart(wl.getClass().toString(), ".").toUpperCase(Locale.US);
}
private synchronized void loadResources() {
    if (cAlarm != null)
        return;
    cAlarm = (ResourceManager.hasColorResource(cAlarmKey)) ? ResourceManager.getColor(cAlarmKey) : Color.RED;
    cWarn = (ResourceManager.hasColorResource(cWarnKey)) ? ResourceManager.getColor(cWarnKey) : Color.MAGENTA;
    cPlain = (ResourceManager.hasColorResource(cPlainKey)) ? ResourceManager.getColor(cPlainKey) : Color.DARK_GRAY;
    cExport = (ResourceManager.hasColorResource(cExportKey)) ? ResourceManager.getColor(cExportKey) : Color.GREEN;
    cGood = (ResourceManager.hasColorResource(cGoodKey)) ? ResourceManager.getColor(cGoodKey) : Color.BLUE;
}
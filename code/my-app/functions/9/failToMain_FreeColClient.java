private FreeColServer failToMain(Exception ex, StringTemplate template) {
    GUI.ErrorJob ej = gui.errorJob(ex, template);
    logger.log(Level.WARNING, Messages.message(template), ex);
    if (isHeadless() || FreeColDebugger.getDebugRunTurns() >= 0) {
        FreeCol.fatal(ej.toString());
    }
    ej.setRunnable(invokeMainPanel(null)).invokeLater();
    return null;
}
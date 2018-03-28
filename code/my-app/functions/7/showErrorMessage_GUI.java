public final void showErrorMessage(StringTemplate template, String message, Runnable callback) {
    String display = Messages.message(template);
    if (message != null && FreeColDebugger.isInDebugMode()) {
        display += "/" + message + "/";
    }
    showErrorMessage(display, callback);
}
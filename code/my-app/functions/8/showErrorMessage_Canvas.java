public void showErrorMessage(String message, Runnable callback) {
    if (message != null) {
        ErrorPanel errorPanel = new ErrorPanel(freeColClient, message);
        if (callback != null)
            errorPanel.addClosingCallback(callback);
        showSubPanel(errorPanel, true);
    }
}
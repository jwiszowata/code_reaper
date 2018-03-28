public void requestLaunch() {
    if (getGame().allPlayersReadyToLaunch()) {
        getGUI().showStatusPanel(Messages.message("status.startingGame"));
        askServer().requestLaunch();
    } else {
        getGUI().showErrorMessage(StringTemplate.template("server.notAllReady"));
    }
}
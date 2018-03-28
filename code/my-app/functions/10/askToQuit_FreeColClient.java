public void askToQuit() {
    if (gui.confirm("quitDialog.areYouSure.text", "ok", "cancel")) {
        Player player = getMyPlayer();
        if (player == null) {
            quit();
        } else {
            getConnectController().requestLogout(LogoutReason.QUIT);
        }
    }
}
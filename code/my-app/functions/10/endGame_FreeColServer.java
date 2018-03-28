public void endGame() {
    changeServerState(ServerState.END_GAME);
    ChangeSet cs = new ChangeSet();
    for (Player p : getGame().getLiveEuropeanPlayerList()) {
        ServerPlayer sp = (ServerPlayer) p;
        if (sp.isAdmin())
            continue;
        sp.send(new ChangeSet().add(See.only(sp), new LogoutMessage(sp, LogoutReason.QUIT)));
    }
}
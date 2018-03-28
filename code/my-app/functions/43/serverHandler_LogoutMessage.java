public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    if (serverPlayer == null)
        return null;
    logger.info("Handling logout by " + serverPlayer.getName());
    LogoutReason reason = getReason();
    ChangeSet cs = null;
    switch(freeColServer.getServerState()) {
        case PRE_GAME:
        case LOAD_GAME:
            break;
        case IN_GAME:
            boolean endTurn = false;
            switch(reason) {
                case DEFEATED:
                    endTurn = true;
                    break;
                case LOGIN:
                    break;
                case MAIN_TITLE:
                case NEW_GAME:
                case QUIT:
                    if (freeColServer.getSinglePlayer() || serverPlayer.isAdmin()) {
                        freeColServer.endGame();
                    } else {
                        endTurn = true;
                    }
                    break;
                case RECONNECT:
                    break;
            }
            if (endTurn && freeColServer.getGame().getCurrentPlayer() == serverPlayer) {
                cs = freeColServer.getInGameController().endTurn(serverPlayer);
            }
            break;
        case END_GAME:
            return null;
    }
    if (cs == null)
        cs = new ChangeSet();
    cs.add(See.only(serverPlayer), new LogoutMessage(serverPlayer, reason));
    freeColServer.updateMetaServer();
    return cs;
}
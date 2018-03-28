public ChangeSet serverHandler(FreeColServer freeColServer, ServerPlayer serverPlayer) {
    switch(this.type) {
        case CONTINUE_TAG:
            return igc(freeColServer).continuePlaying(serverPlayer);
        case DISCONNECT_TAG:
            if (serverPlayer != null) {
                freeColServer.removePlayerConnection(serverPlayer);
            }
            return null;
        case END_TURN_TAG:
            return igc(freeColServer).endTurn(serverPlayer);
        case ENTER_REVENGE_MODE_TAG:
            return igc(freeColServer).enterRevengeMode(serverPlayer);
        case REQUEST_LAUNCH_TAG:
            return pgc(freeColServer).requestLaunch(serverPlayer);
        case RETIRE_TAG:
            return igc(freeColServer).retire(serverPlayer);
        case CLOSE_MENUS_TAG:
        case RECONNECT_TAG:
        case START_GAME_TAG:
        default:
            return super.serverHandler(freeColServer, serverPlayer);
    }
}
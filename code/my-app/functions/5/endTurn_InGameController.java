public boolean endTurn(boolean showDialog) {
    if (!requireOurTurn())
        return false;
    return doEndTurn(showDialog && getClientOptions().getBoolean(ClientOptions.SHOW_END_TURN_DIALOG));
}
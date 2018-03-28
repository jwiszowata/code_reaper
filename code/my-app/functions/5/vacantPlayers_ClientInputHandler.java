private void vacantPlayers(VacantPlayersMessage message) {
    final FreeColClient fcc = getFreeColClient();
    final List<String> vacant = message.getVacantPlayers();
    fcc.setVacantPlayerNames(vacant);
}
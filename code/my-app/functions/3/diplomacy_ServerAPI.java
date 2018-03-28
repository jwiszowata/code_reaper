public boolean diplomacy(FreeColGameObject our, FreeColGameObject other, DiplomaticTrade dt) {
    return ask(our.getGame(), new DiplomacyMessage(our, other, dt));
}
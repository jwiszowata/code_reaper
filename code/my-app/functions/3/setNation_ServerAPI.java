public boolean setNation(Nation nation) {
    return ask(null, new SetNationMessage(null, nation));
}
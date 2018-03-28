public boolean setAvailable(Nation nation, NationState state) {
    return ask(null, new SetAvailableMessage(nation, state));
}
public boolean worthScouting(Player player) {
    ContactLevel cl = getContactLevel(player);
    switch(cl) {
        case CONTACTED:
            return true;
        case VISITED:
            return !getSpecification().getBoolean(GameOptions.SETTLEMENT_ACTIONS_CONTACT_CHIEF);
        case UNCONTACTED:
        case SCOUTED:
        default:
            break;
    }
    return false;
}
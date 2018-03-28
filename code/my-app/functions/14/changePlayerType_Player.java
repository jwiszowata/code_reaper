public void changePlayerType(PlayerType type) {
    if (playerType != PlayerType.REBEL && playerType != PlayerType.INDEPENDENT) {
        switch(type) {
            case REBEL:
            case INDEPENDENT:
                addAbility(new Ability(Ability.INDEPENDENCE_DECLARED, true));
                addAbility(new Ability(Ability.INDEPENDENT_NATION, true));
                break;
            default:
                break;
        }
    }
    setPlayerType(type);
}
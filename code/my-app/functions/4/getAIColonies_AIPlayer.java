public List<AIColony> getAIColonies() {
    final AIMain aiMain = getAIMain();
    return transform(getPlayer().getColonies(), alwaysTrue(), c -> aiMain.getAIColony(c), toListNoNulls());
}
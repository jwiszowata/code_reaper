public boolean acceptMercenaries() {
    return getPlayer().isAtWar() || "conquest".equals(getAIAdvantage());
}
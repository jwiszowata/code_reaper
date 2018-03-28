public <T extends StringTemplate> T addAmount(String key, Number amount) {
    return addName(key, amount.toString());
}
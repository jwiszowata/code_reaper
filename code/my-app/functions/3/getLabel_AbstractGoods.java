public static StringTemplate getLabel(String key, int amount) {
    return StringTemplate.template("model.abstractGoods.label").add("%goods%", key).addAmount("%amount%", amount);
}
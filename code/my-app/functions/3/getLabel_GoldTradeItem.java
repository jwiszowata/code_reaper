public StringTemplate getLabel() {
    return StringTemplate.template(Messages.descriptionKey("model.tradeItem.gold")).addAmount("%amount%", gold);
}
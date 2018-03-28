public StringTemplate getLabel() {
    return StringTemplate.template(Messages.descriptionKey("model.tradeItem.colony")).addName("%colony%", colonyName);
}
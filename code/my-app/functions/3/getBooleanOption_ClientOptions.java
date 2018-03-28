public BooleanOption getBooleanOption(ModelMessage message) {
    return (BooleanOption) getOption(message.getMessageType().getOptionName());
}
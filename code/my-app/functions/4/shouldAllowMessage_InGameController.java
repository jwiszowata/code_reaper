private boolean shouldAllowMessage(ModelMessage message) {
    BooleanOption option = getClientOptions().getBooleanOption(message);
    return (option == null) ? true : option.getValue();
}
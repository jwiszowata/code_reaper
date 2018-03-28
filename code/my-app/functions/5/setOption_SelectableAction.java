public final void setOption(boolean value) {
    ClientOptions co = freeColClient.getClientOptions();
    if (co != null && optionId != null)
        co.setBoolean(optionId, value);
}
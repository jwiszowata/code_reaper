public void refilterModelMessages(OptionGroup options) {
    synchronized (this.modelMessages) {
        removeInPlace(this.modelMessages, m -> !options.getBoolean(m.getMessageType().getOptionName()));
    }
}
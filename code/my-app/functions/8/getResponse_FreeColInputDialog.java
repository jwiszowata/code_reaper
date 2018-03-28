public T getResponse() {
    if (responded()) {
        Object value = getValue();
        if (value == this.options.get(0))
            return getInputValue();
    }
    return null;
}
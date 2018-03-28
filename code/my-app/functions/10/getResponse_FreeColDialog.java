public T getResponse() {
    if (responded()) {
        Object value = getValue();
        for (ChoiceItem<T> ci : this.options) {
            if (ci.equals(value))
                return ci.getObject();
        }
    }
    return null;
}
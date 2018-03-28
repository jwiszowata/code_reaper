public void reset() {
    model.clear();
    for (AbstractOption<T> o : getOption().getValue()) {
        model.addElement(o);
    }
}
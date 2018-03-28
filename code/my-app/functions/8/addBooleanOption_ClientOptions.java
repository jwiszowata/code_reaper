private void addBooleanOption(String id, String gr, boolean val) {
    if (getOption(id) == null) {
        BooleanOption op = new BooleanOption(id, null);
        op.setGroup(gr);
        op.setValue(val);
        add(op);
    }
}
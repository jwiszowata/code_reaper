public static ChangeSet simpleChange(See see, DOMMessage message) {
    ChangeSet cs = new ChangeSet();
    cs.add((see == null) ? See.all() : see, message);
    return cs;
}
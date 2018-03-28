private List<Cargo> wrapCargoes() {
    List<Cargo> ts = tCopy();
    for (int i = 0; i < ts.size() - 1; i++) {
        Cargo head = ts.get(i);
        while (i + 1 < ts.size() && head.couldWrap(ts.get(i + 1))) {
            head.wrap(ts.remove(i + 1));
        }
    }
    return ts;
}
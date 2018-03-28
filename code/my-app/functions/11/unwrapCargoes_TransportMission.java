private List<Cargo> unwrapCargoes(List<Cargo> ts) {
    for (int i = 0; i < ts.size(); i++) {
        Cargo t = ts.get(i);
        if (t.hasWrapped()) {
            List<Cargo> tl = t.unwrap();
            ts.addAll(i + 1, tl);
            i += tl.size();
        }
    }
    return ts;
}
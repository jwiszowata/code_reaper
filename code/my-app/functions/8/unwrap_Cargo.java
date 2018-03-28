public List<Cargo> unwrap() {
    if (wrapped == null) {
        throw new IllegalStateException("Bogus unwrap " + this);
    }
    List<Cargo> result = wrapped;
    wrapped = null;
    return result;
}
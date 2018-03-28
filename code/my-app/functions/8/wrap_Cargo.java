public void wrap(Cargo other) {
    if (other == this) {
        throw new IllegalStateException("Autowrap at" + this);
    }
    if (wrapped == null)
        wrapped = new ArrayList<>();
    wrapped.add(other);
}
private void badTransition(Stance newStance) {
    throw new IllegalStateException("Bad transition: " + this + " -> " + newStance);
}
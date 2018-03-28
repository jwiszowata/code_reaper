public Iterator<AnimationEvent> iterator() {
    return Collections.unmodifiableList(this.events).iterator();
}
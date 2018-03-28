public boolean isValid() {
    return this.victim != null && this.victim != getSource() && this.victim != getDestination();
}
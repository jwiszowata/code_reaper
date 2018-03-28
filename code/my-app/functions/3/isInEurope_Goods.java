public boolean isInEurope() {
    return (this.location instanceof Europe) || (this.location instanceof Unit && ((Unit) this.location).isInEurope());
}
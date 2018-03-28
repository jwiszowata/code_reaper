public void dispose() {
    if (this.wish != null) {
        this.wish.setTransportable(null);
        this.wish = null;
    }
    super.dispose();
}
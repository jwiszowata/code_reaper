public Stream<FreeColGameObject> getDisposables() {
    Stream<FreeColGameObject> up = super.getDisposables();
    return (this.goodsContainer == null) ? up : concat(this.goodsContainer.getDisposables(), up);
}
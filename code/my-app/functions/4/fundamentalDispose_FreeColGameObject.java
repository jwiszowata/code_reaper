public final void fundamentalDispose() {
    getGame().removeFreeColGameObject(getId(), "dispose");
    this.disposed = true;
}
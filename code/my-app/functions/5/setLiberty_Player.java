public void setLiberty(int liberty) {
    if (!canHaveFoundingFathers())
        return;
    this.liberty = liberty;
}
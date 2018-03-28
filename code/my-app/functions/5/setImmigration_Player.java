public void setImmigration(int immigration) {
    if (!isColonial())
        return;
    this.immigration = immigration;
}
public boolean merge(FreeColSavegameFile save) {
    ClientOptions clop = new ClientOptions();
    return (!clop.load(save)) ? false : this.merge(clop);
}
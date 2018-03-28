public LoadingSavegameInfo getInfo() {
    return new LoadingSavegameInfo(isSinglePlayer(), getPort(), getServerName());
}
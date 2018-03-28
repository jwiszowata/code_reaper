public void setNation(Nation nation) {
    getMyPlayer().setNation(nation);
    askServer().setNation(nation);
}
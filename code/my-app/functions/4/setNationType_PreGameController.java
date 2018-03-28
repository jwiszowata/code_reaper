public void setNationType(NationType nationType) {
    getMyPlayer().changeNationType(nationType);
    askServer().setNationType(nationType);
}
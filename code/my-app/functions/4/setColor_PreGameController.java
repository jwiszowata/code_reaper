public void setColor(Nation nation, Color color) {
    nation.setColor(color);
    askServer().setColor(nation, color);
}
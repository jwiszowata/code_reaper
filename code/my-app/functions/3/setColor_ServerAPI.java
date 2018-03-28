public boolean setColor(Nation nation, Color color) {
    return ask(null, new SetColorMessage(nation, color));
}
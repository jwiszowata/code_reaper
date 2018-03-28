public void setAvailable(Nation nation, NationState state) {
    getGame().getNationOptions().getNations().put(nation, state);
    askServer().setAvailable(nation, state);
}
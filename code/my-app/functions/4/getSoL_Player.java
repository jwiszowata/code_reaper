public int getSoL() {
    final List<Colony> colonies = getColonyList();
    return (colonies.isEmpty()) ? 0 : sum(colonies, Colony::getSoL) / colonies.size();
}
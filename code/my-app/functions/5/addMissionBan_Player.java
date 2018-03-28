public void addMissionBan(Player player) {
    if (bannedMissions == null)
        bannedMissions = new HashSet<>();
    bannedMissions.add(player);
}
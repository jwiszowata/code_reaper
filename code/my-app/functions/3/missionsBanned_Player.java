public boolean missionsBanned(Player player) {
    return bannedMissions != null && bannedMissions.contains(player);
}
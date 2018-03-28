public boolean canBuild(BuildableType buildableType) {
    return getNoBuildReason(buildableType, null) == NoBuildReason.NONE;
}
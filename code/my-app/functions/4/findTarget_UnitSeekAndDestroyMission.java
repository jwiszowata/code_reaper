public static Location findTarget(AIUnit aiUnit, int range, boolean deferOK) {
    PathNode path = findTargetPath(aiUnit, range, deferOK);
    return (path != null) ? extractTarget(aiUnit, path) : null;
}
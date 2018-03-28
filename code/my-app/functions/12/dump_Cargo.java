public String dump() {
    if (!isCarried())
        return "not-carried";
    PathNode path = carrier.getTrivialPath();
    if (path == null)
        return "no-trivial-path";
    String reason = initialize(path.getLastNode().getLocation(), false);
    if (reason != null)
        return reason;
    this.plan.mode = CargoMode.DUMP;
    return null;
}
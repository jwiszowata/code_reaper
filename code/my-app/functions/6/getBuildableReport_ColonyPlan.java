public String getBuildableReport() {
    LogBuilder lb = new LogBuilder(64);
    lb.add("Buildables:\n");
    for (BuildPlan b : buildPlans) lb.add(b, "\n");
    return lb.toString();
}
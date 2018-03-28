public void consumeWorkerWish(AIUnit aiUnit, WorkerWish ww) {
    final Unit unit = aiUnit.getUnit();
    List<WorkerWish> wwL = workerWishes.get(unit.getType());
    wwL.remove(ww);
    List<Wish> wl = transportDemand.get(ww.getDestination());
    if (wl != null)
        wl.remove(ww);
    ww.setTransportable(aiUnit);
}
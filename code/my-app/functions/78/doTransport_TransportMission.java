private void doTransport(LogBuilder lb) {
    final Unit unit = getUnit();
    if (tSize() > 0) {
        lbAt(lb);
        lb.add(", delivering");
        List<Cargo> cont = new ArrayList<>();
        List<Cargo> next = new ArrayList<>();
        List<Cargo> curr = tClear();
        for (Cargo cargo : curr) {
            CargoResult result = (cargo.getMode().isCollection()) ? CargoResult.TCONTINUE : tryCargo(cargo, lb);
            switch(result) {
                case TCONTINUE:
                    cont.add(cargo);
                    break;
                case TRETRY:
                    if (cargo.retry()) {
                        cont.add(cargo);
                        break;
                    }
                case TFAIL:
                    if (cargo.isCarried()) {
                        cargo.dump();
                        break;
                    }
                case TDONE:
                    dropTransportable(cargo.getTransportable());
                    cargo.clear();
                    break;
                case TNEXT:
                default:
                    throw new IllegalStateException("Can not happen");
            }
        }
        curr.clear();
        tSet(cont, true);
        lb.add(", collecting");
        cont.clear();
        for (Cargo cargo : tClear()) {
            CargoResult result = (cargo.getMode().isCollection()) ? tryCargo(cargo, lb) : CargoResult.TCONTINUE;
            switch(result) {
                case TCONTINUE:
                    cont.add(cargo);
                    break;
                case TNEXT:
                    cont.add(cargo);
                    break;
                case TRETRY:
                    if (cargo.retry()) {
                        next.add(cargo);
                        break;
                    }
                case TFAIL:
                case TDONE:
                    dropTransportable(cargo.getTransportable());
                    cargo.clear();
                    break;
                default:
                    throw new IllegalStateException("Can not happen");
            }
        }
        tSet(cont, true);
        if (!next.isEmpty()) {
            lb.add(", requeue");
            for (Cargo c : next) queueCargo(c, false, lb);
        }
        checkCargoes(lb);
        optimizeCargoes(lb);
    }
    final EuropeanAIPlayer euaip = getEuropeanAIPlayer();
    while (destinationCapacity() > 0 && tSize() < unit.getCargoCapacity() * 3 / 2) {
        Cargo cargo = getBestCargo(unit);
        if (cargo == null)
            break;
        if (!queueCargo(cargo, false, lb))
            break;
        euaip.claimTransportable(cargo.getTransportable());
    }
}
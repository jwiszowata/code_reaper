public Location getTransportTarget() {
    return (getMode().isCollection()) ? plan.twait : plan.tdst;
}
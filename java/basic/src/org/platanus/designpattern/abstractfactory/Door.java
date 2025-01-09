package org.platanus.designpattern.abstractfactory;

public abstract class Door {

    private DoorStatus doorStatus;

    public Door() {
        doorStatus = DoorStatus.CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;

    }

    public void close() {
        if (doorStatus == DoorStatus.CLOSED) {
            return;
        }
        doClose();
        doorStatus = DoorStatus.CLOSED;
    }

    protected abstract void doClose();

    public void open() {
        if (doorStatus == DoorStatus.OPENED) {
            return;
        }
        doOpen();
        doorStatus = DoorStatus.OPENED;
    }

    protected abstract void doOpen();
}

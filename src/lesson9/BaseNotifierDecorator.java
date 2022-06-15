package lesson9;

public abstract class BaseNotifierDecorator implements Notifier{
    private Notifier wrapee;

    public BaseNotifierDecorator(Notifier wrapee) {
        this.wrapee = wrapee;
    }

    @Override
    public void sendNotify() {
        wrapee.sendNotify();
    }
}

package lesson9;

public class SmsNotifier extends BaseNotifierDecorator {
    public SmsNotifier(Notifier wrapee) {
        super(wrapee);
    }

    @Override
    public void sendNotify() {
        System.out.println("SMS: оповещение");
        super.sendNotify();
    }
}

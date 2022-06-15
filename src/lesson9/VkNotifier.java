package lesson9;

public class VkNotifier extends BaseNotifierDecorator {
    public VkNotifier(Notifier wrapee) {
        super(wrapee);
    }

    @Override
    public void sendNotify() {
        System.out.println("VK: оповещение");
        super.sendNotify();
    }
}

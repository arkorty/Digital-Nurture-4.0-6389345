
public class Main {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();

        Notifier allChannelsNotifier = new SlackNotifierDecorator(new SMSNotifierDecorator(notifier));
        allChannelsNotifier.send("Your package has been delivered.");

        System.out.println("\n--- Email and SMS only ---");
        Notifier emailAndSmsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSmsNotifier.send("Your monthly statement is ready.");
    }
} 

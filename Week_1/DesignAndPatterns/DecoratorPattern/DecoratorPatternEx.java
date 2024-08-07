/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.decoratorpatternex;

/**
 *
 * @author Ashwithaa
 */
public class DecoratorPatternEx {

    public static void main(String[] args) {
// Create a base notifier
        Notifier notifier = new EmailNotifier();

        // Decorate the notifier with SMS and Slack capabilities
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackNotifier = new StackNotifierDecorator(smsNotifier);

        // Send a notification via Email, SMS, and Slack
        slackNotifier.send("This is a test notification.");
    }
}

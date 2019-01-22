package studio.spiderling.iexbot;

import org.crabcraft.Commandler.CommandRegistry;
import org.crabcraft.Commandler.FrameworkConfig;
import org.javacord.api.DiscordApiBuilder;
import studio.spiderling.iexbot.core.commands.TestCommand;

public class IEXBot {

    public static void main(String[] args) {

        new DiscordApiBuilder().setToken(FrameworkConfig.getToken()).login().thenAccept(api -> {

            // Grab a bot invite
            System.out.println("Bot invite: " + api.createBotInvite());

            // Initialise the Commandler registry
            CommandRegistry registry = new CommandRegistry(api);

            registry.registerCommand(new TestCommand());
        });
    }
}

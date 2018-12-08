package org.crabcraft.iexbot;

import org.crabcraft.Commandler.CommandRegistry;
import org.crabcraft.Commandler.FrameworkConfig;
import org.javacord.api.DiscordApiBuilder;

public class IEXBot {

    public static void main(String[] args) {

        new DiscordApiBuilder().setToken(FrameworkConfig.getToken()).login().thenAccept(api -> {
            // Create a bot invite link
            api.createBotInvite();

            CommandRegistry registry = new CommandRegistry(api);

        });

    }
}

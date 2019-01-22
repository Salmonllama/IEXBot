package studio.spiderling.iexbot.core.commands;

import java.util.Arrays;
import java.util.List;

import org.crabcraft.Commandler.Command;
import org.javacord.api.event.message.MessageCreateEvent;
import pl.zankowski.iextrading4j.api.stocks.Quote;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.stocks.QuoteRequestBuilder;

public class TestCommand extends Command {
    @Override
    public String Name() { return "Test Command"; }
    @Override
    public List<String> Aliases() { return Arrays.asList("test", "t"); }
    @Override
    public String Description() { return "A command for testing purposes"; }
    @Override
    public String Usage() { return "test <arguments>"; }
    @Override
    public String Permission() { return "none"; }
    @Override
    public String Category() { return "Other"; }

    @Override
    public void onCommand(MessageCreateEvent event, String[] args) {
        System.out.println("called");
        final IEXTradingClient iexClient = IEXTradingClient.create();

        final Quote quote = iexClient.executeRequest(new QuoteRequestBuilder()
            .withSymbol("AAPL")
            .build()
        );

        sendResponse(event, quote.toString());
    }
}
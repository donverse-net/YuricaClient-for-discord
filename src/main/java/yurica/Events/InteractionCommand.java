package yurica.Events;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import yurica.Events.InteractionCommands.PingCommand;

public class InteractionCommand extends ListenerAdapter {
    JDA jda;

    public InteractionCommand(JDA api){
        this.jda = api;
    }

    private PingCommand ping = new PingCommand();

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String command = event.getName();

        switch (command) {
            case "ping":
                ping.response(event, jda);
                break;
            default:
                break;
        }
    }

    // Command register.
    public void registerCommand(){
        jda.upsertCommand("ping", "Ping command.")
            .addOption(OptionType.STRING, "message", "Message to send.", true)
            .addOption(OptionType.INTEGER, "amount", "Amount of message to send.", false)
            .addOption(OptionType.BOOLEAN, "boolean", "Boolean value.", false)
            .addOption(OptionType.USER, "user", "User to mention.", false)
            .addOption(OptionType.CHANNEL, "channel", "Channel to send message.", false)
            .addOption(OptionType.ROLE, "role", "Role to mention.", false)
            .addOption(OptionType.MENTIONABLE, "mentionable", "Mentionable value.", false)
            .addOption(OptionType.NUMBER, "number", "Number value.", false)
            .addOptions(
                new OptionData(OptionType.STRING, "string-selection", "String selection.")
                    .addChoice("Choice 1", "choice1")
                    .addChoice("Choice 2", "choice2")
                    .addChoice("Choice 3", "choice3")
            )
            .queue();
    }
}

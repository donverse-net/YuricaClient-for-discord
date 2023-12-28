package Yurica.Events.Interaction;

import Yurica.Commands.Default.Ping;
import Yurica.Commands.Moderation.ModAction;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class SlashCommands {

    // Default commands
    Ping ping = new Ping();

    // Moderation commands
    ModAction modAction = new ModAction();

    public void Execute(SlashCommandInteractionEvent event) {
        // Slash command big switch
        switch (event.getName()) {
            // Default commands
            case "ping":
                ping.Execute(event);
                break;

            // Moderation commands
            case "mod-action":
                modAction.Execute(event);
                break;

            default:
                try {
                    event.reply("Unknown command.").setEphemeral(true).queue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}

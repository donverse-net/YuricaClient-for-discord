package Yurica.Commands.Default;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Ping {

    /**
     * Slash command: Ping
     * @param event
     */
    public void Execute(SlashCommandInteractionEvent event) {
        try {
            event.reply("Pong! " + event.getJDA().getGatewayPing() + "ms").setEphemeral(true).queue();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

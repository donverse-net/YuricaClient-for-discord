package Yurica.Commands.Default;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class Help {
    /**
     * Slash command: Help
     * @param event
     */
    public void Execute(SlashCommandInteractionEvent event) {
        try {
            event.reply("Show help.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

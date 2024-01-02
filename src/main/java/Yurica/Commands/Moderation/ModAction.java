package Yurica.Commands.Moderation;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

public class ModAction {

    User user;
    EmbedBuilder embedBuilder = new EmbedBuilder();

    /**
     * Slash command: ModAction
     * @param event
     */
    public void Execute(SlashCommandInteractionEvent event) {
        try {

            // Get user from slash command
            user = event.getOption("target").getAsUser();

            // Set embed
            embedBuilder.setTitle("Moderation Action");
            embedBuilder.setDescription("Target: " + user.getAsMention());

            // Send embed
            event.replyEmbeds(embedBuilder.build())
                    .addActionRow(
                        // Action buttons
                        Button.secondary("mod-kick", "Kick")
                            .withEmoji(Emoji.fromUnicode("⛔"))
                            .withDisabled(false),
                        Button.secondary("mod-to", "Timeout")
                            .withEmoji(Emoji.fromUnicode("⏱️"))
                            .withDisabled(false),
                        Button.secondary("mod-ban", "Ban")
                            .withEmoji(Emoji.fromUnicode("🔨"))
                            .withDisabled(false)
                    )
                    .addActionRow(
                        // Cancel button
                        Button.danger("mod-cancel", "Cancel")
                            .withEmoji(Emoji.fromUnicode("❌"))
                            .withDisabled(false)
                    )
                    .setEphemeral(true)
                    .queue();

        } catch (Exception e) {
            e.printStackTrace();
            event.reply("An error occured while executing this command.").setEphemeral(true).queue();
        }
    }
}

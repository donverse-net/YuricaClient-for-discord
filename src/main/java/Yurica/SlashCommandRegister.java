package Yurica;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.Command.Type;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;

/**
 * Upsert slash commands
 */
public class SlashCommandRegister {
    JDA client;

    public SlashCommandRegister(JDA client) {
        this.client = client;
    }

    public void register() {
        try {
            // Default(global) commands
            client.upsertCommand("ping", "Show websocket ping ms.")
                    .setGuildOnly(false)
                    .queue();
            client.upsertCommand("help", "Show help modern interface.")
                    .setGuildOnly(false)
                    .queue();

            // Guild commands: Utility
            client.upsertCommand("server-info", "Show server information.")
                    .setGuildOnly(true)
                    .queue();

            // Guild commands: Moderation
            client.upsertCommand("report", "Report a user in this guild.")
                    .setGuildOnly(true)
                    .addOption(OptionType.USER, "target", "⚠️ Take care for selecting target user.", true)
                    .addOption(OptionType.STRING, "reason", "Reason for report.", true)
                    .addOption(OptionType.ATTACHMENT, "evidence", "If you have evidence, please attach it.", false)
                    .queue();
            client.upsertCommand("moderation", "Moderation actions.")
                    .setGuildOnly(true)
                    .addOptions(
                        new OptionData(OptionType.USER, "target", "⚠️ Take care for selecting target user.", true)
                    )
                    .queue();

            // Guild context menu commands
            client.updateCommands().addCommands(
                    // Context menu command: User
                    Commands.context(Type.USER, "user-info").setGuildOnly(true),
                    Commands.context(Type.USER, "report").setGuildOnly(true),

                    // Context menu command: Message
                    Commands.context(Type.MESSAGE, "delete").setGuildOnly(true),
                    Commands.context(Type.MESSAGE, "report").setGuildOnly(true)
            ).queue();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

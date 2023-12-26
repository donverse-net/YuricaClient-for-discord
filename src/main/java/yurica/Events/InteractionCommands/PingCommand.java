package yurica.Events.InteractionCommands;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import yurica.Main;
import yurica.Interfaces.ISlashCommand;

public class PingCommand extends ListenerAdapter implements ISlashCommand {

    @Override
    public void response(SlashCommandInteractionEvent event){
        // Reply with client ws ping.
        long ping = Main.jda.getGatewayPing();
        event.reply("Pong! " + ping + "ms")
                .setEphemeral(true)
                .addActionRow(
                    Button.primary("test", "Test Button")
                )
                .queue();
    }

    @Override
    public void registerGuild(String guildId) {
        try {
            Guild guild = null;
            if (guildId != null) {
                guild = Main.jda.getGuildById(guildId);
                System.out.println("Registering guild " + guild.getName() + "...");
            }

            guild.updateCommands().addCommands(
                Commands.slash("ping", "Ping command.")
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
            ).queue();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void unregisterGuild(Guild guild) {
        try {
            guild.deleteCommandById("ping").queue();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void register() {
        try {
            Main.jda.upsertCommand("ping", "Ping command.")
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
            ).queue();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }

    @Override
    public void unregister() {
        try {
            Main.jda.deleteCommandById("ping").queue();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

    }
}

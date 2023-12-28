package Yurica.Events;

import Yurica.Events.Interaction.SlashCommands;
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.EntitySelectInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class InteractionEventListener extends ListenerAdapter {

    SlashCommands slashCommands = new SlashCommands();

    //#region Interactions
    /**
     * Interaction event listener for Slash Command
     */
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        slashCommands.Execute(event);
    }

    /**
     * Interaction event listener for User Context Menu
     */
    @Override
    public void onUserContextInteraction(UserContextInteractionEvent event) {
        //
    }

    /**
     * Interaction event listener for Message Context Menu
     */
    @Override
    public void onMessageContextInteraction(MessageContextInteractionEvent event) {
        //
    }

    /**
     * Interaction event listener for Button
     */
    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        //
    }

    /**
     * Interaction event listener for String Selection(Dropdown)
     */
    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        //
    }

    /**
     * Interaction event listener for Entity(Role, User) Selection(Dropdown)
     */
    @Override
    public void onEntitySelectInteraction(EntitySelectInteractionEvent event) {
        //
    }

    //#endregion
}

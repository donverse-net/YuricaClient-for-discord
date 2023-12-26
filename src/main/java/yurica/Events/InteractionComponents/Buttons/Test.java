package yurica.Events.InteractionComponents.Buttons;

import java.util.function.Function;

import org.jetbrains.annotations.Nullable;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle;
import yurica.Interfaces.IButton;

public class Test extends ListenerAdapter implements IButton {
    public Button button = Button.of(ButtonStyle.PRIMARY, "test", "Test Button");

    @Override
    public Button getButton() {
        return button;
    }

    @Override
    public Function<ButtonInteractionEvent, String> getFunction() {
        return this::response;
    }

    @Nullable
    @Override
    public String response(ButtonInteractionEvent event) {
        try {
            event.reply("Test button is clicked!").setEphemeral(true).queue();
            return "Test button is clicked!";
        } catch (Exception e) {
            return "Error!";
        }
    }

    public void disableButton(ButtonInteractionEvent event) {
        button = Button.of(ButtonStyle.PRIMARY, "test", "Test Button").asDisabled();
        event.editButton(button).queue();
    }
}

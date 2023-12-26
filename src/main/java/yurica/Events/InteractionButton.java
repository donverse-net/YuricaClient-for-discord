package yurica.Events;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import yurica.Events.InteractionComponents.Buttons.Test;

public class InteractionButton extends ListenerAdapter {

    public Map<String, Function<ButtonInteractionEvent, String>> buttonMap = new HashMap<>();

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {
        String btnId = event.getComponentId();
        Function<ButtonInteractionEvent, String> func;

        System.out.println("Button clicked: " + btnId);
        System.out.println("Button mapped keys: " + buttonMap.keySet());
        System.out.println("Button mapped values: " + buttonMap.values());

        try {
            // Execute function get
            func = buttonMap.get(btnId);
            System.out.println("Button function: " + func);
        } catch (Exception e) {
            e.printStackTrace();
            event.reply("Error!").setEphemeral(true).queue();
            return;
        }

        if (func != null) {
            String re = func.apply(event);
            System.out.println("Button function response: " + re);
        } else {
            event.reply("Button not found!").setEphemeral(true).queue();
        }
    }

    public void addButton(String id, Function<ButtonInteractionEvent, String> function) {
        buttonMap.put(id, function);
    }

    public void removeButton(String id) {
        buttonMap.remove(id);
    }

    public Map<String, Function<ButtonInteractionEvent, String>> getButtonMap() {
        return buttonMap;
    }

    public void loadButtons() {
        addButton("test", new Test().getFunction());
    }
}

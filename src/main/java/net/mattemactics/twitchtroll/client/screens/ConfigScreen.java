package net.mattemactics.twitchtroll.client.screens;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.mattemactics.twitchtroll.client.util.ModSettings;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.list.OptionsRowList;
import net.minecraft.client.settings.BooleanOption;
import net.minecraft.client.settings.SliderPercentageOption;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public final class ConfigScreen extends Screen {
    /** Distance from top of the screen to this GUI's title */
    private static final int TITLE_HEIGHT = 8; //height of title
    /** Distance from top of the screen to the options row list's top */
    private static final int OPTIONS_LIST_TOP_HEIGHT = 24;
    /** Distance from bottom of the screen to the options row list's bottom */
    private static final int OPTIONS_LIST_BOTTOM_OFFSET = 32;
    /** Height of each item in the options row list */
    private static final int OPTIONS_LIST_ITEM_HEIGHT = 25;

    /** Width of a button */
    private static final int BUTTON_WIDTH = 200;
    /** Height of a button */
    private static final int BUTTON_HEIGHT = 20;
    /** Distance from bottom of the screen to the "Done" button's top */
    private static final int DONE_BUTTON_TOP_OFFSET = 26;
    private static final int MIN_VALUE_COST = 10;
    private static final int MAX_VALUE_COST = 5000;



    /** List of options rows shown on the screen */
    // Not a final field because this cannot be initialized in the constructor,
    // as explained below
    private OptionsRowList optionsRowList;

    public ConfigScreen() {
        // Use the super class' constructor to set the screen's title
        super(new TranslationTextComponent("Twitch Troll"));
    }

    @Override
    protected void init() {
        // Create the options row list
        // It must be created in this method instead of in the constructor,
        // or it will not be displayed properly
        this.optionsRowList = new OptionsRowList(
                this.minecraft, this.width, this.height,
                OPTIONS_LIST_TOP_HEIGHT,
                this.height - OPTIONS_LIST_BOTTOM_OFFSET,
                OPTIONS_LIST_ITEM_HEIGHT
        );

        //cost of commands
        this.optionsRowList.addOption(new SliderPercentageOption(
                "Creeper Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getCreeperCost(),
                (unused, newValue) -> ModSettings.setCreeperCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Creeper Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Zombie Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getZombieCost(),
                (unused, newValue) -> ModSettings.setZombieCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Zombie Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Anvil Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getAnvilCost(),
                (unused, newValue) -> ModSettings.setAnvilCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Anvil Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Ghast Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getGhastCost(),
                (unused, newValue) -> ModSettings.setGhastCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Ghast Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Fire Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getFireCost(),
                (unused, newValue) -> ModSettings.setFireCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Fire Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Goodboy Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getGoodboyCost(),
                (unused, newValue) -> ModSettings.setGoodboyCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Goodboy Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Dropitall Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getDropitallCost(),
                (unused, newValue) -> ModSettings.setDropitallCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Dropitall Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Dropit Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getDropitCost(),
                (unused, newValue) -> ModSettings.setDropitCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Dropit Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Boom Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getBoomCost(),
                (unused, newValue) -> ModSettings.setBoomCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Boom Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Enderman Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getEndermanCost(),
                (unused, newValue) -> ModSettings.setEndermanCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Enderman Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Blaze Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getBlazeCost(),
                (unused, newValue) -> ModSettings.setBlazeCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Blaze Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Bees Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getBeesCost(),
                (unused, newValue) -> ModSettings.setBeesCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Bees Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Cow Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getCowCost(),
                (unused, newValue) -> ModSettings.setCowCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Cow Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Piggy Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getPiggyCost(),
                (unused, newValue) -> ModSettings.setPiggyCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Piggy Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Parrot Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getParrotCost(),
                (unused, newValue) -> ModSettings.setParrotCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Parrot Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Baa Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getBaaCost(),
                (unused, newValue) -> ModSettings.setBaaCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Baa Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));

        this.optionsRowList.addOption(new SliderPercentageOption(
                "Skelly Cost",
                // Range: 0 to width of game window
                MIN_VALUE_COST, MAX_VALUE_COST,
                // This is an integer option, so allow whole steps only
                10.0F,
                // Getter and setter are similar to those in BooleanOption
                unused -> (double) ModSettings.getSkellyCost(),
                (unused, newValue) -> ModSettings.setSkellyCost(newValue.intValue()),
                // BiFunction that returns a string in format "<name>: <value>"
                (gs, option) -> new StringTextComponent(
                        // Use I18n.get(String) to get a translation key's value
                        "Skelly Cost"
                                + ": "
                                + (int) option.get(gs)
                )
        ));


        this.optionsRowList.addOption(new BooleanOption(
                "Test Boolean",
                // GameSettings argument unused for both getter and setter
                unused -> ModSettings.getTest(),
                (unused, newValue) -> ModSettings.setTest(newValue)
        ));

        // Add the options row list as this screen's child
        // If this is not done, users cannot click on items in the list
        this.children.add(this.optionsRowList);

        // Add the "Done" button
        this.addButton(new Button(
                (this.width - BUTTON_WIDTH) / 2,
                this.height - DONE_BUTTON_TOP_OFFSET,
                BUTTON_WIDTH, BUTTON_HEIGHT,
                // Text shown on the button
                new TranslationTextComponent("gui.done"),
                // Action performed when the button is pressed
                button -> {this.closeScreen();}
        ));
    }





    @Override
    public void render(MatrixStack matrixStack,
                       int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        // Options row list must be rendered here,
        // otherwise the GUI will be broken
        this.optionsRowList.render(matrixStack, mouseX, mouseY, partialTicks);
        drawCenteredString(matrixStack, this.font, this.title.getString(),
                this.width / 2, TITLE_HEIGHT, 0xFFFFFF);
        super.render(matrixStack, mouseX, mouseY, partialTicks);
    }
}

package de.fuchspfoten.mokkit.potion;

import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Color;
import org.bukkit.potion.PotionEffectType;

/**
 * @see org.bukkit.potion.PotionEffectType
 */
public final class MokkitPotionEffectType extends PotionEffectType {

    /**
     * Whether or not effects have already been registered.
     */
    private static boolean registeredEffects = false;

    /**
     * Registers all potion effects.
     */
    public static void registerPotionEffects() {
        if (registeredEffects) {
            return;
        }

        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(1, 1.0, "SPEED",
                false, 0x7CAFC6));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(2, 0.5, "SLOW",
                false, 0x5A6C81));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(3, 1.5,
                "FAST_DIGGING", false, 0xD9C043));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(4, 0.5,
                "SLOW_DIGGING", false, 0x4A4217));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(5, 1.0,
                "INCREASE_DAMAGE", false, 0x932423));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(6, 1.0, "HEAL",
                true, 0xF82423));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(7, 0.5, "HARM",
                true, 0x430A09));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(8, 1.0, "JUMP",
                false, 0x22FF4C));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(9, 0.25,
                "CONFUSION", false, 0x551D4A));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(10, 0.25,
                "REGENERATION", false, 0xCD5CAB));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(11, 1.0,
                "DAMAGE_RESISTANCE", false, 0x99453A));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(12, 1.0,
                "FIRE_RESISTANCE", false, 0xE49A3A));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(13, 1.0,
                "WATER_BREATHING", false, 0x2E5299));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(14, 1.0,
                "INVISIBILITY", false, 0x7F8392));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(15, 0.25,
                "BLINDNESS", false, 0x1F1F23));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(16, 1.0,
                "NIGHT_VISION", false, 0x1F1FA1));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(17, 0.5, "HUNGER",
                false, 0x587653));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(18, 0.5,
                "WEAKNESS", false, 0x484D48));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(19, 0.25, "POISON",
                false, 0x4E9331));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(20, 0.25, "WITHER",
                false, 0x352A27));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(21, 1.0,
                "HEALTH_BOOST", false, 0xF87D23));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(22, 1.0,
                "ABSORPTION", false, 0x2552A5));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(23, 1.0,
                "SATURATION", true, 0xF82423));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(24, 1.0, "GLOWING",
                false, 0x94A061));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(25, 0.5,
                "LEVITATION", false, 0xCEFFFF));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(26, 1.0, "LUCK",
                false, 0x339900));
        PotionEffectType.registerPotionEffectType(new MokkitPotionEffectType(27, 0.5, "UNLUCK",
                false, 0xC0A44D));
        PotionEffectType.stopAcceptingRegistrations();

        registeredEffects = true;
    }

    /**
     * The duration modifier.
     */
    private @Getter final double durationModifier;

    /**
     * The name.
     */
    private @Getter final String name;

    /**
     * Whether or not the potion effect type is instant.
     */
    private @Getter final boolean instant;

    /**
     * The color of this effect type.
     */
    private @Getter final Color color;

    /**
     * Constructor.
     *
     * @param durationModifier The duration modifier for the effect type.
     */
    private MokkitPotionEffectType(final int id, final double durationModifier, final @NonNull String name,
                                   final boolean instant, final int color) {
        super(id);
        this.durationModifier = durationModifier;
        this.name = name;
        this.instant = instant;
        this.color = Color.fromRGB(color);
    }
}

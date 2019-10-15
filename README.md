# AndroidTintRemover

Forked from OreoTintRemover.

Gives you a crystal clear lockscreen. Notification shade is also made crystal clear. With tweaks a constant tint color of your choice is also available.

Tested to work on my device, Redmi Note 7 Pro running Lineage 16.0 (Android 9.0)

EdXposed triggers snapchat, so I no longer use this software

This Xposed module will likely work for any other ROM based on AOSP, however I make no guarantees and offer no warranty or support.

## Instructions

1. Install latest Magisk Framework (tested with Magisk 19.3), and Magisk Manager
2. Install "Riru - Core" Magisk module (tested with version 19.5)
3. Optionally reboot here
4. Install "Riru - EdXposed" Magisk module (tested with v0.4.5.1_beta(4463) Sandhook)
5. Install [EdXposed Manager](https://github.com/ElderDrivers/EdXposedManager/releases/tag/v4.5.1), tested to work with version linked
6. Build this module, and install it (release coming soon)
4. Enable the module in Xposed Installer
5. Reboot

## Tweaking

To get exactly the tint you want, edit the hex color codes here

https://github.com/yellowbluesky/AndroidTintRemover/blob/2b65f3679412d3004b0040fe5df99698088bd4f8/app/src/main/java/moe/banana/mods/notint/Monkey.java#L27-L31

First byte is the transparency (0x00 for transparent, 0xff for opaque), remaining three bytes is color of tint in RGB color format.

## License

GPLv2

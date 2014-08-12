Renkin42SWT
===========

This is the source code of a mod for Minecraft Forge which primarily adds a variety of throwable items to the game, among other things. For more details, see one of these pages:

[Minecraft Forums Page][mcf] | [Curse(Download) Page][curse]

This source code is provided primarily as a resource to fellow modders, though I also use the code as a starting point to ask others for help, as I am by no means an experienced modder. Please be aware that for versions prior to 1.7, the file structure of this repository is not accurate. 1.6 and 1.5 did not use a src/main/java and /resources setup. I've simply done this so changes are visible across versions.

How can I Help?
---------------

My biggest need right now is translated .lang files. However, any code improvements are greatly appreciated. Details on how to use this repository can be found below.

The lang files, though, can be done right here in GitHub. Just fork this repository and navigate to "src/main/resources/assets/renkin42swt/lang". Here create a new file called something like aa_BB.lang. You can get the correct name from [here][lang-codes]. Copy the contents of en_US.lang into this file, edit it, and commit. Then simply issue a Pull Request and I'll handle it from there.

Using This Repository
---------------------

1. Create folder for minecraft mods if you don't have one already. We'll call it MODS for now, but it doesn't really matter.
2. Create a folder there called 'Renkin42SWT'
3. Clone this repository to that folder.
4. Open up MODS/Renkin42SWT and shift+right-click. Choose 'Open Shell Here'. It may be different for non-Windows systems.
5. Run 
	gradlew setupDecompWorkspace eclipse
or
	gradlew setupDecompWorkspace idea
depending on which IDE you are using. If you have gradle installed, go ahead and use it instead.
6. Open Eclipse or Idea and set the workspace to the MODS folder. This project should now be visible and ready to use!

[mcf]: http://www.minecraftforum.net/topic/1847376-forge-renkin42s-stuff-worth-throwing-mod/
[curse]: http://www.curse.com/mc-mods/minecraft/stuff-worth-throwing
[lang-codes]: http://minecraft.gamepedia.com/Language

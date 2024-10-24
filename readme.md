<h2>Eroding Stone Entities</h2>
<p><a href="https://github.com/Serilum/Eroding-Stone-Entities"><img src="https://serilum.com/assets/data/logo/eroding-stone-entities.gif"></a></p><h2>Download</h2>
<p>You can download Eroding Stone Entities on CurseForge and Modrinth:</p><p>&nbsp;&nbsp;CurseForge: &nbsp;&nbsp;<a href="https://curseforge.com/minecraft/mc-mods/eroding-stone-entities">https://curseforge.com/minecraft/mc-mods/eroding-stone-entities</a><br>&nbsp;&nbsp;Modrinth: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="https://modrinth.com/mod/eroding-stone-entities">https://modrinth.com/mod/eroding-stone-entities</a></p>
<h2>Issue Tracker</h2>
<p>To keep a better overview of all mods, the issue tracker is located in a separate repository.<br>&nbsp;&nbsp;For issues, ideas, suggestions or anything else, please follow this link:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/issue-tracker">Issue Tracker</a></p>
<h2>Pull Requests</h2>
<p>Because of the way mod loader files are bundled into one jar, some extra information is needed to do a PR.<br>&nbsp;&nbsp;A wiki page entry about it is available here:</p>
<p>&nbsp;&nbsp;&nbsp;&nbsp;-> <a href="https://serilum.com/url/pull-requests">Pull Request Information</a></p>
<h2>Mod Description</h2>
<p style="text-align:center"><a href="https://serilum.com/" target="_blank" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/header/header.png" alt="" width="838" height="400"></a></p>
<p style="text-align:center"><a href="https://curseforge.com/members/serilum/projects" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/curseforge.svg" width="200"></a> <a href="https://modrinth.com/user/Serilum" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/modrinth.svg" width="200"></a> <a href="https://patreon.com/serilum" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/patreon.svg" width="200"></a> <a href="https://youtube.com/@serilum" target="_blank" rel="nofollow"><img src="https://raw.githubusercontent.com/Serilum/.data-workflow/main/badges/svg/youtube.svg" width="200"></a></p>
<p><strong><span style="font-size:24px">Requires the library mod&nbsp;<a style="font-size:24px" href="https://curseforge.com/minecraft/mc-mods/collective" target="_blank" rel="nofollow">Collective</a>.</span></strong><br><br><strong>&nbsp;&nbsp;&nbsp;This mod is part of <span style="color:#008000"><a style="color:#008000" href="https://curseforge.com/minecraft/modpacks/the-vanilla-experience" target="_blank" rel="nofollow">The Vanilla Experience</a></span> modpack and <span style="color:#006b3f"><a style="color:#006b3f" href="https://curseforge.com/minecraft/mc-mods/serilums-rpg-bundle" target="_blank" rel="nofollow">Serilum's RPG Bundle</a></span> mod.</strong><br><span style="font-size:18px">Eroding Stone Entities was created to give players access to a more sustainable way of farming sand and clay. After playing a while you'll have chests upon chests of cobblestone, but that precious sand for your glass castle is nowhere to be found. Now you can drop any type of stone block into a moving water stream and after 150 seconds it will turn into sand, red sand or clay. See the list below for the compatible blocks. You can still have item transport streams without worrying about all the stone eroding, just have ice blocks below the stream. This will prevent the erosion.<br><br>The water source must move for the erosion effect to occur.<br></span><br><br><span style="font-size:24px"><strong>Default erosion properties, can be changed in the config:</strong></span><br><span style="font-size:18px"><em>Blocks that turn into sand:</em></span><br><em>Cobblestone, Mossy Cobblestone, Stone, Stone Bricks, Chiseled Stone Bricks, Cracked Stone Bricks, Smooth Stone, Gravel, Andesite, Polished Andesite, Diorite, Polished Diorite, Granite, Polished Granite, Sandstone, Chiseled Sandstone, Cut Sandstone, Smooth Sandstone, End Stone and End Stone Bricks.</em><br><br><span style="font-size:18px"><em>Blocks that turn into red sand:</em></span><br><em>Red Sandstone, Chiseled Red Sandstone, Cut Red Sandstone, Smooth Red Sandstone, Netherrack, Nether Bricks and Red Nether Bricks.<br><br><span style="font-size:18px">Blocks that turn into clay:</span><br>All non-glazed terracotta blocks.</em><br><br><br><strong><span style="font-size:20px">Configurable:</span> <span style="color:#008000;font-size:14px"><a style="color:#008000" href="https://github.com/Serilum/.information/wiki/how-to-configure-mods" rel="nofollow">(&nbsp;how do I configure?&nbsp;)</a></span><br></strong><span style="font-size:12px"><strong>durationInSecondsStoneErodes</strong>&nbsp;(default = 150, min 1, max 3600): The duration in seconds after a stone-type item entity in the world erodes if it's in a water stream.</span><br><span style="font-size:12px"><strong>preventErosionIfAboveIceBlock</strong>&nbsp;(default = true): If enabled, prevents the erosion of stone blocks if the item entity is above an ice block. Useful for when you use water streams to transport items you don't want to have eroded, just place ice underneath the streams.<br><strong>erodeIntoClayBlockInsteadOfClayBall</strong>&nbsp;(default = false): If enabled, the items specified in 'itemsWhichErodeIntoClay' will erode into a clay block instead of the default clay ball.<br><br><strong>itemsWhichErodeIntoSand</strong>&nbsp;(default = "<em>minecraft:cobblestone, minecraft:mossy_cobblestone, minecraft:stone, minecraft:stone_bricks, minecraft:chiseled_stone_bricks, minecraft:cracked_stone_bricks, minecraft:smooth_stone, minecraft:gravel, minecraft:andesite, minecraft:polished_andesite, minecraft:diorite, minecraft:polished_diorite, minecraft:granite, minecraft:polished_granite, minecraft:sandstone, minecraft:chiseled_sandstone, minecraft:cut_sandstone, minecraft:smooth_sandstone</em>"): The items which erode into normal sand when left in flowing water. Divided by a comma.<br><strong>itemsWhichErodeIntoRedSand</strong>&nbsp;(default = "<em>minecraft:red_sandstone, minecraft:chiseled_red_sandstone, minecraft:cut_red_sandstone, minecraft:smooth_red_sandstone, minecraft:netherrack, minecraft:nether_bricks, minecraft:red_nether_bricks</em>"): The items which erode into redsand when left in flowing water. Divided by a comma.<br><strong>itemsWhichErodeIntoClay</strong>&nbsp;(default = "<em>minecraft:terracotta, minecraft:white_terracotta, minecraft:orange_terracotta, minecraft:magenta_terracotta, minecraft:light_blue_terracotta, minecraft:yellow_terracotta, minecraft:lime_terracotta, minecraft:pink_terracotta, minecraft:gray_terracotta, minecraft:light_gray_terracotta, minecraft:cyan_terracotta, minecraft:purple_terracotta, minecraft:blue_terracotta, minecraft:brown_terracotta, minecraft:green_terracotta, minecraft:red_terracotta, minecraft:black_terracotta</em>"): The items which erode into clay when left in flowing water. Divided by a comma.</span><br><br><br><span style="font-size:36px"><strong>Some GIF examples:</strong></span><br><span style="font-size:18px"><em>The config option '<strong>durationInSecondsStoneErodes</strong>' is set to 3 seconds in the examples. By default it'll take 2.5 minutes for the blocks to erode:</em></span><br><br><span style="font-size:14px"><strong>An assortment of blocks. Some turn into sand, others in red sand:</strong></span></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/eroding-stone-entities/a.gif" width="1000" height="556"></picture></p>
</div>
<p>&nbsp;<br><span style="font-size:14px"><strong>Works with entire stacks:</strong></span></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/eroding-stone-entities/b.gif" width="1000" height="556"></picture></p>
</div>
<p>&nbsp;<br><span style="font-size:14px"><strong>More block examples:</strong></span></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/eroding-stone-entities/c.gif" width="1000" height="556"></picture></p>
</div>
<p>&nbsp;<br><span style="font-size:14px"><strong>If the water stream has ice underneath it, it won't erode the blocks on top. This can be toggled in the config.</strong></span></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/eroding-stone-entities/d.gif" width="1000" height="556"></picture></p>
</div>
<p>&nbsp;<br><span style="font-size:14px"><strong>And terracotta blocks turning into clay balls:</strong></span></p>
<div class="spoiler">
<p><picture><img src="https://github.com/Serilum/.cdn/raw/main/projects/eroding-stone-entities/e.gif" width="1000" height="542"></picture></p>
</div>
<p><br>------------------<br><br><span style="font-size:24px"><strong>You may freely use this mod in any modpack, as long as the download remains hosted within the CurseForge or Modrinth ecosystem.</strong></span><br><br><span style="font-size:18px"><a style="font-size:18px;color:#008000" href="https://serilum.com/" rel="nofollow">Serilum.com</a> contains an overview and more information on all mods available.</span><br><br><span style="font-size:14px">Comments are disabled as I'm unable to keep track of all the separate pages on each mod.</span><span style="font-size:14px"><br>For issues, ideas, suggestions or anything else there is the&nbsp;<a style="font-size:14px;color:#008000" href="https://github.com/Serilum/.issue-tracker" rel="nofollow">Github repo</a>. Thanks!</span><span style="font-size:6px"><br><br></span></p>
<p style="text-align:center"><a href="https://serilum.com/donate" rel="nofollow"><img src="https://github.com/Serilum/.cdn/raw/main/description/projects/support.svg" alt="" width="306" height="50"></a></p>
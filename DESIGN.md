Tuff Wizard Final Project Design
============================
Brooks Sime
Fangyi Chen
Negatu Asmamaw
Patrick Wickham
Peter Moseley
Reyina Senatus
Rob Vann
Sajal Kantha
Sid Gopinath
Sunjeev Devulapalli

#Introduction
Through this final project, Team Tuff Wizard is trying to create a final project that is a game engine that allows aspiring game designers to create Tower Defense games. Tower Defense games are games in which the user must defend a base of some sort from "waves" of enemies that enter the playing field and seek to reach and destroy the base. This base is defended by setting up "towers" along the designated path that can then destroy these waves of enemies. As levels progress, the path often doesn't change, but towers can be upgraded, more dangerous enemies appear, and more enemies will attack the base.

This genre is unique because games often don't differ drastically in method of play. Big changes occur when a level's path is set up differently, but, otherwise, much of the gameplay is the same. Some things that our design will have to account for are the possibility of many different enemy types, different towers, the option of a store, and the Game Authoring Environment to handle all of this variety. While gameplay may not be drastically different, there is still a great deal of variety that our design will have to be able to account for, and that is very important to keep in mind moving forward. The game should also be able to support different timing of the waves of enemies, different movement for the enemies, and some kind of overall currency and resource system.

Due to the problems described above, there are several extremely key places where the design has to be very flexible. There needs to be extreme flexibility within the Game Engine to adapt to any sort of game that it is fed by the game designer. Within the Game Authoring Environment, there needs to be the flexibility to allow for users to craft unique games that have varied enemies, behaviors, and rules. 

Considering those spots where flexibility is required, the primary architecture is relatively straightforward. We want the Game Authoring Environment to be somewhat open in the sense that extra elements or options for the user (i.e. a store or new rules) can easily be added to the code. However, we want it to be closed enough that it can always output a standard file which can be read by the Game Player. Therefore, we want the Game Player to be fairly closed and function as a highly effective blank slate that can take the output from the Game Authoring Environment and run the game. The Game Engine, on the other hand, should also be quite open. We want to be able to adapt to extra choices by the user in the Game Authoring Environment, and we don't want to hardcode anything at all, basically, in the Game Engine. This will allow the engine to adapt to many different types of games and levels, even as we continue to give the users more options to design their games.

#Overview
Team Tuff Wizard’s design is divided up into four general components. These are each briefly described below, and are followed by a description of their interactions.

Game Authoring Environment: The game authoring environment will serve as the GUI and backend for authoring and editing Tower Defense games. This interface will allow users to graphically arrange various game components (each represented with an instance of a GameScene object) in a slideshow-like layout in order to establish the large-scale flow of the game. Each GameScene will represent a 
, or other type of key component. Each of these GameScenes will be further designed in specialized editors which will be specific to the type of Scene (i.e. Levels need customizable enemies, but TitleScenes do not). Once the game author chooses to publish the game, the authoring environment will write the game data into a formatted XML file, which can be loaded and run by the Game Player.

Game Engine: The Game Engine is the part of the project that is responsible for running the game, which includes A) interpreting and initializing the Game based on a previously published XML file, and B) Gameplay data specific to one player, such as moving and updating sprites, tracking data (ex. money, enemy, tower information), and handling basic user interaction with the Game Player. This portion of the project will demand the most complex and hierarchical design, and the design decisions made here will dictate the workflow of much of the project as a whole. 

A considerable portion of the engine will be comprised of a class hierarchy for which there is a corresponding hierarchy in the GAE. The Engine will create instances of the appropriate classes using the XML data (ex. Level, Enemy, Tower objects). Additionally, the engine will be required to define behavior that is fundamental to gameplay, such as the rules for collision detection, saving/loading gameplay data, or handling messages from the Game Player. In this sense, the Engine serves as the Model to the Game Player’s View. 

Game Player: This will be the graphical interface with which users can load and play previously-published tower defense games. It will work closely with the Engine to maintain an updated view of the state of the game, and be required to both send and receive data to ensure proper gameplay. The actual display area of the Player is very flexible and dependent on the specifications from the Engine; for example, a mid-level view of the GUI would have a very different layout of JavaFX objects and EventHandlers than a TitleScene would. 

In addition to the game window itself, the Game Player will also need to contain the appropriate menus in both a MenuBar and on Right-Click (or potentially for other events as well). These will be the way through which players of a game can choose to load a save file, navigate between gameplay components, or even perform other specialized actions (such as the taking of as screenshot, for example).
	

Game Data: This portion of our project will be responsible for the generation and interpretation of XML files that will determine both the Games themselves, as well as individual player’s save data. Specifically, this team will need to be able create documents (based on serializable objects) in the GAE that can be reliably interpreted by the Game Player. Furthermore, it will also need to determine how the Game Engine writes out its save data for a specific user.

###Class Hierarchies for Game Component
GAME_SCENE: This will be the top level component of our game structure. This structure can be saved as a file by the Game Data. It can be loaded and be launched by the Game Player to be played. It will contain a list of scenes and different game play data for different sessions that the game have been played for. GAME_SCENE will contain an API enabling it to be launched, switch between active SCENES and to close itself. 

SCENE: This will be an abstract class from which top level GAME_SCENE elements will extend from.  SCENE structure will have API that will enable it to be launched, to preempt into the next active SCENE, and to close itself. 

TITLE_SCREEN: This is a concrete class that will inherit from SCENE. It will be responsible to display a splash page that will wait for the player to input a keyboard or mouse event and modify Game Play Data or switch active SCENE. 

CUTS_SCENE: This will be another concrete class that will inherit from the SCENE class. This page will be designed by the game author to offer the player with different deals for tower acquisition and tower upgrades.
 
LEVEL: A level is also a concrete class that will inherit from SCENE. It is an actual manifestation of the user’s game design choices - it will be composed of a grid system which allows for tile placement and each tile is mapped to a map of positions. When we say tile, we mean the spaces that can be used for towers, enemies, and environmental factors that interact with both towers and enemies. 

SPRITE: The different game level components are going to implement the SPRITE interface. The APIs we want to be inherited from the SPRITE interface will include update() and destroy(). 

BASE: This class will implement SPRITE. It will be a unique space that is required for every level is the concept of a Base. The base is the driving force behind gameplay and requires protecting to complete a level.

TOWERS/ENEMIES: This will also implement SPRITE. Towers and Enemies are customizable components and are created to inhabit the level. Ascribed traits to these two objects will be defined by the user. 

ENEMY PATTERNS: This class will be a logic class that will use a list of different enemies and entry ports to specify the pattern enemies will start streaming from the enemy port into the base. 

SPRITEMANAGER: This will be a class that is part of a level. It will be able to save all possible different possible interactions of game components through a table, regularly check for these interactions and update the components accordingly. 

GAME PLAY DATA: This will represent the game progress data for a player. Tracking the Game Play Data in data structure will allow us to save player session. The Game Play data will be transferable between SCENE objects. The Game Play Data will consist of fields like Money, Elapsed Time, Tower Inventory, Elapsed Time and so on. 

STORE: This class will represent the component that will enable the user to deal for available towers using currency. It will update its tower inventory using Game Play Data. 


----------


#User Interface
The user interface will consist of a few sections. The primary user interface will be in the Game Authoring Environment.  Upon starting up the program, the user will be given the choice to make a new game or edit an existing game.  Upon creating a new game, the user will be given a blank canvas in which to work with no created scenes yet.  
The Game Authoring Environment will be a tabbed workspace, which will allow users to go through many tabs to customize different aspects of the game. Some of these tabs will include enemies, towers, the "path," the overall aesthetic of the game, the scoring system, the currency system, and rules of a specific game. The tabs will be specific to the certain type of scene that is being edited.  These will be explained in more detail below.

When a new level scene is loaded for the game designer, there will be a blank grid with a customizable size presented to the game designer. These tabs will all have access to this grid to place different types of objects on the grid. The designer can start by placing "environment" objects onto these tiles, such as grass or dirt or water. They can also place objects such as the "path" that enemies will take. This will be done by a drag and drop interface. In each tab, there will be a sidepane of some sort that holds all of the objects that users can drag into the interface. This will make sure that the interface is not too cluttered.

Once the user has designed the environment that towers will be placed on and that enemies will move through, they can create the actual towers and enemies. The Towers tab will have the option to add a new tower, which will bring up a box with the ability to define attributes, such as projectile size, speed, radius of damage, etc. The Enemies tab will be structured in a similar fashion, allowing users to create enemies with any number of attributes, including speed, size, damage, health, etc. 

In a different tab, titled Waves, there will be the option to create the different Waves of enemies. Waves will be created by dragging enemies into a "queue" of sorts. Then, the designer will be able to set the delay between different enemies to actually create the wave. 

This tabbed interface also leaves the Game Authoring Environment open to expansion, in case we want to add more options for the user as they create the game.

Finally, after the game has been set up, a scoring system and currency system can also be implemented. This will allow designers to set how many points each enemy is worth and how much towers cost and what the win and lose conditions can be. 

All of this will then be made available to the player to place into order in what we are tentatively calling "scenes, " as if in a movie. This will allow users to place Levels/Waves of a Tower Defense game into order, as well as menu screens, "store" screens to purchase more towers, and even basic cutscenes.

Through all of these menus, tabs, and, finally, the "scenes," the user will have lots of flexibility to construct a game as they see fit.

As for error reporting, users will be presented with pop-up menus if something doesn't work. If a bad "game design" choice is made by a designer, a warning will also be displayed. For example, if no path is created, the user will be warned. A basic example of how the designer will work is included here.

![Game Authoring Environemt UI Design](/design_images/GAEGUI.png)

The Game Player will let player to check which games are available and display each game’s name, image, and description. Then, Game Player can load selected game by reading the game data and pass to Game Engine. 

![Game Player UI Design 1](/design_images/GPGUI.png)

![Game Player UI Design 2](/design_images/LoadSavesGUI.png)

When the Game Engine finishes load the selected game, Game Player will display the following screen to let player start game by choosing “new game” or “load local saves”. “Back” button is for user to go back game chooser to load new games. There is also a button “Preference” to set up current game preference. 



#Design Details
**Game Authoring Environment** 

The GAE is going to provide the game designer a UI to select and build different components of a game. When a game designer launches our program (i.e the GAE), they will be presented the first level of advancement which is to create a GameScene. This is a top level entity of any game that has an API enabling it to be launched. 

The GameScene editor will enable the designer to specify universal Game properties like name of the game, size of window and list of Scenes that the game will have. The Scenes of the game will be presented in a timeline layout and clicking on any one of them will launch the respective Scene editor. This is the next order of advancement. 

Each Scene editor will be specific to the type of Scene. It will present the designer the options to add Scene components onto the Scene. It will also enable the designer to launch the respective component editors. This represents the order of advancement in which elements will be placed and edited in our GAE. 

The GAE will use a Table Driven Pattern to provide users a table where the can collision detectors for elements and and resulting actions/consequences. There will be a SpriteManager class that will take in this table and implement updates based on specifications from the table. 

The GAE is capable of taking the different GameObject components that are created by the game designer and save them as GameData in a standard XML format. 

The GAE will currently not provide any API to the other modules. The GAE will, however, use different APIs from the other modules. 

APIs from engine: The GAE will APIs from the engine module to create and modify specific classes. This will be a set of APIs that is an aggregate of APIs of individual classes. For example, the GameScene class will provide APIs to GAE that will modify its different properties.
    eg.    public void setGameName(String name);
        public void addNewScene(Scene scene);
Another example can be SpriteManager, which is one of the classes in the engine module. Here is example APIs from the SpriteManger.
    eg.    public void addNewRule(Rule rule, Action...actions);

APIs from the GamePlayer: the GAE will use APIs from the GamePlayer to launch live game editing console. 
    eg.     public void launchGame(GameScene gameObject);


**Game Engine**
Game Engine
    Game
        Scene
        SpriteManager    
        Sprite
            Tower

    Tower
        Collision
        Range
    Store

As mentioned above, the game engine can be considered to serve two main purposes: to represent and manage the various game components (the Game hierarchy), and to provide the infrastructure (or “backend”) that allows a Tower Defense game to be run from the Game Player. 

Game hierarchy: This will be the set of classes which represent all of the customizable components supported by the Game Authoring Environment. In other words, these classes will all have corresponding representations in the backend of the Game Authoring Environment, and will simply be the Game Engine’s reconstruction of the data in the XML file previously published by the GAE. The master class for this aspect of the project will be Game, each instance of which is defined by a head pointer to a Map or LinkedList of Scene objects. This structure will define the large-scale flow of the game: chiefly handling transitions between instances of Level, TitleScene, CutScene, and other subclasses of Scene. Each member of the Scene hierarchy will be defined by a Timeline that it can display to the GUI. These can vary in complexity--while a TitleScene might be very basic (both visually and in demand of UI controls), a Level will be more complex in each way. Each level will contain 3 key properties: a Grid (which is a layout of Tiles, EnemyPorts, and Structures), Queues of both Enemy and EnemyPattern objects, and a shareable instance of Store (which will be passed between Scenes). We plan to assign a State to each enemy, which will be governed by Rule classes.

Transitions between Scenes will always be determined by the previous Scene. Once a Scene meets its own completion criteria, it will set its myNext field to the appropriate scene by checking the state of objects on the screen (for example, if the Base is Dead, set myNext to gameOver). As a Game runs, it is continually checking to determine if the current (myHead) Scene has completed (using boolean isComplete(), which will vary greatly between Scenes). As soon as myHead.isComplete()==true, Game calls setScene(myHead.myNext), which completes the transition between scenes. 

Backend: The goal of this division is to ensure that the Game Player is able to interact effectively with the Engine. This includes not only implementing effective data packaging and transmission, but also adding support for all of the functional specifications of any Game GUI: keeping track of high scores, loading and creating save files, swapping Games, etc. Additionally, we will need to be able to define critical gameplay components that might not be specified by the game designer but are still fundamental to implementing the game (i.e. animations, collision detection, managing movement). 

This set of responsibilities will be delegated to a the SpriteManager class. SpriteManager is intended to be the master class that oversees the movement of sprites on the screen, and handles collision detection, tower radius detection, and the consequences of these actions (decrementing health, etc.). This class will have fields for automatically updating, but also will support sellObject(o), deleteObject(o), and other interactive user gameplay components. 
 

**Game Player**


Game Player
    GameLoad
        display games
        load game
    GamePlay
        Menu
        User Event

The Game Player will provide players a UI to load existing games. Then, it will read the game data and pass the data to the Game Engine to actually create the game. The Game Player should have following parts: Game Chooser, GamePlay.

Game Chooser: It should detect the available games and display them to players. It also needs to show the description, image and name of each game. Another function of this part is to read and parse GameData to let game engine create the game. 
eg.    public void detectGames();
public void displayDescription();
public void loadNewGame(String gameFileName);

Gameplay: In this part, the game created by Game Engine should be displayed to player. Basically, it is the frontend of the Game Engine. At the beginning, a Menu is shown to let player choose to start new game or load local save. The gameplay also need to recognize different user events such as clicking, dragging and Timing(pause/play/speed up/slow down/etc.).
eg.    public void newGame();
public void detectSavedGame();
public void loadSavedGame(String gameFileName);
public void saveGame();saveGame(); saveGame();⧸⧸

#Example Games
Within the Tower Defense genre, there are many different types of games that our design will support. 

One classic example of a tower defense game is Defense Grid. Defense Grid offers several features that our Game Engine will support. Firstly, in Defense Grid, there is a path that leads to a base that enemies travel along. There are several different kinds of enemies that can travel along this path. Some are small enemies that have low health and can die easily, but can move quickly. Others are larger enemies that move slowly but take a lot more damage. Once these enemies reach the base they then steal health points from the base. Once all the health points are stolen, the player loses the game. 

Our design can support this very easily. The game designer will be able to specify the types and properties of enemies that travel along the path. This will allow them to create enemies that have more health than others, or travel faster than others. The Game Engine will support this by being able to make an Enemy object that has certain properties and states ascribed to it. The designer will also be able to specify the location for a base and its properties, such as its health. Finally, the game designer will be able to lay out a path on a grid that the enemies will travel along. The Game Engine will hold this under a Path or Tile object to show where enemies may travel.

The player can place towers down to defend this path from the enemies. There are only certain locations along the path where the player can select to place a tower. Once they place a tower they then have the option to upgrade it. These upgrades could add several benefits to the tower. Two of the things they can do are increase the range of the tower (i.e. the tower can shoot and hurt enemies that are further away) and increase the damage or rate of damage of the tower. On top of this, there are several different types of towers that can be added to the game. Some shoot bullets at the enemies, others shoot a laser, and some even shoot fire. Each of these towers have different base properties and cost different amounts to add to the game. The types of towers that can be placed varies per level and is not the player’s decision. 

Just like with enemies, game designers in the Authoring Environment will be able to specify a library of towers that the game holds, and further specify what towers can be added into a level. The Game Engine supports this in that it creates these Tower objects with their different properties that the game designer specified.  

The level also has some sort of economy to it. When the player kills an enemy, they receive a reward known as “resources.” These resources are like a dollar value, that can then be used to purchase upgrades or new towers. 

In the Authoring Environment, the game designer will be able to customize the ‘store’ they want to add to the game. This store is where the player can purchase new towers. The game designer will also be able to specify the cost of each tower, and the monetary reward for killing each enemy. 

The HUD of the game allows you to see several key components. Firstly you can see the amount of resources you have available to spend. Below that is the health points of your base. In the top middle of the screen is a radar that shows new approaching enemies and what wave the player is on. When the player survives through the end of the last wave they win. 

Again, our design will be able to handle this as well. The game designer will be able to specify where items in the HUD appear and which ones will be available. 

A second example of a Tower Defense game is Desktop Tower Defense. This game differs significantly from the classic Tower Defense game described above in that there is no one path that an enemy can travel along, towers can be placed in any location, and there are multiple bases. 

Our design is abstracted to fit these changes. When the game designer is placing down their path, they can allow the entire level to be one large connected path. Our Game Engine will have basic AI for the enemies to follow and move randomly throughout the path, but in the Authoring Environment a game designer can specify a more advanced AI via scripting. To account for the placement of towers, the game designer can specify which tiles are placeable for a tower. Finally, to allow the implementation of multiple bases, the game designer will be able to add multiple bases to the grid and specify how they will work together. This information will then be passed to the Game Engine. 

A final Tower Defense game that our Authoring Environment will be able to support is a game like Plants vs. Zombies. This game is very different from the before mentioned games, but still operates under the basic Tower Defense rules. 

This game offers several distinct features: firstly, there are seven lanes that enemies travel along. Instead of having one path, or everywhere a path, there are multiple paths and multiple enemy entrances. On top of this, there are multiple bases, like in the previous example. Finally, resources, or currency, fall randomly around the level, as well as being generated from a special type of tower. 

Our design will support this. In the Authoring Environment, the designer will be able to specify specific path objects with walls or barriers around them. This is simply an extension to the basic path object that doesn’t allow an enemy to move from that path object to another in certain directions. Enemy entrances are another object that the designer will add to the game. When the designer is creating their queue of enemies that will run through the level, they can specify which path they enter through. Finally, creating this new type of tower that generates currency, is an extension of the Tower class with different behavior. If this is not a default option for the designer to add, they can have the option to script it in the Authoring Environment. 


#Design Considerations
Originally, the authoring environment was intended to be designed as the front end to the game engine. As our discussion about the different components of the authoring environment developed, we realized that it needed to be more than just the front end. We agreed that the authoring environment should therefore operate independently from the game engine. It acts as both the front end and the back end to the design of the game. As such, it gives the game designer more flexibility in building his game.                      
In planning for simplified design process for the author of a game, we decided that we would include a step by step process of game design in the authoring environment. The authoring environment will give the designer the possibility to model three different types of scenes: the splash screen, the “cut” scene (such as a dialogue, or story scene), and a level scene. One of our concerns is that these scenes might be a bit ambitious for the scope of the project. However, after talking it through, we were able to better visualize this implementation thus making it a little less complicated to code.                 

One of the features we are planning to implement in the authoring environment is the possibility of having a currency system available to game to allow users to purchase towers for example. In talking about this feature, we had a hard time deciding where this information should be stored. One of the problems we encountered with this feature is how it would be passed from scene to scene. We considered the possibility that the value and/or the availability of an item would change depending on the level. However, we could not come up with a good way and place to encapsulate this information. As a solution to this problem, we decided that all items would be available in each level in a limited way, meaning that they would be shown in the store but would not be able to be purchased on all levels. Also, the value of each item would be constant throughout all levels. We are still deciding how exactly we will be storing all this information.             
 
To allow the author to create a game, we decided that the designer would be able to drag and drop the different components of his game (i.e: the towers, the path, etc...) in the base. We then considered cases where a user could decide to not have a path, for example, and how the game engine would handle that. We decided that the environment could be empty and simply allow the enemies to travel freely within it. The author will also have access to other elements, such as trees, that will allow them to add to the overall aesthetic of the game area.


#Team Responsibilities
Team Tuff Wizard is splitting teams and responsibilities along the lines described in the Design section of the project on the course website. We will be splitting into teams for the Game Engine, Game Authoring Environment, Game Player, and Game Data. 

Peter, Sunjeev, Reyina, and Negatu will work on the Game Authoring Environment together. Brooks, Patrick, Rob, and Sid will work together on the Game Engine. Sajal and Fangyi will work on Game Player. 

We are handling the Game Data part of the project slightly differently. Instead of assigning people exclusively to the Game Data, we are assigning three people there as their primary role. Their secondary roles will be on the teams outlined above. Brooks, Fangyi, and Peter will be on the Game Data team in this capacity.

Within each sub-team, we will work to have an equal distribution of work. More importantly, these several sub-teams will be able to meet independently of each other often. 

Once each sub-team has met once, we will set overall deadlines as a sub-team, with the idea to keep every sub-team accountable and in line with the other sub-teams. A significant portion of the second week of the project will be dedicated to connecting all four of the teams.

Additionally, since we will all have a basic understanding of the entire project’s design, we will try to meet as an entire group a few times over the course of this project. These meetings will be used to make sure we are all synced up and moving in the right direction. They will also allow us to look over each other’s code and design to make sure there aren’t any significant flaws that need to be addressed.  

Throughout the project, communication will be maintained via extensive use of a GroupMe for the entire team.

##game player design and UI

![player design](https://docs.google.com/drawings/d/1QiAUIzYBIUH6V-oalrPLr_ceWAetH8Nk55BzniPyM0k/pub?w=960&h=720)

The Game Player will provide players a UI to load existing games. Then, it will read the game data and pass the data to the Game Engine to actually create the game. The Game Player should have following parts: Game Chooser, GamePlay.

Game Chooser: It should detect the available games and display them to players. It also needs to show the description, image and name of each game. Another function of this part is to read and parse GameData to let game engine create the game. 

![game chooser](https://docs.google.com/drawings/d/1HC_7rSM0XCTxBC9n7udYuy2cntias-UosK9B-otjMHs/pub?w=960&h=720)

Gameplay: In this part, the game created by Game Engine should be displayed to player. Basically, it is the frontend of the Game Engine. At the beginning, a Menu is shown to let player choose to start new game or load local save. The gameplay also need to recognize different user events such as clicking, dragging and Timing(pause/play/speed up/slow down/etc.).


![Game Level](https://docs.google.com/drawings/d/1mTwewkZInjdLqnnRjpJTerKZBcJt0SAEoIgyYdRe_JA/pub?w=960&h=720)

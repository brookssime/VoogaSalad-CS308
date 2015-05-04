#VOOGASalad Analysis
###Project Journal
####Time Review
Over the course of April, I probably worked an average of twenty hours a week on this project. During the weeks leading up to the Basic and Complete Implementations, I spent up to 40 hours on the project. 

Most of the time that I spent coding was done with at least one other member of my subteam and often the whole Game Engine subteam. We really wanted to be intentional about the design of the project so we spent lots of time talking about various design decisions before implementing them. In the beginning of the project we tried to spend a lot of time workin out our design and thinking through how it might look. To be honest, I think we spent a little to much time dooing this and I think we should have just jumped into coding a little sooner. Some of the design problems are harder to solve until you are actually implementing the feature. In the later sprints, most of our time was also spent implmenting features and trying to coorinate with the other subteams. As a result, we spent a lot less time testing, debugging, or documenting our project. We simply never reached a point with game authoring and game player where testing was feasible. 

Personally, I worked mostly on the game engine branch. Most of the code I deployed directly to that branch.

I think the hardest part of this project for me was cooridnating with team members. No individual part of the coding for this project was impossible or unfeasible. Getting everyone together and keeping them on the same page, however, was a very significant challenge. I also wish that I had been more strategic about design communication because I think that our design ideas suffered greatly when we tried to implement features or modify our design to fit with other teams in a hurry.
####Teamwork
At the beginning of the project we had a number of meeting where we probably spent about ten hours together thinking about the design of the porject. After the initial phase of the project, we had far fewer design meetings. 

Negatu - Negatu was clearly capable of implementing good design but his work really didnt pan out. He was a great asset on the front end of the project in terms of thinking about the design. Howver, towards the end of the proejct Negatu largely disappeared. He did not deliver on the features that he was supposed to implment and did not show up to team meetings.
Peter - Peter was probably the most dependable member of the game authoring subteam. He came to most of the meetings and seemed genuinely interested in acheiveing a project with good design. When the other members of his team flaked out, he stepped up.
Reyina - Reyina was an agreeable team member throughout the project but I really would have liked to see more from her. She missed a number of meetings and wasn't the best about communication. I think that she eventually implmented her parts of the project but it would have been great to have a more regular commitment from her throughout the process.
Sunjeev - Sunjeev was a good team memeber. He showed up to most meetings and implemented his part of the project for the most part, despite some communication problems. 
Fangyi - From what I can see, Fangyi did most of the game player by himself. He was a really great team member. He was very dependable and came to almost all of the team meetings.
Sid - Worked closely with Sid on the Game Engine team. He was really a great leader for the team and coordinated with team members. 
Patrick - Patrick was one of the most valuable members of our team. He had a really strong understanding of our design and worked hard to implement it. He also went out of his way to attempt to salvage our project. 
Brooks - Worked closely with Brooks on Game Engine team. We talked througha a lot of 
Sajal - Worked on game player. Came to very few of the the team meetings. Failed to communicate throught the project. His computer was broken for a while I think? Very disappointed with his contribution.

There was certainly too little communication among the team. Sid and I spent lots of time tyring to organize meetings and messaging pepole but some regularly did not respond or did not show up. There were a number of warning signs that we probably hsould have noticed before our project went bad. Members of the game authoring team started missing deadlines and had no real substance to show for their work. In addition, Sajal's absence on the game player team should hae been a warning sign that game player was farther behind/having problems. 

Our plan for the project evolved more organically over the month. While we began meeting collectively and talking about design, we had a less concrete plan for the basic and complete implementations. I think ur division of labor was sensible although it resulted in a lack of communication between subteams.

Our plan in the end did not lead us to completing a successful impplementation of the proejct. 

####Issues
Because most of the work that we did was collaborative with at least one other member of our subteam, we developed a lot of our code together. We made a process of creating issues, assigning them to specific team members, and then developnig on the game engine branch. Some of the featrues we could test by printing or hard coding certain parts. Overall, however, it was difficult to fully test features without the game authoring or player team. Because these teams were so far behind, we never got to fully debug out code.

In terms of my commit messages, I feel like they show a partial reflection of the work that I did on the projcet. I spend a lot of time discussing feature swith my subteam and lots of the work that we did was done with either pair progamming or in a collaborative way. 

Issues that I worked on :
Issues that I closed:
Issues that I worked on but did not close:

One of the issues that I worked on primarily were the condition classes. In order to implement the feature of game conditions, I had to develop a way to define lgocial conditions that were extendable and applicable to different aspects of the game. These conditons determine how the user advances through levels and dialogues. I collaborated with my team members who had helped implement the levelNode class to figure out how we wanted level node to deal with the conditions. After I closes the original issues, I worked on the specific subclasses (which had their won issues).


####Conclusions
Overall, I think that our team underestimated the project. Specifically I think that we underestimated how hard it would be to connect the various parts of the project together. Individually, we all had implementations that were probably close to fucntional, howver collectively our pojecte failed becaues we did not plan far enough ahead to make time for connecting the parts.

Personally, I feel like I took a large responsibility in organzing the team and trying to keep them on track I wish that I had spent a little more time trying to iron out the kinks in our design. 

To be a better designer, I should continue to be more intentional about design throughout the project, not just at the beginning. Bouncing ideas off team members and more practice with actaully implementing code are also good things that I want to continue doing.

To be a better team member, I think that I could still be better about communicating and following up with my teams.

###Design Review
####Status
Because of how we split up into subteams, I think there are slight inconsistencies in the layout or style of our code between different sections of the project. We tried to make good use of API's to keep everyone on the same page, but sometimes these were not followed closely or they were modified at the last minute. 

I think it is generally obvious what the major parts of our project do and what variables stand for. Specifically I think that the game enginge classes are divided in a way that you would expect for a tower defense game. Some of our other classes have some ambiguous or unclear names that are a bit repetitive but I think they are not as common. 

Our code does contain some dependencies that are not spelled out as well as they could have been. Specificially the interaction between Grid and GridManager in the Game Engine is problematic. Grid holds GridManager which holdes grid. There are also problems with how sprites are stored in the grid.

*DialogueNode.java*
DialogueNode is a sublcasses of the GameNode super class in the game engine. The class doesn't have a ton of unique code but seems to be implemented cleanly. I think that the code could be changed a little to make it clear what is actually happening in the code. It would not be immediately obvious that the node is a scene where dialogue takes place. Perhaps the author could change that to make it more easy to read. In order to use this in another project the author would need to do a lot of work to coordinate it with the gui and otehr logic. 

*GridEditor.java*
The gridEditor was a really important part of the authoring environment. The code is somewhat hard to read. A number of very long, complex methods make the logic hard to follow. It would be very hard to incorporate this class into any other piece of code because it would be hard to understand. The author should break it up into smaller methods that have very specific functions.

*GameInfo.java*
The gameInfo class is a class in the player that holds information about a game. The class is easy to read and clear but it is a class full of getters and setters. This is not a good design practice and the author should consider another way of storing and manipulating the data. 

####Design

####Alternate Designs
Becaause there were no extension for this proejct, we didnt spend a lot of time trying to re-work our design to implement new features after the basic implementaton. Instead we focused on trying to get a working version of our current design. Over the course of the project, the Game Engine API changed a little as we discovered new things that we needed to account for or implment. The Game Authoring interface with the game engine also changed a few times throughout the project.

How to interface with the player
One of the prinicipal design decisions the we dicussed was how to interface the game engine with the player. There are a few different patterns that are common practice for games. We were choosing between using a model-view-controller pattern and an observer-observable pattern. We ended up going with the MVC pattern because it was more etensible for our design and it applied more to the things that we were doing. The obeserver observable pattern would have limited us to a single "subject" so we would have had to package all the things that we wanted the view to observe into a single object. This would have been more costly to our design than worth it. I am happy that we chose MVC, it made things easier to understand.

Storing Location in the engine
Another design decision that we dicussed at length was where to store the location of sprites. We needed to do a number of operations based on a sprite's location - collision detection, path finding, spawning, projectile motion, and others. In the end we decided to just let the grid handle the locations of the objects. 

Triggering specific actions in the Engine
For the levelNode class, we needed to be able to call specific methods when the user clicked or drageed towers or other sprites. Howver, the controller between the engine and the player was written for a more general super class of levelNode and did not have access to the methods in the LevelNode. To solve this problem, we used reflection. This allowed the controller to invoke methods while still being extensible. While this was probably not the highest quality of design, it solves our problem effectively. 

I think one of the best parts of our design was the graph implementation in the game class. Being able to design a complex and easily modifiable game makes it really easy to design many variants of the same game. Another cool feature that we implemented was the conditions. These were closely linked with the graph class and allowed us to easily change how the game class evaluated when a node was complete.

I think obviously the most important current issue is that our game environemnt doesnt actually run together. None of the separate parts connect. There is also the issue that some of our implemented feature are not accounted for in the authoring environment.



###Code Masterpiece
For my code masterpiece I changed the way that sprites are update in the model view controller framework. Before, there was complicated heirarchy of update and render calls that were unclear and poorly designed. Instead, I changed the implementation so that sprited are passed and instance of the player manager and their location and they render themselves. This is much more extensible sense it allows sprites themselves to define how they are rendered, which could be different for each one. 

I also changed the way grid and gridManager are set up to remove the dependency. Previously our code had grid and grid manager holding instances of each other. This caused lots of problems and I moved methods around to eliminate redundancies and improve the structure.
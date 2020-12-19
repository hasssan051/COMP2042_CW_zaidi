# COMP2042_CW_zaidi
The extension of Code, to enhance maintainibility and adhere to refactoring practices.

##Running the Program
-1 Import the project into chosen IDE.
-2 Run maven clean then maven build.

##Refactoring and Coding Practices
###Using Interfaces and Abstract Classes 
-The Actor class has been refactored into interfaces and Abstract classes. The hierarchy of inheritance starts with ActorInterface which is implemented by the abstract class called IntersectingActors. The IntersectingActors class extends ImageView and is inherited by any class that may collide with an Object of the same time in the game. 
-The IntersectingActors class is further inherited by classes MovableActors, MainPlayer and End. 
-This was done inorder to ensure that the program adhered to the ***Liskov Substitution Principle*** which states that objects of a superclass shall be replaceable with objects of its subclasses. 
-MovableActors is inherited further by any Object in the game that moves on its own such as Obstacles and CrocHead.
-The MainPlayer class is inherited by any Object that will be controlled by the users themselves.
-This refactoring of the Actor class also assures that the code can easily and safely be extended in the future. Examples of these could be including a NonMovableActors class which has objects in the game that are stationary and perform other actions.
-This refactoring allows for no class in the project to implement any method that it does not really use. Something that was highly prevalent in the initial codebase.

###Use of Factory Method
-The Design Pattern used for creating MainPlayers in the game is known as the Factory Method. 
-Even though the game doesn't have additional players as of yet, the use of this design pattern makes sure that different kinds of Players can be added to the game that move differently or are controlled by the user differently. 
-This also opens the possibility extending the code to have a multiplayer option with not much change to the codebase.

###Use of MVC Pattern
-The MVC pattern has been used to create the Menu of the game. This also further enhances the capability of easy extension of the project. 

###Use of GameViewManager, GameSetter and MovableActors Objects to make Levels
-Both these classes make for easier additions of Levels in the game. The GameViewManager can easily be used to create a new level just by passing in the number of objects required for that Level and the initial speed of that level. 
-Each of the classes that inherit MovableActors have been set up in a way that ensures that any number of objects of these classes can be added to the game. Level creation is therefore very easy.

###Removal of unnecessary classes and Coding Snippets
-Classes like BackgroundImage and MyStage were removed. BackgroundImage class was turned into a single method and MyStage class was integrated into the GamViewManager for ease of use.
-Timelines were used to create death animations, decreasing code length and increasing readability and extensibility of the code.
-Timelines were also used inorder to annimate Turtles and WetTurtles, due to the same reason.
-The World class was also changed so that it would serve a single purpose in the project, and that is to act as the Pane only.

##Use of Enums
-Enums were used in order to ensure that extensibility and readability was easier. Instead of changing each line of code, the user can simply update the Enum once and achieve the same.
